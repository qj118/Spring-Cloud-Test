package org.demon.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author demon
 * @create 2020-12-01 14:50
 */
// 自定义负载均衡算法
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
