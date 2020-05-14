package org.shun.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        String num = "0.9";
        Float num2 = 2.5F;
        Float num3 = Float.parseFloat(num) + num2;
        System.out.println(num3);
        return "springcloud with consul:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
