package viettel.statistic_smpp.broker.model;

import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import util.id_generator.IdDecode;
import util.id_generator.IdGenerator;
import util.id_generator.IdStructure;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExactlyJobQueue {

    private static IdStructure idStructure = new IdStructure(40, 0, 23);
//    private static IdDecode idDecode = new IdDecode(idStructure);

    private LinkedBlockingQueue<ZMsg> jobQueue;
    private ZMsg lastSentMessage;
    private long lastTimeAction = -1;
    private int status = NOT_WAIT_ANYTHING;
    private int resendCountDown = 3;
    // tránh trường hợp submit nhiều yêu cầu gửi vào pool , chỉ cần 1 để trigger
    // không cần khi đang wait.
    private AtomicBoolean hasAtLestOneSendingSubmit = new AtomicBoolean(false);

    private void resetResendCountDown() {
        resendCountDown = 3;
    }

    public boolean reSend(ZMQ.Socket brokerSocket) {
        if (resendCountDown > 0) {
            resendCountDown--;
            send(brokerSocket, lastSentMessage);
            return true;
        }
        return false;
    }

    public AtomicBoolean getHasAtLestOneSendingSubmit() {
        return hasAtLestOneSendingSubmit;
    }

    public ZMsg getLastSentMessage() {
        return lastSentMessage;
    }

    public long getLastTimeAction() {
        return lastTimeAction;
    }

    public static final int NOT_WAIT_ANYTHING = 0;
    public static final int WAIT_RESPONSE = 1;
    private IdGenerator idGenerator;

    private Object lock = new Object();
    private List<WorkerInformation> workerAddressList = null;

    public ExactlyJobQueue(List<WorkerInformation> workerAddressList) {
        this.workerAddressList = workerAddressList;
        lastTimeAction = System.currentTimeMillis();
        this.jobQueue = new LinkedBlockingQueue<>();
        try {
            idGenerator = new IdGenerator(idStructure, null);
        } catch (ParseException e) {
            //todo: ghi ra
            e.printStackTrace();
        }
    }

    public synchronized void checkAndSendAndSetStatus(boolean thisActionIsFromWorkerResponse, ZMQ.Socket brokerSocket) {
        if (thisActionIsFromWorkerResponse) {
            if (status == WAIT_RESPONSE) {
                resetResendCountDown();
                boolean hasSent = send(brokerSocket);
                if (!hasSent) {
                    lastSentMessage = null;
                }
            }
        } else {
            if (status == NOT_WAIT_ANYTHING) {
                send(brokerSocket);
            }
            hasAtLestOneSendingSubmit.compareAndSet(true, false);
        }
    }

    public void put(ZMsg zMsg) {
        jobQueue.add(zMsg);
    }

    public synchronized ZMsg poll() {
        return jobQueue.poll();
    }

    public boolean send(ZMQ.Socket brokerSocket) {
        ZMsg message = poll();
        return send(brokerSocket, message);
    }

    public boolean send(ZMQ.Socket brokerSocket, ZMsg message) {
        if (message != null) {
            ZFrame idFrame = new ZFrame(String.valueOf(idGenerator.generate()));
            int cpId = Integer.parseInt(message.poll().toString());
            message.addFirst(idFrame);
            message.wrap(workerAddressList.get(cpId % workerAddressList.size()).workerAddress.duplicate());
            lastSentMessage = message;
            lastTimeAction = System.currentTimeMillis();
            message.send(brokerSocket);
            status = WAIT_RESPONSE;
            return true;
        } else {
            status = NOT_WAIT_ANYTHING;
        }
        return false;
    }

    public int size() {
        return jobQueue.size();
    }
}
