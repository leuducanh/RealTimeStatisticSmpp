package viettel.statistic_smpp.broker;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ExactlyWorkerSenderProcess extends AbstractWorkerSenderProcess{

    private Map<String, LinkedBlockingQueue> jobNameToJobQueue;
    private ExecutorService threadPool = null;

    private int coreAmount = 10;
    private int overrun = 10;


    private ExecutorService scheduleThreadFor =  Executors.newSingleThreadScheduledExecutor();

    public ExactlyWorkerSenderProcess(BlockingQueue<ZMsg> workerMessageQueue, ZMQ.Socket brokerSocket, List<ZFrame> workerAddressList) {
        super(workerMessageQueue, brokerSocket, workerAddressList);
        jobNameToJobQueue = new ConcurrentHashMap<>();

        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        threadPool = new ThreadPoolExecutor(coreAmount, coreAmount + overrun, 1, TimeUnit.MINUTES, linkedBlockingQueue);
//        scheduleThreadPool =  Executors.scheduleAtFixedRate(runnableTask, 100, 450, TimeUnit.MILLISECONDS);


    }



    @Scheduled(fixedDelay = 1000)
    private void test() {
        System.out.println("abc");
    }

    @Override
    protected void process(ZMsg message) {
        String nameJob = message.pop().toString();
        if(jobNameToJobQueue.containsKey(nameJob)) {
            jobNameToJobQueue.get(jobNameToJobQueue).add(message);
        }else{
            LinkedBlockingQueue<ZMsg> linkedBlockingQueue = new LinkedBlockingQueue<>();
            linkedBlockingQueue.add(message);
            jobNameToJobQueue.put(nameJob, linkedBlockingQueue);

        }
    }



    @Override
    protected void onError() {

    }

    public static void main(String[] args) {
        ExecutorService threadPool = null;
        int coreAmount = 2;
        int overrun = 100;


        ArrayBlockingQueue<Runnable> l = new ArrayBlockingQueue<Runnable>(5);

        threadPool = new ThreadPoolExecutor(coreAmount, coreAmount + overrun, 1, TimeUnit.MINUTES, l);

        for(int  i = 0;i < 100;i++) {
            threadPool.submit(new ABC(i));
            System.out.println("size" + l.size());
        }
    }

    public static class ABC implements Runnable {

        int i;

        public ABC(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(i);

            try {
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("xong " + i);
        }
    }
}
