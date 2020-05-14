package org.shun.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.shun.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 * 消费者
 *
 * @author: BK137
 * @create: 2020/5/11 上午 10:37
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalOutFallbackMethod")
public class PaymentHystrixController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/consumer/payment/{id}")
    public String getPaymentByID(@PathVariable("id") Integer id){
        log.info("PaymentHystrixController=>getPaymentByID()");
        return paymentFeignService.getPaymentInfo(id);
    }

    /**
     * 这是一个fullback方法
     * @return
     */
    public String paymentInfoTimeoutHandler(){
        return "消费者80，对方支付系统繁忙请稍后再试，o(╥﹏╥)o";
    }

    @GetMapping("/consumer/payment/timeout")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    public String getPaymentTimeout(){
        log.info("PaymentHystrixController=>getPaymentTimeout()");
        return paymentFeignService.getPaymentTimeout();
    }


    @GetMapping("/consumer/payment/error")
    @HystrixCommand
    public String getPaymentError(){
        log.info("PaymentHystrixController=>getPaymentError()");
        return paymentFeignService.getPaymentError();
    }

    @GetMapping("/consumer/payment/haha")
    @HystrixCommand
    public String getPaymenthaha(){
        log.info("PaymentHystrixController=>getPaymenthaha()");
        int num =10/0;
        return paymentFeignService.getPaymentError();
    }

    /**
     *全局fallback
     * @return
     */
    public String paymentGlobalOutFallbackMethod(){
        return "这里是全局fallback,是兄弟就来砍我！";
    }


}
