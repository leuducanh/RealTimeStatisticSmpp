package viettel.statistic_smpp.broker.model;

import org.zeromq.ZFrame;

import java.util.concurrent.locks.ReentrantLock;

public class WorkerInformation {
    public ZFrame workerAddress;
    public boolean isExactlyWorker = false;

    public WorkerInformation(ZFrame workerAddress) {
        this.workerAddress = workerAddress;
    }
}
