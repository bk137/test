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
@FeignClient(value="cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value="/payment/timeout")
    public String timeouttest();
}
