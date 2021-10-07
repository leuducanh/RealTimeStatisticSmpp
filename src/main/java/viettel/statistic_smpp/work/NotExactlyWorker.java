package viettel.statistic_smpp.work;

import org.zeromq.ZFrame;
import org.zeromq.ZMsg;
import viettel.statistic_smpp.broker.model.ExactlyJobQueue;
import viettel.statistic_smpp.util.Protocol;

public class NotExactlyWorker extends Worker {
    public NotExactlyWorker(String urlConnectionBrokerForWorker) {
        super(urlConnectionBrokerForWorker);
    }


    @Override
    protected boolean checkHeader(ZFrame header) {
        if (Protocol.NOT_EXACTLY.equals(header)) {
            return true;
        }
        return false;
    }
}
