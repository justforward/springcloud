package com.study.fund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FundApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundApplication.class, args);
    }

}
