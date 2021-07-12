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
        reentrantLock = new ReentrantLock(true);
    }

    private void add(WorkerInformation workerInformation) {
        boolean tryLockSuccess = reentrantLock.tryLock();
        try {
            if (tryLockSuccess) {
                reentrantLock.lock();
                workerInformationList.add(workerInformation);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private void remove(int pos) {
        boolean tryLockSuccess = reentrantLock.tryLock();
        try {
            if (tryLockSuccess) {
                reentrantLock.lock();
                workerInformationList.remove(pos);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private WorkerInformation get(int pos) {
        boolean tryLockSuccess = reentrantLock.tryLock();
        WorkerInformation workerInformation = null;
        try {
            if (tryLockSuccess) {
                reentrantLock.lock();
                return workerInformation = workerInformationList.get(pos);
            }
        } finally {
            reentrantLock.unlock();
        }

        return null;
    }
}
