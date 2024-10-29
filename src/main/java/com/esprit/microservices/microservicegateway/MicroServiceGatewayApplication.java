package com.esprit.microservices.microservicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceGatewayApplication.class, args);
    }

}
