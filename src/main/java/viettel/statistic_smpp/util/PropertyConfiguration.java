package viettel.statistic_smpp.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration("myProperty")
@PropertySource("application.properties")
public class PropertyConfiguration {
    @Value("${mode}")
    public String mode;

//    @Value("${bind_port}")
//    public int bind_port;
//
//    @Value("${connection_port}")
//    public int connection_port;

    @Value("${broker_bind_port_url_for_broker}")
    public String brokerBindPortUrlForBroker;

    @Value("${worker_connect_to_broker_url_for_worker}")
    public String workerConnectToBrokerUrlForWorker;

    @Value("${timeout_to_resent_message}")
    public long timeout_to_resent_message;

    @Value("${abc}")
    public String abc;

//    @Value("${number_of_default_worker}")
//    public String number_of_default_worker;
//
//    @Value("")
//    public String ;

    @Value("${number_of_thread_in_thread_pool}")
    public int number_of_thread_in_thread_pool=30;

    @Value("${over_run_thread_in_thread_pool}")
    public int over_run_thread_in_thread_pool=20;

}
