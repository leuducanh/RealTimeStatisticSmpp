package viettel.statistic_smpp.util;

import org.zeromq.ZFrame;

public enum Protocol {
     CLIENT("CLIENT"), WORKER("WORKER"), BROKER("BROKER"),
    REGISTER("REGISTER"), SYNC_DATA_TO_STORAGE("SYNC_DATA_TO_STORAGE"), REBALANCED_WORKER("REBALANCED_WORKER"),
    SYNC_DATA_TO_STORAGE_RESPONSE("SYNC_DATA_TO_STORAGE_RESPONSE"), REBALANCED_WORKER_RESPONSE("REBALANCED_WORKER_RESPONSE"),
    OK("OK"), ERROR("ERROR");

    String value;

    Protocol(String value) {
        this.value = value;
    }

    public boolean equals(String value) {
        return this.value.equals(value);
    }

    public ZFrame newFrame() {
        return new ZFrame(value);
    }
}
