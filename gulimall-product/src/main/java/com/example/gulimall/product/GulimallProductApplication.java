package com.example.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2. 逻辑删除
 *      1.配置全局的逻辑删除规则
 *      2.配置逻辑删除的组件
 *      3.实体类上加字段@Tablelogic
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.example.gulimall.product.dao")
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
