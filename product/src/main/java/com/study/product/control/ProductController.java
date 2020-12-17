package com.study.product.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.study.common.response.ResultMessage;

/**
 * @author wangtan
 * @Date 2020/12/16
 */
@RestController
@RequestMapping("/product/")
public class ProductController {

    /**
     * 依赖注入restTemplate
     */
    @Autowired
    private RestTemplate restTemplate = null;

    /**
     * 在这段代码中，url的服务器和端口被定义为了FUND，与资金微服务的配置项spring.application.name是一致的，
     * 这样Eureka服务治理中心就知道你在请求资金微服务，并且默认采用轮询策略做负载均衡。
     * url里面存在着参数的占位定义,跟着使用了Map<String, Object>对象封装请求的参数，其中key和url中参数的占位定义要保持一致。
     * 最后使用了RestTemplate的postForObject方法对资金微服务进行请求，
     * 这样就可以获取资金微服务返回来的信息进行打印了。
     * @param userId
     * @param productId
     * @param amount
     * @return
     */
    @PostMapping("purchase/{userId}/{productId}/{amount}")
    public ResultMessage purchaseProduct(@PathVariable("userId") Long userId,
                                         @PathVariable("productId") Long productId,
                                         @PathVariable("amount")Double amount) {
        System.out.println("扣减产品余额。");
        //这里的FUND代表资金微服务，RestTemplate会自动负载均衡
        String url="http://FUND/fund/account/balance/{userId}/{amount}";
        //封住请求参数
        Map<String,Object> params =new HashMap<>();
        params.put("userId",userId);
        params.put("amount",amount);
        //请求资金微服务
        ResultMessage rm=restTemplate.postForObject(url,null,ResultMessage.class,params);
        //打印资金微服务返回的消息
        System.out.println(rm.getMessage());
        System.out.println("交易记录信息");
        return new ResultMessage(true,"交易成功");
    }
}
