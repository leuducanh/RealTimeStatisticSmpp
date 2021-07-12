package viettel.statistic_smpp.broker.model;

import org.zeromq.ZFrame;

public class WorkerInformation {

    public String serviceName;
    public ZFrame workerAddress;
    public boolean isExactlyWorker = false;

    public WorkerInformation(String serviceName, ZFrame workerAddress) {
        this.serviceName = serviceName;
        this.workerAddress = workerAddress;
    }
}
