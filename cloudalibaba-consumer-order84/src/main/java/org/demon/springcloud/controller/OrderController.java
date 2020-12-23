package org.demon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.demon.springcloud.entities.CommonResult;
import org.demon.springcloud.entities.Payment;
import org.demon.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author demon
 * @create 2020-12-23 11:09
 */
@RestController
public class OrderController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback") // 直接弹出错误页面
    // @SentinelResource(value = "fallback", fallback = "handlerFallback") // 业务异常
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler") // sentinel 控制台配置违规
    @SentinelResource(value = "fallback",
                      fallback = "handlerFallback",
                      blockHandler = "blockHandler", // 两种错误同时发生，则以 blockHandler 为准
                      exceptionsToIgnore = {IllegalArgumentException.class}) // 指定忽略的异常类型，即出现该异常不走 fallback 方法
    public CommonResult<Payment> fallback(@PathVariable Long id)
    {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL +"/paymentSQL/" + id, CommonResult.class, id);

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常 ...");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException, 该 id 没有对应记录 ...");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id, Throwable e){
        return new CommonResult(444, e.getMessage());
    }

    public CommonResult blockHandler(@PathVariable Long id, BlockException exception){
        return new CommonResult(445, "请求违反配置规则" + exception.getMessage());
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
