package org.demon.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demon.springcloud.domain.Order;

/**
 * @author demon
 * @create 2020-12-24 10:47
 */
@Mapper
public interface OrderDao {

    // 1. 创建订单
    void create(Order order);

    // 2. 更新订单
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
