package viettel.statistic_smpp.work.dto.result_statistic;

public class Result {

    private long lastId;
    private long lastResult;

    public Result() {
        lastId = 0;
    }

    public Result(long lastId) {
        this.lastId = lastId;
    }

    public long getLastId() {
        return lastId;
    }

    public void setLastId(long lastId) {
        this.lastId = lastId;
    }
}
