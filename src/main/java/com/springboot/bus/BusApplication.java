package com.springboot.bus;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BusApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BusApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
