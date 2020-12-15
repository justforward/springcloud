package com.study.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//用于服务发现的注解：
//当这个服务启动成功后，它就会根据配置项eureka.client.serviceUrl.defaultZone发送相关的请求，注册实例了。需要注意的是，服务注册功能是在服务启动成功后，间隔一个时间戳才会执行的，所以需要稍等一会儿。
@EnableDiscoveryClient
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
