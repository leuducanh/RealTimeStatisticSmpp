package viettel.statistic_smpp.work;

import org.zeromq.ZMQ;

public class Worker {

    private static final int HEARTBEAT_LIVENESS = 3; // 3-5 is reasonable

    private static final long HEARTBEAT_INTERVAL = 2500;

    private String workerAddressString;
    private ZMQ.Socket workerSocket;
    private long heartbeat;
    private long waitBrokerSideBeforeReconnect = 2500;
    private boolean expectReply = false;





}
