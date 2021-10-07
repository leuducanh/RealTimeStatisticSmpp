package viettel.statistic_smpp.work.dto.result_statistic;

public class QtyMessagePerSessionResult extends Result {

    private long cpId;
    private String sessionName;
    private long numberOfSubmitSM;
    private long numberOfSentSubmitSM;

    public QtyMessagePerSessionResult(long cpId, String sessionName, long numberOfSubmitSM, long numberOfSentSubmitSM) {
        this.cpId = cpId;
        this.sessionName = sessionName;
        this.numberOfSubmitSM = numberOfSubmitSM;
        this.numberOfSentSubmitSM = numberOfSentSubmitSM;
    }

    public long getCpId() {
        return cpId;
    }

    public void setCpId(long cpId) {
        this.cpId = cpId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public long getNumberOfSubmitSM() {
        return numberOfSubmitSM;
    }

    public void setNumberOfSubmitSM(long numberOfSubmitSM) {
        this.numberOfSubmitSM = numberOfSubmitSM;
    }

    public long getNumberOfSentSubmitSM() {
        return numberOfSentSubmitSM;
    }

    public void setNumberOfSentSubmitSM(long numberOfSentSubmitSM) {
        this.numberOfSentSubmitSM = numberOfSentSubmitSM;
    }
}
