package viettel.statistic_smpp.work;

import org.zeromq.ZMsg;
import util.id_generator.IdDecode;
import util.id_generator.IdStructure;
import viettel.statistic_smpp.work.dto.result_statistic.QtyMessagePerSessionResult;
import viettel.statistic_smpp.work.dto.result_statistic.SmscActiveResult;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ExactlyWorkerProcessorManager extends WorkerProcessorManager {

    private IdDecode idDecode;

    private ConcurrentHashMap<String, SmscActiveResult> commandToSmscActiveResult;
    private ConcurrentHashMap<String, QtyMessagePerSessionResult> commandToQtyMessagePerSessionResult;

    public ExactlyWorkerProcessorManager(BlockingQueue<ZMsg> events) {
        super("ExactlyWorkerProcessorManager", events);
        IdStructure idStructure = new IdStructure(40, 0, 23);
        idDecode = new IdDecode(idStructure);
    }

    @Override
    protected void process() {
        try {
            long sleepTime = SLEEP_TIME;
            ZMsg event = events.poll(1l, TimeUnit.SECONDS);

            if (event != null) {
                threadPool.submit(new ChildSummitedThread(event));
            } else {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ex) {
                    logger.error("error ExactlyWorkerProcessorManager: " + ex.getMessage(), ex);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processEvent(ZMsg event) {
        long idGen = Long.parseLong(event.poll().toString());
//        long[] idsDecoded = idDecode.decode(idGen);
//        long cpId = Long.parseLong(event.poll().toString());
        byte[] request = event.poll().getData();


    }

    public class ChildSummitedThread implements Runnable {

        private ZMsg requestMessage;

        public ChildSummitedThread(ZMsg requestMessage) {
            this.requestMessage = requestMessage;
        }

        @Override
        public void run() {
            processEvent(requestMessage);
        }
    }
}
