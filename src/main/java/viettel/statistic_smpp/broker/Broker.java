package viettel.statistic_smpp.broker;

import org.zeromq.*;

public class Broker {
    private static final int    HEARTBEAT_LIVENESS      = 3;
    private static final int    HEARTBEAT_INTERVAL      = 2500;
    private static final int    HEARTBEAT_EXPIRY        = HEARTBEAT_INTERVAL * HEARTBEAT_LIVENESS;

    private String brokerAddressString;
    private ZContext ctx;
    private ZMQ.Socket socketBroker;

    private long heartbeatAt;

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
        while(true) {
            if (items.poll(HEARTBEAT_INTERVAL) == -1)
                break; // Interrupted
            ZMsg zMsg = new ZMsg();
//            if (items.pollin(0)) {


//                System.out.println(msg != null ? msg.toString() : "null");
            if(clientAddress == null) {

                ZMsg msg = ZMsg.recvMsg(socketBroker);
                if(msg != null) {
                    System.out.println("tin den");
                    clientAddress = msg.unwrap();
                }
            }else{
                i++;
                System.out.println("address " +clientAddress.toString());

                zMsg.addFirst(new ZFrame("" + i ));
                zMsg.addFirst(new byte[0]);
                zMsg.addFirst(clientAddress.duplicate());
                zMsg.send(socketBroker);
            }

//            }


        }

    }

    public static void main(String[] args) {
        Broker broker = new Broker("tcp://*:5555");
        broker.middleManDancing();
    }

}
