package viettel.statistic_smpp.broker;

import viettel.statistic_smpp.broker.model.WorkerInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WorkerManager {
    public List<WorkerInformation> workerInformationList;

    private ReentrantLock reentrantLock;

    public WorkerManager() {
        this.workerInformationList = new ArrayList<>();
    }

    private void add(WorkerInformation workerInformation) {
        workerInformationList.add(workerInformation);
    }

    private void remove(int pos) {
        workerInformationList.remove(pos);
    }

    private WorkerInformation get(int pos) {
        workerInformationList.get(pos);
    }
}
