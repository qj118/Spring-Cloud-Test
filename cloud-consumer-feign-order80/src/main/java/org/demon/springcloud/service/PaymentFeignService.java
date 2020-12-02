package org.demon.springcloud.service;

import org.demon.springcloud.entities.CommonResult;
import org.demon.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author demon
 * @create 2020-12-01 16:21
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE") // 指定微服务名称
public interface PaymentFeignService {

    // 只需把微服务暴露的接口复制过来即可
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
