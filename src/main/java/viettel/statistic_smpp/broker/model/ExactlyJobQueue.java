package viettel.statistic_smpp.broker.model;

import org.zeromq.ZMsg;

import java.util.concurrent.LinkedBlockingQueue;

public class ExactlyJobQueue {

    private LinkedBlockingQueue<ZMsg> jobQueue;
    private long lastTimeAction = -1;

    public ExactlyJobQueue(LinkedBlockingQueue<ZMsg> jobQueue) {
        lastTimeAction = System.currentTimeMillis();
        this.jobQueue = jobQueue;
    }

    public void put(ZMsg zMsg){
        lastTimeAction = System.currentTimeMillis();
        jobQueue.add(zMsg);
    }

    public ZMsg poll() {
        lastTimeAction = System.currentTimeMillis();
        return jobQueue.poll();
    }
}
