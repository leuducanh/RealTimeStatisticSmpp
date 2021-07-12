package viettel.statistic_smpp.broker.model;

import org.zeromq.ZFrame;

import java.util.concurrent.locks.ReentrantLock;

public class WorkerInformation {

    public String serviceName;
    public ZFrame workerAddress;
    public boolean isExactlyWorker = false;

    public WorkerInformation(String serviceName, ZFrame workerAddress) {
        this.serviceName = serviceName;
        this.workerAddress = workerAddress;
    }

}
