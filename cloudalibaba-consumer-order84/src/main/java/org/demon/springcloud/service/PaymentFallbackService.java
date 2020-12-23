package org.demon.springcloud.service;

import org.demon.springcloud.entities.CommonResult;
import org.demon.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @author demon
 * @create 2020-12-23 13:50
 */
@Service
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(777, "服务降级 ...", new Payment(id, "errorSerial"));
    }
}
