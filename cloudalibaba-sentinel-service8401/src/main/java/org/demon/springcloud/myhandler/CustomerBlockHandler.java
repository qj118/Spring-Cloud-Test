package org.demon.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.demon.springcloud.entities.CommonResult;

/**
 * @author demon
 * @create 2020-12-23 10:05
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "自定义 global handler exception --- 1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "自定义 global handler exception --- 2");
    }
}
