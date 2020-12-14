package org.demon.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author demon
 * @create 2020-12-03 14:23
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id;
    }

    /**
     * @HystrixCommand的注解：
     *      fallbackMethod 用于制定服务降级时，托底的方法；
     *      commandProperties 指定参数，如反应时间等，即在什么条件下服务降级；
     *          类型为数组，每个property用 @HystrixProperty 注解包裹。
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
                    commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentInfo_Timeout(Integer id){
        int seconds = 3;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout, id: " + id + " 耗时（秒）：" + seconds;
    }

    /**
     * 服务超时，服务出错都会运行次兜底方案
     */
    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 系统繁忙或运行出错，稍后再试, id: " + id;
    }

    // 服务熔断

    /**
     * @HystrixProperty 参考类 HystrixCommandProperties
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("++++++ id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "id 不能是负数 ~ " + id;
    }
}
