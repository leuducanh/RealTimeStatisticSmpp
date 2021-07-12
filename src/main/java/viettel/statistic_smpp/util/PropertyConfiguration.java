package viettel.statistic_smpp.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class PropertyConfiguration {
    @Value("${mode}")
    public String mode;

    @Value("${bind_port}")
    public int bind_port;

    @Value("${connection_port}")
    public int connection_port;


}
