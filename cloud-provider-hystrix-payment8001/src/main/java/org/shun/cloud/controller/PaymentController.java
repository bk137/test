package org.shun.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.shun.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/{id}")
    public String getPaymentInfo(@PathVariable("id") Integer id){
        log.info("paymentController=>getPaymentInfo()");
        return paymentService.paymentInfo_ok(id);
    }


    @GetMapping("/payment/hystrix/timeout")
    public String getPaymentTimeout(){
        log.info("getPaymentTimeout=>getPaymentTimeout()");
        return paymentService.paymentInfoTimeout();
    }
    @GetMapping("/payment/hystrix/error")
    public String getPaymentError(){
        log.info("getPaymentTimeout=>getPaymentError()");
        return paymentService.paymentInfoError();
    }

    @GetMapping("/payment/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result: "+result);
        return result;
    }


    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return port;
    }

}
