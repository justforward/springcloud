package com.study.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wtan
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {
    //这里我们使用Spring Cloud提供的组件Ribbon来调用它，调用fund里面的接口
    // Ribbon使用的是处理过的RestTemplate模板。为了在产品微服务中使用Ribbon，我们在ProductApplication中加入RestTemplate的初始化，

    //1.负载均衡：它会使用某种策略进行路由，路由到具体的微服务实例上，在默认情况下，使用的是轮询策略。
    @LoadBalanced
    //创建spring bean
    @Bean
    public RestTemplate initRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
