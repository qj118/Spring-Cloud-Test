package org.demon.springcloud.controller;

import org.demon.springcloud.domain.CommonResult;
import org.demon.springcloud.domain.Order;
import org.demon.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author demon
 * @create 2020-12-24 11:15
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功", order);
    }
}
