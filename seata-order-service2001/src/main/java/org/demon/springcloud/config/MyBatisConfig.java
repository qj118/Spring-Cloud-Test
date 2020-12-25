package org.demon.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author demon
 * @create 2020-12-24 11:17
 */
@Configuration
@MapperScan({"org.demon.springcloud.dao"})
public class MyBatisConfig {
}