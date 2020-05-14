package org.shun.cloud.service;

import org.shun.cloud.entities.CommonResult;
import org.shun.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Administrator
 */
@Component
@FeignClient(value="cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/payment/hystrix/{id}")
    public String getPaymentInfo(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout")
    public String getPaymentTimeout();


    @GetMapping("/payment/hystrix/error")
    public String getPaymentError();
}
