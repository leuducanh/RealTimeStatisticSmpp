package viettel.statistic_smpp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import viettel.statistic_smpp.broker.Broker;

/**
 * Hello world!
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private Environment env;

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
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
    }
}
