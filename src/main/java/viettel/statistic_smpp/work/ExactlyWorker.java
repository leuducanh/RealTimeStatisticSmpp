package viettel.statistic_smpp.work;

import org.zeromq.ZFrame;
import org.zeromq.ZMsg;
import viettel.statistic_smpp.util.Protocol;

import java.util.concurrent.*;

public class ExactlyWorker extends Worker {


    public ExactlyWorker(String urlConnectionBrokerForWorker) {
        super(urlConnectionBrokerForWorker);
    }



    @Override
    protected boolean checkHeader(ZFrame header) {
        if (Protocol.EXACTLY.equals(header)) {
            return true;
        }
        return false;
    }
}
