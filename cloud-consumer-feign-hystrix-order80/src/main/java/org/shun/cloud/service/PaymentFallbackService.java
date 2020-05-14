package org.shun.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 降级服务feignfallback
 *
 * @author: BK137
 * @create: 2020/05/11 下午 6:12
 */
@Component
public class PaymentFallbackService implements PaymentFeignService {

    @Override
    public String getPaymentInfo(Integer id) {
        return "-------PaymentFallbackService fall back getPaymentInfo(),o(╥﹏╥)o";
    }

    @Override
    public String getPaymentTimeout() {
        return "-----PaymentFallbackSevice fall back  getPaymentTimeout(),o(╥﹏╥)o";
    }

    @Override
    public String getPaymentError() {
        return "-----PaymentFallbackSevice fall back  getPaymentError(),o(╥﹏╥)o";
    }
}
