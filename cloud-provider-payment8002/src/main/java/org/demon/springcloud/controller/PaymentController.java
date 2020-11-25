package org.demon.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.demon.springcloud.entities.CommonResult;
import org.demon.springcloud.entities.Payment;
import org.demon.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author demon
 * @create 2020-11-20 15:22
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***插入结果：" + result);
        if(result > 0){
            return new CommonResult(200, "插入数据成功，服务端口号：" + serverPort, result);
        }else{
            return new CommonResult(444, "插入数据失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***查询结果：" + payment);
        if(payment != null){
            return new CommonResult(200, "查询成功，服务端口号：" + serverPort, payment);
        }else{
            return new CommonResult(444, "无相应记录，查询id为" + id);
        }
    }
}