package org.demon.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author demon
 * @create 2020-12-12 9:55
 */
@Service
public class PaymentFallbackService implements OrderHystrixService{
    /**
     * 重写接口方法，该方法可以直接做为 fallback 方法使用
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService paymentInfo_OK fallback  " + id;
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallbackService paymentInfo_Time fallback " + id;
    }
}
