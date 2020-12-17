package com.study.fund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(//扫描装配bean
        scanBasePackages = "com.study.fund")
@EnableDiscoveryClient()
@EnableFeignClients(//扫描
        basePackages = "com.study.fund")
public class FundApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundApplication.class, args);
    }

}
