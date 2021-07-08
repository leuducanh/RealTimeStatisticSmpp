package viettel.statistic_smpp.util;

import org.zeromq.ZFrame;

public enum Protocol {
     CLIENT("CLIENT"), WORKER("WORKER"), REQUEST("REQUEST"), REP("REP");

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
