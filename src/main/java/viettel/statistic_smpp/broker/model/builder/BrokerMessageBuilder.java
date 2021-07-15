package viettel.statistic_smpp.broker.model.builder;

import org.zeromq.ZFrame;
import org.zeromq.ZMsg;
import viettel.statistic_smpp.util.Protocol;

public class BrokerMessageBuilder {

    ZFrame receiverAddress;
    ZFrame command;

    public static BrokerMessageBuilder builder() {
        return new BrokerMessageBuilder();
    }

    public BrokerMessageBuilder toReceiverAddress(ZFrame receiverAddress) {
        this.receiverAddress = receiverAddress;
        return this;
    }

    public BrokerMessageBuilder command(ZFrame command) {
        this.command = command;
        return this;
    }

    public ZMsg build() {
        ZMsg zMsg = new ZMsg();
        zMsg.addFirst(Protocol.BROKER.newFrame());
        zMsg.addFirst(command);
        return zMsg;
    }
}
