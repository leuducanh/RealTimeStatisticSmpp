package viettel.statistic_smpp;

import com.google.protobuf.InvalidProtocolBufferException;
import viettel.statistic_smpp.dto.Header;
import viettel.statistic_smpp.dto.Request;

public class MainTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        Header header = Header.newBuilder()
                .setCpId("abc123")
                .setRequestCommand("qwe123")
                .build();
        byte[] ba = header.toByteArray();
        System.out.println(ba[0]);
        Header a = Header.parseFrom(ba);

//        Request request = Request.newBuilder().setHeader(Header.newBuilder().setCpId().build()).build()

        System.out.println(a.getCpId());
    }
}
