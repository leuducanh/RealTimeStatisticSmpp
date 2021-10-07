package viettel.statistic_smpp.work.dto.result_statistic;

public class SmscActiveResult extends Result{

    private String smscIdName;
    private boolean isActive;

    public SmscActiveResult(long lastId, String smscIdName, boolean isActive) {
        super(lastId);
        this.smscIdName = smscIdName;
        this.isActive = isActive;
    }
}
