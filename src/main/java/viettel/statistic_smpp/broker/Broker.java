package viettel.statistic_smpp.broker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zeromq.*;
import viettel.statistic_smpp.util.Protocol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Broker {
    private static final int    HEARTBEAT_LIVENESS      = 3;
    private static final int    HEARTBEAT_INTERVAL      = 2500;
    private static final int    HEARTBEAT_EXPIRY        = HEARTBEAT_INTERVAL * HEARTBEAT_LIVENESS;

    private String brokerAddressString;
    private ZContext ctx;
    private ZMQ.Socket socketBroker;

    private long heartbeatAt;
    private ExecutorService threadPool = Executors.newFixedThreadPool(4);
    Logger logger =  LogManager.getLogger(Broker.class);

    public Broker(String brokerAddressString) {
        this.brokerAddressString = brokerAddressString;
        this.ctx = new ZContext();
        this.socketBroker = ctx.createSocket(SocketType.ROUTER.type());
        this.socketBroker.bind(brokerAddressString);
    }

    public void middleManDancing() {
        int i = 0;
        ZMQ.Poller items = ctx.getContext().poller(1);
        items.register(socketBroker, ZMQ.Poller.POLLIN);

        ZFrame clientAddress = null;
        while (true) {
            if (items.poll(HEARTBEAT_INTERVAL) == -1)
                break; // Interrupted
            ZMsg zMsg = new ZMsg();
            if (items.pollin(0)) {
                ZMsg msg = ZMsg.recvMsg(socketBroker);
                logger.debug(msg != null ? msg.toString() : "null");

                if(msg != null) {
                    ZFrame address = msg.unwrap();
                    ZFrame header = msg.pop();
                    ZFrame serviceName = msg.pop();

                    if(header.equals(Protocol.CLIENT)) {

                    } else if(header.equals(Protocol.WORKER)) {

                    }
                }

                if (clientAddress == null) {


                    if (msg != null) {
                        System.out.println("tin den");
                        clientAddress = msg.unwrap();
                    }
                } else {
                    i++;
                    System.out.println("address " + clientAddress.toString());

                    zMsg.addFirst(new ZFrame("" + i));
                    zMsg.addFirst(new byte[0]);
                    zMsg.addFirst(clientAddress.duplicate());
                    zMsg.send(socketBroker);
                }

//            }


            }

        }

    }



}
