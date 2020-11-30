package org.demon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author demon
 * @create 2020-11-27 15:56
 */
@SpringBootApplication
@EnableDiscoveryClient // 向使用 ZooKeeper/ consul 作为注册中心时注册服务
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
