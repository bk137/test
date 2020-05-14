package org.shun.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.shun.cloud.entities.CommonResult;
import org.shun.cloud.entities.Payment;
import org.shun.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        System.out.println(id);
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeoutTest(){
        return paymentFeignService.timeouttest();
    }

}
