package org.demon.springcloud.service.impl;

import org.demon.springcloud.dao.PaymentDao;
import org.demon.springcloud.entities.Payment;
import org.demon.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author demon
 * @create 2020-11-20 15:18
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
