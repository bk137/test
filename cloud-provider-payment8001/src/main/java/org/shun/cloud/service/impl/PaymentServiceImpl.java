package org.shun.cloud.service.impl;

import org.shun.cloud.dao.PaymentDao;
import org.shun.cloud.entities.Payment;
import org.shun.cloud.service.PaymentService;
import org.springframework.stereotype.Service;
//java自帶的等於 @autowrite
import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }




    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
