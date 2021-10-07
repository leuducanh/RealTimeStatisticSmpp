package viettel.statistic_smpp.broker;

import org.springframework.scheduling.annotation.Scheduled;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import viettel.statistic_smpp.broker.model.ExactlyJobQueue;
import viettel.statistic_smpp.broker.model.WorkerInformation;
import viettel.statistic_smpp.util.PropertyConfiguration;
import viettel.statistic_smpp.util.context.ApplicationContextProvider;

import java.util.*;
import java.util.concurrent.*;

public class ExactlyWorkerSenderProcess extends AbstractWorkerSenderProcess {
    private Map<String, ExactlyJobQueue> cpIdToJobQueue;
    private int coreAmount = 10;
    private int overrun = 10;

    private ExecutorService threadPool = null;
    private ScheduledExecutorService scheduleThreadPool =  Executors.newSingleThreadScheduledExecutor();
    private long TIMEOUT_TO_RESEND;

    public ExactlyWorkerSenderProcess(Queue<ZMsg> workerMessageQueue,
                                      ZMQ.Socket brokerSocket,
                                      List<WorkerInformation> workerAddressList) {
        super(workerMessageQueue, brokerSocket, workerAddressList);
        cpIdToJobQueue = new ConcurrentHashMap<>();

        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        threadPool = new ThreadPoolExecutor(coreAmount, coreAmount + overrun, 1, TimeUnit.MINUTES, linkedBlockingQueue);
        scheduleThreadPool =  Executors.newScheduledThreadPool(1);

        TIMEOUT_TO_RESEND = ((PropertyConfiguration) ApplicationContextProvider.getBean("myProperty")).timeout_to_resent_message;
        scheduleThreadPool.schedule(()->{
            checkTimeoutToResendMessage();
        }, 5 , TimeUnit.SECONDS);
    }

    private void checkTimeoutToResendMessage(){
        Iterator<ExactlyJobQueue> exactlyJobQueueIterator = cpIdToJobQueue.values().iterator();
        while(exactlyJobQueueIterator.hasNext()){
            ExactlyJobQueue exactlyJobQueue = exactlyJobQueueIterator.next();

            if(System.currentTimeMillis() - exactlyJobQueue.getLastTimeAction() > TIMEOUT_TO_RESEND) {
                exactlyJobQueue.reSend(brokerSocket);
            }
        }
    }

    @Override
    protected void receiveResponseFromWorker(ZMsg message) {
        String cpId = message.pop().toString();
        ExactlyJobQueue jobQueue = cpIdToJobQueue.get(cpId);
        threadPool.submit(new ChildSenderThread(jobQueue));
    }


    @Override
    protected void process(ZMsg message) {
        String cpId = message.peek().toString();

        ExactlyJobQueue jobQueue = null;
        if (cpIdToJobQueue.containsKey(cpId)) {
            jobQueue = cpIdToJobQueue.get(cpIdToJobQueue);
            jobQueue.put(message);

            if(jobQueue.getHasAtLestOneSendingSubmit().get() == false) {
                threadPool.submit(new ChildSenderThread(jobQueue));
                jobQueue.getHasAtLestOneSendingSubmit().compareAndSet(false,true);
            }
        } else {
            jobQueue = new ExactlyJobQueue(workerAddressList);
            jobQueue.put(message);
            cpIdToJobQueue.put(cpId, jobQueue);
            jobQueue.send(brokerSocket);
        }
    }

    @Override
    protected void onError() {
    }

    public static class ChildSenderThread implements Runnable {

        private ExactlyJobQueue exactlyJobQueue;

        public ChildSenderThread(ExactlyJobQueue exactlyJobQueue) {
            this.exactlyJobQueue = exactlyJobQueue;
        }

        @Override
        public void run() {
            exactlyJobQueue.checkAndSendAndSetStatus(false, brokerSocket);
        }
    }
}
