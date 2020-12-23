package org.demon.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author demon
 * @create 2020-12-22 13:21
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "sentinel test A ...";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName() + " - testB");
        return "sentinel test B ...";
    }

    // 测试服务降级： RT
    @GetMapping("/testC")
    public String testC(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sentinel test C ...";
    }

    // 测试服务降级：异常比例
    @GetMapping("/testD")
    public String testD(){
        int i = 10/0;
        return "sentinel test D ...";
    }

    @GetMapping("/testHotKey")
    // value 对应配置在 sentinel 热点规则中的资源名中
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        return "sentinel test hotkey ... ";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return e.getMessage();
    }

}
