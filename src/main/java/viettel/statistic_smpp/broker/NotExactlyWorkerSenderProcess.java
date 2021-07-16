package viettel.statistic_smpp.broker;

import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class NotExactlyWorkerSenderProcess extends AbstractWorkerSenderProcess{

    public NotExactlyWorkerSenderProcess(BlockingQueue<ZMsg> workerMessageQueue, ZMQ.Socket brokerSocket, List<ZFrame> workerAddressList) {
        super(workerMessageQueue, brokerSocket, workerAddressList);
    }

    @Override
    protected void process(ZMsg message) {
        ZFrame zFrame = message.peek();
        int cpId = Integer.parseInt(zFrame.toString());
        message.wrap(workerAddressList.get(cpId%workerAddressList.size()));
        message.send(brokerSocket);
    }

    @Override
    protected void onError() {

    }
}
