package viettel.statistic_smpp.broker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zeromq.*;
import viettel.statistic_smpp.broker.model.WorkerInformation;
import viettel.statistic_smpp.broker.model.builder.BrokerMessageBuilder;
import viettel.statistic_smpp.broker.util.BrokerConstant;
import viettel.statistic_smpp.util.Constants;
import viettel.statistic_smpp.util.Protocol;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.*;

public class Broker {
    private static final int    HEARTBEAT_LIVENESS      = 3;
    private static final int    HEARTBEAT_INTERVAL      = 2500;
    private static final int    HEARTBEAT_EXPIRY        = HEARTBEAT_INTERVAL * HEARTBEAT_LIVENESS;

    private String brokerAddressString;
    private ZContext ctx;
    private ZMQ.Socket socketBroker;

    private long heartbeatAt;
    private ExecutorService threadPool = Executors.newFixedThreadPool(1);
    Logger logger =  LogManager.getLogger(Broker.class);

    private ConcurrentHashMap<String, List<WorkerInformation>> serviceNameToWorkerInformationList;
    private ConcurrentHashMap<String, Integer> serviceNameToPriorityType;

    private volatile BitSet waitSyncDataToRedisResponseFromOldWorker;

    private BlockingQueue<ZMsg> eventWaitingForBalanceQueue = new LinkedBlockingQueue<>();

    private int state = BrokerConstant.INIT;

    private static final long TIMEOUT_WAIT_RESEND_SYNC_DATA_STORAGE = 5 * Constants.MINUTE;
    private static final long MAX_TIME_RESEND_SYNC_DATA_STORAGE = 1;

    private static final long TIMEOUT_WAIT_RESEND_WAITING_BALANCE = 5 * Constants.MINUTE;
    private static final long MAX_TIME_RESEND_WAITING_BALANCE = 5 * Constants.MINUTE;




    public Broker(String brokerAddressString) {
        this.brokerAddressString = brokerAddressString;
        this.ctx = new ZContext();
        this.socketBroker = ctx.createSocket(SocketType.ROUTER.type());
        this.socketBroker.bind(brokerAddressString);

        serviceNameToWorkerInformationList = new ConcurrentHashMap<>();
        serviceNameToPriorityType = new ConcurrentHashMap<>();

        state = BrokerConstant.RUNNING;
    }

    public void middleManDancing() {
        int i = 0;
        ZMQ.Poller items = ctx.getContext().poller(1);
        items.register(socketBroker, ZMQ.Poller.POLLIN);

        ZFrame clientAddress = null;
        while (true) {
            if (items.poll(HEARTBEAT_INTERVAL) == -1)
                break;
            ZMsg zMsg = new ZMsg();
            if (items.pollin(0)) {
                ZMsg msg = ZMsg.recvMsg(socketBroker);
                logger.debug(msg != null ? msg.toString() : "null");

                if(msg != null) {
                    ZFrame senderAddress = msg.unwrap();
                    ZFrame header = msg.pop();
//                    ZFrame serviceName = msg.pop();

                    if(header.equals(Protocol.CLIENT)) {
                        processClientRequest(senderAddress, zMsg);
                    } else if(header.equals(Protocol.WORKER)) {
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

    private void processWorkerRequest(ZFrame senderAddress, ZMsg zMsg) {
        ZFrame command = zMsg.pop();

        if(command.equals(Protocol.REGISTER)) {
           try {
               // lấy thông tin về yêu cầu độ chính xác của job.
               ZFrame priorityFrame = zMsg.pop();
               int priority = Integer.parseInt(priorityFrame.toString());
               String serviceName = zMsg.pop().toString();
               List<WorkerInformation> existWorkerInformationList = serviceNameToWorkerInformationList.get(serviceName);

               // cho worker vào danh sách
               WorkerInformation newRegisterWorkerInformation = new WorkerInformation(senderAddress);
               if(existWorkerInformationList == null) {
                   List<WorkerInformation> workerInformationList = new ArrayList<>();

                   workerInformationList.add(newRegisterWorkerInformation);
                   serviceNameToPriorityType.put(serviceName, priority);
                   serviceNameToWorkerInformationList.put(serviceName,workerInformationList);
                   newRegisterWorkerInformation.position = 0;
               } else{
                   sendSyncCurrentDataToStorage(serviceName);

                   newRegisterWorkerInformation.position = existWorkerInformationList.size();
                   existWorkerInformationList.add(newRegisterWorkerInformation);
               }

           }catch (Exception e) {

           }
        } else if(command.equals(Protocol.SYNC_DATA_TO_STORAGE_RESPONSE)) {

            if(state != BrokerConstant.WAITING_SYNC_DATA_TO_STORAGE) {
                return;
            }

            ZFrame result = zMsg.pop();

            if(result.equals(Protocol.OK)) {


            } else if(result.equals(Protocol.ERROR)) {


            }
        }
    }



    private void sendSyncCurrentDataToStorage(String serviceName) {
        state = BrokerConstant.WAITING_SYNC_DATA_TO_STORAGE;
        List<WorkerInformation> workerInformationList = serviceNameToWorkerInformationList.get(serviceName);
        waitSyncDataToRedisResponseFromOldWorker = new BitSet(workerInformationList.size() - 1);

        for(WorkerInformation workerInformation : workerInformationList) {
            ZMsg zMsg = BrokerMessageBuilder.builder()
                    .toReceiverAddress(workerInformation.workerAddress.duplicate())
                    .command(Protocol.SYNC_DATA_TO_STORAGE.newFrame())
                    .build();
            zMsg.send(socketBroker);

            // set list bit to true
            waitSyncDataToRedisResponseFromOldWorker.set(workerInformation.position, true);
        }
    }



    private void processClientRequest(ZFrame senderAddress, ZMsg zMsg) {

    }

    public class


}
