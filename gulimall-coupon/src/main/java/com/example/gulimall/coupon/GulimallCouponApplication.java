package com.example.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1. 远程调用其他服务
 * 1）引入open-feign
 * 2) 编写一个接口，为springcloud指定需要调用的服务
 *    2.1 声明调用的是哪个服务的哪个请求
 * 3） 开启调用功能
 */
@MapperScan("com.example.gulimall.coupon.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
