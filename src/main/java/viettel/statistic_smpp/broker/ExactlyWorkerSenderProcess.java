package viettel.statistic_smpp.broker;

import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ExactlyWorkerSenderProcess extends AbstractWorkerSenderProcess{

//    private Map<String, >

    public ExactlyWorkerSenderProcess(BlockingQueue<ZMsg> workerMessageQueue, ZMQ.Socket brokerSocket, List<ZFrame> workerAddressList) {
        super(workerMessageQueue, brokerSocket, workerAddressList);
    }

    @Override
    protected void process(ZMsg message) {

    }

    @Override
    protected void onError() {

    }
}
