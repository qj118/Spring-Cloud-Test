package org.demon.springcloud.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.demon.springcloud.dao.OrderDao;
import org.demon.springcloud.domain.Order;
import org.demon.springcloud.service.AccountService;
import org.demon.springcloud.service.OrderService;
import org.demon.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author demon
 * @create 2020-12-24 11:00
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "demon-create-order", rollbackFor = Exception.class)
    public void create(Order order) {

        // 1. 创建订单
        log.info("用户下单：" + order);
        orderDao.create(order);
        // 2. 扣减库存
        log.info("库存扣减：产品 " + order.getProductId() + " 扣减 " + order.getCount());
        storageService.decrease(order.getProductId(), order.getCount());
        // 3. 扣减账户
        log.info("账户扣减：" + order.getUserId() + " 账户扣减 " + order.getMoney());
        accountService.decrease(order.getUserId(), order.getMoney());
        // 4. 修改订单状态 0 -> 1
        log.info("订单完成：" + order);
        orderDao.update(order.getUserId(), 0);
    }
}
