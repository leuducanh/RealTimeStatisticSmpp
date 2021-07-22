package viettel.statistic_smpp.broker;

import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractWorkerSenderProcess extends Thread{

    protected BlockingQueue<ZMsg> workerMessageQueue;

    protected ZMQ.Socket brokerSocket;

    private static long TIME_SLEEP_WHEN_NOT_HAVE_MESSAGE = 500;
    private static long TIME_SLEEP_WHEN_HAVE_MESSAGE = 100;
    protected List<ZFrame> workerAddressList = null;

    public AbstractWorkerSenderProcess(BlockingQueue<ZMsg> workerMessageQueue, ZMQ.Socket brokerSocket, List<ZFrame> workerAddressList) {
        this.workerMessageQueue = workerMessageQueue;
        this.brokerSocket = brokerSocket;
        this.workerAddressList = workerAddressList;
    }

    @Override
    public void run() {
        super.run();

        while(!Thread.currentThread().isInterrupted()) {
            ZMsg message = workerMessageQueue.poll();

            if(message != null) {
                try{
                    process(message);
                }catch (Exception e) {
                    onError();
                }
//                try {
//                    Thread.sleep(TIME_SLEEP_WHEN_HAVE_MESSAGE);
//                } catch (InterruptedException e) {
                    System.out.println(workerMessageQueue.size());
//                }
            } else {
                try {
                    Thread.sleep(TIME_SLEEP_WHEN_NOT_HAVE_MESSAGE);
                } catch (InterruptedException e) {
                    System.out.println(workerMessageQueue.size());
                }
            }

        }

    }

    protected abstract void process(ZMsg message);

    protected abstract void onError();


}
