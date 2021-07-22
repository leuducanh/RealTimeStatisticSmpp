package viettel.statistic_smpp.util;

//import de.mkammerer.snowflakeid.SnowflakeIdGenerator;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class IdGenerator {

    private Instant zeroPoint;
    private long offset;
    private long offSetInNanoTime;

    private IdGenerator(Instant zeroPoint) {
        this.zeroPoint = zeroPoint;
    }

    public IdGenerator createDefault(long zeroPoint) {
//        return new IdGenerator(Instant.ofEpochSecond());
        return null;
    }

    public static void main(String[] args) {
        // generatorId must be unique over all your instances!
        int generatorId = 0;

//        203792343239753728
//        203792343239753729
//        203792343239753730
//        203792343239753731
//        203792343239753732
//        203792343239753733
//        203792343239753734
//        203792343239753735
//        203792343239753736
//        203792343239753737

//        203792432540680192
//        203792432540680193
//        203792432544874496
//        203792432544874497
//        203792432544874498
//        203792432544874499
//        203792432544874500
//        203792432544874501
//        203792432544874502
//        203792432544874503



// use default generator settings
//        SnowflakeIdGenerator generator = SnowflakeIdGenerator.createDefault(generatorId);

// generate 10 ids
//        for (int i = 0; i < 10; i++) {
//            long id = generator.next();
//            System.out.println(id);
//        }

//        Instant t = Instant.ofEpochMilli(1000);
//
//        Date myDate = Date.from(t);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
//        String formattedDate = formatter.format(myDate);
//        System.out.println(formattedDate);
//        long a = 1<<10;
//        long maskTime = (1 << 5) - 1;
//        long ticks = 107;
//        long timestamp = ticks & maskTime;
//        System.out.println(a);
//        System.out.println(maskTime);
//        System.out.println(timestamp);
//        long b= (1 << 30);
//        long a = (1l << 41) - 1;
//        long c = 2199023255551l;
//
//        System.out.println(a);

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());

        Date myDate = Date.from(instant);
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        String formattedDate = formatter.format(myDate);
        System.out.println(formattedDate);
    }
}
