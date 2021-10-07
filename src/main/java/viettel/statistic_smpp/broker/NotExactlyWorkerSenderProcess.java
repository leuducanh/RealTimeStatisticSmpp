package viettel.statistic_smpp.broker;

import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import viettel.statistic_smpp.broker.model.WorkerInformation;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class NotExactlyWorkerSenderProcess extends AbstractWorkerSenderProcess{

    public NotExactlyWorkerSenderProcess(Queue<ZMsg> workerMessageQueue, ZMQ.Socket brokerSocket, List<WorkerInformation> workerAddressList) {
        super(workerMessageQueue, brokerSocket, workerAddressList);
    }

    @Override
    protected void receiveResponseFromWorker(ZMsg zMsg) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void process(ZMsg message) {
        ZFrame zFrame = message.peek();
        int cpId = Integer.parseInt(zFrame.toString());
        message.wrap(workerAddressList.get(cpId%workerAddressList.size()).workerAddress.duplicate());
        message.send(brokerSocket);
    }

    @Override
    protected void onError() {

    }
}
