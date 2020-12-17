package com.study.product;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangtan
 * @Date 2020/12/16
 */
@Configuration
public class AppContext {
    @LoadBalanced
    @Bean("restTemplate")
    public RestTemplate initRestTemplate(){
        return new RestTemplate();
    }
}
