package org.shun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrixMain80 {
    public static void main(String[] args){
        System.out.println("脑部即将开始充血");
        System.out.println("眼睛睁开");
        System.out.println("嘴巴微微裂开");
        SpringApplication.run(OrderFeignHystrixMain80.class,args);
    }
}
