package viettel.statistic_smpp.util;

import org.zeromq.ZFrame;

public enum Protocol {
     CLIENT("CLIENT"), WORKER("WORKER"), BROKER("BROKER"),
    EXACTLY("EXACTLY"), NOT_EXACTLY("NOT_EXACTLY"),
    REQUEST("REQUEST"), HEART_BEAT("HEART_BEAT"),
    CHECK_STATUS("CHECK_STATUS"), CHECK_STATUS_RESPONSE("CHECK_STATUS_RESPONSE"),
    REGISTER("REGISTER"), SYNC_DATA_TO_STORAGE("SYNC_DATA_TO_STORAGE"),
    REBALANCED_WORKER("REBALANCED_WORKER"),
    WORKER_RESPONSE("WORKER_RESPONSE"),
    SYNC_DATA_TO_STORAGE_RESPONSE("SYNC_DATA_TO_STORAGE_RESPONSE"),
    REBALANCED_WORKER_RESPONSE("REBALANCED_WORKER_RESPONSE"),
    OK("OK"), ERROR("ERROR");

    String value;

    Protocol(String value) {
        this.value = value;
    }

    public boolean equals(String value) {
        return this.value.equals(value);
    }


    public boolean equalsValue(Object object) {


        if(object == null) return false;

        if(object instanceof ZFrame) {
            return value.equals(object.toString());
        }
        if(object instanceof String) {
            return value.equals(object);
        }


        return false;
    }

    public ZFrame newFrame() {
        return new ZFrame(value);
    }

    public String getValue() {
        return value;
    }
}
