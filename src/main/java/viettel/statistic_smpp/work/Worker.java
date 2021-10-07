package viettel.statistic_smpp.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zeromq.*;
import viettel.statistic_smpp.util.PropertyConfiguration;
import viettel.statistic_smpp.util.Protocol;
import viettel.statistic_smpp.util.context.ApplicationContextProvider;
import zmq.Msg;

import java.util.concurrent.*;

public abstract class Worker {
    protected static Logger logger = LogManager.getLogger(Worker.class);
    protected static final int HEARTBEAT_LIVENESS = 3; // 3-5 is reasonable
    protected static final long HEARTBEAT_INTERVAL = 2500;

    protected static final long POLL_TIMEOUT =2500;

    protected String workerAddressString;
    protected ZMQ.Socket workerSocket;
    protected long heartbeat;
    protected long waitBrokerSideBeforeReconnect = 2500;
    protected boolean expectReply = false;

    protected ZContext workerContext;

    protected long heartbeatAt;
    protected int liveness;
    protected BlockingQueue<ZMsg> events;

    protected boolean brokerIsOk = false;



    public Worker(String urlConnectionBrokerForWorker) {

        events = new LinkedBlockingQueue<>();
        workerContext = new ZContext();
        reconnectToBroker(urlConnectionBrokerForWorker);

    }

    private void reconnectToBroker(String urlConnectionBrokerForWorker){
        if(workerSocket != null) {
            workerContext.destroySocket(workerSocket);
        }

        workerSocket = workerContext.createSocket(SocketType.DEALER);
        workerSocket.connect(urlConnectionBrokerForWorker);

        heartbeatAt = System.currentTimeMillis() + HEARTBEAT_INTERVAL;
        liveness = HEARTBEAT_LIVENESS;
        brokerIsOk = true;
    }

    public void workerDancing() {
        while (!Thread.currentThread().isInterrupted()) {
            // Poll socket for a reply, with timeout
            ZMQ.Poller items = workerContext.createPoller(1);
            items.register(workerSocket, ZMQ.Poller.POLLIN);
            if (items.poll(POLL_TIMEOUT) == -1)
                break; // Interrupted

            if (items.pollin(0)) {
                ZMsg msg = ZMsg.recvMsg(workerSocket);
                if (msg == null)
                    break;
//                if (verbose) {
//                    log.format("I: received message from broker: \n");
//                    msg.dump(log.out());
//                }
                liveness = HEARTBEAT_LIVENESS;
                // Don't try to handle errors, just assert noisily
//                assert (msg != null && msg.size() >= 3);

                ZFrame empty = msg.pop();
                assert (empty.getData().length == 0);
                empty.destroy();

                ZFrame header = msg.pop();
//                assert (MDP.W_WORKER.frameEquals(header));
                if(!checkHeader(header)) {
                    msg.destroy();
                    continue;
                }

                ZFrame command = msg.pop();

                if(Protocol.REQUEST.equals(command)) {
                    addRequestToQueue(msg);
                } else if(Protocol.HEART_BEAT.equals(command)) {
                    brokerIsOk = true;
                } else if(Protocol.CHECK_STATUS_RESPONSE.equals(command)){
                    brokerIsOk = true;
                }

//                if (MDP.W_REQUEST.frameEquals(command)) {
//                    // We should pop and save as many addresses as there are
//                    // up to a null part, but for now, just save one
//                    replyTo = msg.unwrap();
//                    command.destroy();
//                    return msg; // We have a request to process
//                }
//                else if (MDP.W_HEARTBEAT.frameEquals(command)) {
//                    // Do nothing for heartbeats
//                }
//                else if (MDP.W_DISCONNECT.frameEquals(command)) {
//                    reconnectToBroker();
//                }
//                else {
//                    log.format("E: invalid input message: \n");
//                    msg.dump(log.out());
//                }
//                command.destroy();
//                msg.destroy();
            }

            // todo: kiểm tra chỉ số liveness
//            else if (--liveness == 0) {
//                if (verbose)
//                    log.format("W: disconnected from broker - retrying\n");
//                try {
//                    Thread.sleep(reconnect);
//                }
//                catch (InterruptedException e) {
//                    Thread.currentThread().interrupt(); // Restore the
//                    // interrupted status
//                    break;
//                }
//                reconnectToBroker();
//
//            }
            // Send HEARTBEAT if it's time

//            if (System.currentTimeMillis() > heartbeatAt) {
//                sendToBroker(MDP.W_HEARTBEAT, null, null);
//                heartbeatAt = System.currentTimeMillis() + heartbeat;
//            }
            items.close();
        }
//        if (Thread.currentThread().isInterrupted())
//            log.format("W: interrupt received, killing worker\n");
//        return null;
    }

    protected void addRequestToQueue(ZMsg clientRequest){
        events.add(clientRequest);
    }

    protected abstract boolean checkHeader(ZFrame header);
//    if(header.equals(Protocol.CLIENT))
//            header.destroy();

}
