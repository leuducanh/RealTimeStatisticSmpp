package viettel.statistic_smpp.dto.event_builder;

public class SmscActiveEvent {

    private String smscIdName;
    private Boolean isActive;

    public static final int POS_smscIdName = 0;
    public static final int POS_isActive = 1;

    public SmscActiveEvent(String smscIdName, boolean isActive) {
        this.smscIdName = smscIdName;
        this.isActive = isActive;
    }

    public SmscActiveEvent(String encodedData) {
        decode(encodedData);
    }

    public String encode() {
        StringBuilder stringBuilder  = new StringBuilder();
        return stringBuilder.append(smscIdName)
                .append("|")
                .append(isActive.toString())
                .toString();
    }

    public void decode(String dataString) {
        String[] dataArray = dataString.split("\\|");
        smscIdName = dataArray[POS_smscIdName];
        isActive = Boolean.parseBoolean(dataArray[POS_isActive]);
    }

    public static void main(String[] args) {
        if(Boolean.parseBoolean(new Boolean(true).toString()) == true) {
            System.out.println("acb");
        }else{
            System.out.println("1");
        }
    }
}
