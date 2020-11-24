package org.demon.springcloud.service;

import org.demon.springcloud.entities.Payment;

/**
 * @author demon
 * @create 2020-11-20 15:17
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
