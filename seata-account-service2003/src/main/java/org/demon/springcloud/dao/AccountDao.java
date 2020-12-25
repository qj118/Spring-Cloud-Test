package org.demon.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demon.springcloud.domain.Account;

import java.math.BigDecimal;

/**
 * @author demon
 * @create 2020-12-24 14:55
 */
@Mapper
public interface AccountDao {

    Account getByUserId(@Param("userId") Long userId);

    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
