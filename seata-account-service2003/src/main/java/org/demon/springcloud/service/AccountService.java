package org.demon.springcloud.service;

import org.demon.springcloud.domain.Account;

import java.math.BigDecimal;

/**
 * @author demon
 * @create 2020-12-24 15:04
 */
public interface AccountService {

    Account getByUserId(Long userId);

    void decrease(Long userId, BigDecimal money);
}
