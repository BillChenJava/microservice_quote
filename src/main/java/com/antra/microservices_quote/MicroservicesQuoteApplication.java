package com.antra.microservices_quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesQuoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesQuoteApplication.class, args);
    }

}
