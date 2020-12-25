package org.demon.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.demon.springcloud.dao.AccountDao;
import org.demon.springcloud.domain.Account;
import org.demon.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author demon
 * @create 2020-12-24 15:09
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public Account getByUserId(Long userId) {
        return accountDao.getByUserId(userId);
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId, money);
        log.info("debug --> 扣减余额结束");
    }
}
