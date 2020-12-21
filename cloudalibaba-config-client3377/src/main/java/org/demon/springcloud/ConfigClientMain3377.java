package org.demon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author demon
 * @create 2020-12-18 13:42
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3377.class, args);
    }
}
