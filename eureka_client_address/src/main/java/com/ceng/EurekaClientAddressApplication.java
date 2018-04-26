package com.ceng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientAddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientAddressApplication.class, args);
    }
}
