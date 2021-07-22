package viettel.statistic_smpp;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import viettel.statistic_smpp.broker.Broker;

import java.io.UnsupportedEncodingException;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableScheduling
public class App implements CommandLineRunner {

    @Autowired
    private Environment env;

    public static void main(String[] args) throws DecoderException, UnsupportedEncodingException {

        SpringApplication.run(App.class, args);



//        String s = new String(, "UTF-16BE")
//        byte[] decoded = Hex.decodeHex("20");
//        String s = new String(decoded, "UTF-16BE");
//
//        System.out.println(s);
    }



    @Override
    public void run(String... args) throws Exception {
       try{
           final String mode = env.getProperty("mode");
           final String bindPort = env.getProperty("bind_port");
           final String connectionPort = env.getProperty("connection_port");
           if (mode == null || !mode.matches("broker|worker_exactly|worker_not_exactly|sub")) {
               throw new IllegalArgumentException();
           }
           switch (mode) {
               case "broker":
                   int brokerBindPort = Integer.parseInt(bindPort);
                   Broker broker = new Broker(String.format("tcp://*:%s", brokerBindPort));
                   break;
               case "worker_exactly":
                   int workerExactlyConnectionPort = Integer.parseInt(connectionPort);
                   break;
               case "worker_not_exactly":
                   int workerConnectionPort = Integer.parseInt(connectionPort);
                   break;

           }
       }catch (Exception e){

       }

    }
}
