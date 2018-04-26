package com.ceng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientPersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientPersonApplication.class, args);
    }
}
