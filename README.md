# 工程简介

[视频教程](https://www.bilibili.com/video/BV18E411x7eT?p=1) ，边学边敲

## 框架版本

- spring cloud: Hoxton.SR1
- spring boot: 2.2.2.RELEASE
- spring cloud alibaba: 2.1.0.RELEASE

## 初体验

- server端微服务：cloud-provider-payment8001
- consumer端微服务：cloud-consumer-order80
- 工程重构：cloud-api-commons 
    将实体类提取出来，并打包，作为依赖移入上述两个服务即可。

## Eureka 相关

### 单个 Eureka 服务中心

- cloud-eureka-server7001
- 将 cloud-provider-payment8001 和 cloud-consumer-order80 注册到服务中心。

### Eureka 集群

- cloud-eureka-server7001 和 cloud-eureka-server7002 相互注册
- cloud-provider-payment8002 服务名 payment8001 相同，端口号不同的相同服务（验证负载均衡）

### 服务发现

在 cloud-provider-payment8001 中的controller中进行了简单的测试。

### Eureka 的自我保护

在以下两个模块中进行了相关配置：
- cloud-eureka-server7001
- cloud-provider-payment8001

## ZooKeeper 相关

- cloud-provider-payment8004 提供者注册服务
- cloud-consumerzk-order80 消费者服务

## Consul 相关

- cloud-provider-payment8006 提供者服务
- cloud-consumerconsul-order80 消费者服务

## Ribbon 相关

- RestTemplate 的使用 （cloud-consumer-order80 中修改）
- 负载均衡算法的替换（cloud-consumer-order80 中修改）
- 自定义负载均衡算法（cloud-consumer-order80 中修改，在8001和8002做相应接口支持）

  如果想要测试通过，需要将配置类中的 restTemplate 上的 `@LoadBalanced` 注解注释掉。

## Feign 相关

- 消费端 cloud-consumer-feign-order80
- 在 8001 中添加超时测试

## Hystrix 相关

修改 7001 为不使用集群模式。
- 提供者：cloud-provider-hystrix-payment8001
- 消费者：cloud-consumer-feign-hystrix-order80
- 监控者：cloud-consumer-hystrix-dashboard9001

## Gateway 相关

修改 8001 和 8002 不使用集群模式。
用 cloud-gateway9527 网关访问 8001 和 8002 服务。

## Config 相关

- 配置中心（服务端）：cloud-config-center-3344
- 客户端：cloud-config-client-3355
- [配置github](https://github.com/qj118/spring-cloud-config-demo)

## Bus 相关

- 配置中心（服务端）：cloud-config-center-3344
- 客户端：cloud-config-client-3355, cloud-config-client-3366

注意：测试时启动 rabbitmq