package org.shun.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @author Administrator
 */
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://CONSUL-PROVIDER-PAYMENT";

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        log.info("PaymentConsulController=>paymentInfo()");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
