package org.shun.cloud.service;


import org.shun.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
public interface PaymentService {
    /**
     * @return
     */
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
