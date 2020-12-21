package org.demon.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author demon
 * @create 2020-12-18 10:18
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nocas-user-service}")
    private String serviceUrl;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable  int id){
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
    }
}
