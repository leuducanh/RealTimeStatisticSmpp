package viettel.statistic_smpp.broker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zeromq.*;
import viettel.statistic_smpp.broker.model.WorkerInformation;
import viettel.statistic_smpp.broker.model.builder.BrokerMessageBuilder;
import viettel.statistic_smpp.broker.util.BrokerConstant;
import viettel.statistic_smpp.util.Constants;
import viettel.statistic_smpp.util.PropertyConfiguration;
import viettel.statistic_smpp.util.Protocol;
import viettel.statistic_smpp.util.context.ApplicationContextProvider;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Broker {
    private static final int HEARTBEAT_LIVENESS = 3;
    private static final int HEARTBEAT_INTERVAL = 2500;
    private static final int HEARTBEAT_EXPIRY = HEARTBEAT_INTERVAL * HEARTBEAT_LIVENESS;

    private String brokerAddressString;
    private ZContext ctx;
    private ZMQ.Socket socketBroker;

    private long heartbeatAt;
    private ExecutorService threadPool = Executors.newFixedThreadPool(1);
    Logger logger = LogManager.getLogger(Broker.class);

    private ConcurrentHashMap<String, List<WorkerInformation>> serviceTypeToWorkerInformationList;

    private List<WorkerInformation> exactlyWorkerInformationList;
    private List<WorkerInformation> notExactlyWorkerInformationList;

    private volatile BitSet waitSyncDataToRedisResponseFromOldWorker;

//    private BlockingQueue<ZMsg> eventWaitingForBalanceQueue = new LinkedBlockingQueue<>();

    private int state = BrokerConstant.INIT;

    private static final long TIMEOUT_WAIT_RESEND_SYNC_DATA_STORAGE = 5 * Constants.MINUTE;
    private static final long MAX_TIME_RESEND_SYNC_DATA_STORAGE = 1;

    private static final long TIMEOUT_WAIT_RESEND_WAITING_BALANCE = 5 * Constants.MINUTE;
    private static final long MAX_TIME_RESEND_WAITING_BALANCE = 5 * Constants.MINUTE;

    private Queue<ZMsg> exactlyEventFromClientQueue = new LinkedBlockingQueue<>();
    private Queue<ZMsg> notExactlyEventFromClientQueue = new LinkedBlockingQueue<>();
    private long numberDefaultWorker;

    private AbstractWorkerSenderProcess exactlyWorkerSenderProcess;
    private AbstractWorkerSenderProcess notExactlyWorkerSenderProcess;

    private AtomicInteger numberOfCurrentWorker = new AtomicInteger(0);
//    private int state = ;
//    private

    public Broker(String brokerAddressString) {
        this.brokerAddressString = brokerAddressString;
        this.ctx = new ZContext();
        this.socketBroker = ctx.createSocket(SocketType.ROUTER.type());
        this.socketBroker.bind(brokerAddressString);

        serviceTypeToWorkerInformationList = new ConcurrentHashMap<>();
        state = BrokerConstant.RUNNING;


        exactlyWorkerInformationList = new ArrayList<>();
        notExactlyWorkerInformationList = new ArrayList<>();

        exactlyWorkerSenderProcess = new ExactlyWorkerSenderProcess(exactlyEventFromClientQueue, socketBroker, exactlyWorkerInformationList);
        notExactlyWorkerSenderProcess = new NotExactlyWorkerSenderProcess(notExactlyEventFromClientQueue, socketBroker, notExactlyWorkerInformationList);
        numberDefaultWorker = ((PropertyConfiguration) ApplicationContextProvider.getBean("myProperty")).timeout_to_resent_message;
    }

    public void middleManDancing() {
        int i = 0;
        ZMQ.Poller items = ctx.getContext().poller(1);
        items.register(socketBroker, ZMQ.Poller.POLLIN);

        while (true) {
            if (items.poll(HEARTBEAT_INTERVAL) == -1)
                break;
            ZMsg zMsg = new ZMsg();
            if (items.pollin(0)) {
                ZMsg msg = ZMsg.recvMsg(socketBroker);
                logger.debug(msg != null ? msg.toString() : "null");

                if (msg != null) {
                    ZFrame senderAddress = msg.unwrap();
                    ZFrame header = msg.pop();
//                    ZFrame serviceName = msg.pop();

                    if (header.equals(Protocol.CLIENT)) {
                        processClientRequest(senderAddress, zMsg);
                    } else if (header.equals(Protocol.WORKER)) {
                        processWorkerRequest(senderAddress, zMsg);
                    }
                }

//                if (clientAddress == null) {
//
//
//                    if (msg != null) {
//                        System.out.println("tin den");
//                        clientAddress = msg.unwrap();
//                    }
//                } else {
//                    i++;
//                    System.out.println("address " + clientAddress.toString());
//
//                    zMsg.addFirst(new ZFrame("" + i));
//                    zMsg.addFirst(new byte[0]);
//                    zMsg.addFirst(clientAddress.duplicate());
//                    zMsg.send(socketBroker);
//                }

//            }
            }
        }
    }

    private void processWorkerRequest(ZFrame senderAddress, ZMsg messageFromWorker) {
        ZFrame command = messageFromWorker.pop();

        if (Protocol.REGISTER.equalsValue(command)) {

            int size = numberOfCurrentWorker.incrementAndGet();

            try {
                // lấy thông tin về yêu cầu độ chính xác của job.
                String serviceType = messageFromWorker.pop().toString();
//               List<WorkerInformation> existWorkerInformationList = serviceTypeToWorkerInformationList.get(serviceType);

                WorkerInformation newRegisterWorkerInformation = new WorkerInformation(senderAddress);
                if (Protocol.EXACTLY.equalsValue(serviceType)) {
                    newRegisterWorkerInformation.position = exactlyWorkerInformationList.size();
                    newRegisterWorkerInformation.isExactlyWorker = true;
                    exactlyWorkerInformationList.add(newRegisterWorkerInformation);

                    sendSyncCurrentDataToStorage(serviceType);
                } else {
                    newRegisterWorkerInformation.position = exactlyWorkerInformationList.size();
                    newRegisterWorkerInformation.isExactlyWorker = false;
                    notExactlyWorkerInformationList.add(newRegisterWorkerInformation);
                }
            } catch (Exception e) {

            }
        } else if (Protocol.SYNC_DATA_TO_STORAGE_RESPONSE.equalsValue(command)) {

            if (state != BrokerConstant.WAITING_SYNC_DATA_TO_STORAGE) {
                return;
            }

            ZFrame result = messageFromWorker.pop();

            if (Protocol.OK.equalsValue(result)) {

            } else if (Protocol.ERROR.equalsValue(result)) {


            }
        } else if (Protocol.WORKER_RESPONSE.equalsValue(command)) {
            exactlyWorkerSenderProcess.receiveResponseFromWorker(messageFromWorker);
        }
    }


    private void sendSyncCurrentDataToStorage(String serviceType) {
        state = BrokerConstant.WAITING_SYNC_DATA_TO_STORAGE;

        waitSyncDataToRedisResponseFromOldWorker = new BitSet(exactlyWorkerInformationList.size() - 1);

        for (WorkerInformation workerInformation : exactlyWorkerInformationList) {
            ZMsg zMsg = BrokerMessageBuilder.builder()
                    .toReceiverAddress(workerInformation.workerAddress.duplicate())
                    .command(Protocol.SYNC_DATA_TO_STORAGE.newFrame())
                    .build();
            zMsg.send(socketBroker);

            // set list bit to true
            waitSyncDataToRedisResponseFromOldWorker.set(workerInformation.position, true);
        }
    }


    private void processClientRequest(ZFrame senderAddress, ZMsg messageFromClient) {
        ZFrame command = messageFromClient.pop();


        if(Protocol.REQUEST.equalsValue(command)) {
            ZFrame requestType = messageFromClient.pop();
            if(Protocol.EXACTLY.equalsValue(requestType)) {
                exactlyEventFromClientQueue.add(messageFromClient);
            } else {
                notExactlyEventFromClientQueue.add(messageFromClient);
            }
        }
    }

    public class ResendMessageTask implements Runnable {

        @Override
        public void run() {
            checkAndResendMessage();
        }
    }

    private void checkAndResendMessage() {
        while (true) {
            boolean allMessageHaveResponse
                    = waitSyncDataToRedisResponseFromOldWorker.cardinality() == waitSyncDataToRedisResponseFromOldWorker.size();
            if (state == BrokerConstant.WAITING_SYNC_DATA_TO_STORAGE && allMessageHaveResponse == false) {
                for (WorkerInformation workerInformation : exactlyWorkerInformationList) {

                }
            } else {
                return;
            }
        }
    }
}
