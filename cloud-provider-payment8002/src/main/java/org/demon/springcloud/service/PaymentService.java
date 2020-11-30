package org.demon.springcloud.service;

import org.demon.springcloud.entities.Payment;

/**
 * @author demon
 * @create 2020-11-30 16:06
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
