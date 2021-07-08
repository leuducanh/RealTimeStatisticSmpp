package viettel.statistic_smpp.client;

import org.zeromq.*;
import viettel.statistic_smpp.util.Protocol;

public class Client {

    private String     brokerAddressString;
    private ZContext ctx;
    private ZMQ.Socket socketClient;
    private long       timeout = 2500;
    private int        retries = 3;


    public Client(String brokerAddressString) {
        this.brokerAddressString = brokerAddressString;

        ctx = new ZContext();
        connectToBroker();
    }

    void connectToBroker()
    {
        if(socketClient != null){
            ctx.destroySocket(socketClient);
        }
        socketClient = ctx.createSocket(SocketType.DEALER.type());
        socketClient.connect(brokerAddressString);
    }

    public void send() {

//        request.addFirst(new ZFrame(service));
//        request.addFirst(Protocol.CLIENT.newFrame());
//
//        System.out.println("send " + request.toString());
//
//        int retriesLeft = retries;


        boolean flag = false;
        while(true) {
            if(!flag) {

                ZMsg request = new ZMsg();
                request.addFirst("client-send");
                request.duplicate().send(socketClient);
                flag = true;
            }

            ZMQ.Poller poller = ctx.getContext().poller(1);
            poller.register(socketClient, ZMQ.Poller.POLLIN);

            if(poller.poll(timeout) == -1) {
                break;
            }
            ZMsg message = null;
            if(poller.pollin(0)) {
                 message = ZMsg.recvMsg(socketClient);
            }
            System.out.println(message != null ? message.toString() : "null");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client("tcp://localhost:5555");
        client.send();
    }
}
