package com.study.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wangtan
 * @Date 2020/12/22
 */
@Configuration
public class ApplicationContext {

//    /**
//     * 通过代码的形式来转发路由
//     * @param builder
//     * @return
//     */
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
//        //路由指的是通过互联的网络把信息从源地址传输到目的地址的活动
//        //开启路由配置—
//        return builder.routes()
//                //匹配路径
//                .route(f->f.path("/user/**")
//                        //转发到具体的URI
//                        .uri("http://localhost:2255")).
//                //创建
//                build();
//    }

//    /**
//     * 创建路由规则：在当前时间之后的两分钟，对于/user/**匹配的请求都会失效
//     * @param builder ——路由构造器
//     * @return 路由规则
//     */
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
//
//        ZonedDateTime dateTime=
//                //获取当前时间
//                LocalDateTime.now()
//                //两分钟后路由失效
//                .plusMinutes(2)
//                 //定义国际化区域
//                .atZone(ZoneId.systemDefault());
//        //before()-使用断言   uri-转发到具体的路由
//        return builder.routes().route("/user/**",r->r.before(dateTime).uri("http://localhost:2255")).build();
//    }
//
//    /**
//     * 判定某个请求头参数是否匹配一个正则式
//     * @param builder
//     * @return
//     */
//    @Bean
//    public RouteLocator customRouteLocator1(RouteLocatorBuilder builder){
//        //0~9数字
//        String regex="^[0-9]*$";
//        //设定路由和header断言
//        //判定请求头名称为"id"的参数是否为数字
//        return builder.routes().route("/user/**",r->r.header("id",regex).uri("http://localhost:2255"))
//                .build();
//    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
//        String host1="my.host.com";
//        String host2="**.myhost.com";
//
//        return builder.routes().route("/user/**",r->r.host(host1,host2)
//                .uri("http://localhost:2255")).build();
//
//    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        String groupName="user_info";
        String path="/user/info/{id}";
        return builder.routes()
                //第一个路由
                .route("user_info_v1",r->r.path(path)//定义路径
                        .and()//and 连接词，表示并且
                .weight(groupName,80)//设置组名和权重
                        // 配置路径
                .uri("http://localhost:2255"))
                //第二个路由
                .route("user_info_v2",r->r.path(path).
                        and()
                .weight(groupName,20)//设置组名和权重
                .uri("http://localhost:2266"))
                .build();

    }

    public static void main(String[] args) {
        String timeStr=
                //获取当前时间
                ZonedDateTime.now().
                        //减少1个小时
                        minusHours(1).
                        //格式化时间
                        format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println(timeStr);
        //打印结果——2020-12-22T19:07:18.453+08:00[Asia/Shanghai]
        //这是一个UTC的时间表达书，利用这个来配置YAML文件
    }


}
