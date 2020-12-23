package org.demon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.demon.springcloud.entities.CommonResult;
import org.demon.springcloud.entities.Payment;
import org.demon.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author demon
 * @create 2020-12-23 9:37
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源名测试OK", new Payment(2020L, "serial007"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName() + " 服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "按 url 限流测试 OK", new Payment(2020L, "serial077"));
    }

    /**
     * blockHandlerClass 指定自定义兜底类
     * blockHandler 指定兜底类中具体的兜底方法
     */
    @GetMapping("/byCustom")
    @SentinelResource(value = "byCustom",
                      blockHandlerClass = CustomerBlockHandler.class,
                      blockHandler = "handlerException2" )
    public CommonResult byCustom(){
        return new CommonResult(200, "自定义测试 OK", new Payment(2020L, "serial777"));
    }
}
