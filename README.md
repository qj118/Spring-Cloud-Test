# 工程简介

[视频教程](https://www.bilibili.com/video/BV18E411x7eT?p=1)，边学边敲

## 框架版本

- spring cloud: Hoxton.SR1
- spring boot: 2.2.2.RELEASE
- spring cloud alibaba: 2.1.0.RELEASE

## 初体验

- server端微服务：cloud-provider-payment8001
- consumer端微服务：cloud-consumer-order80
- 工程重构：cloud-api-commons 
    将实体类提取出来，并打包，作为依赖移入上述两个服务即可。

## 单个 Eureka 服务中心

- cloud-eureka-server7001
- 将 cloud-provider-payment8001 和 cloud-consumer-order80 注册到服务中心。

## Eureka 集群

- cloud-eureka-server7001 和 cloud-eureka-server7002 相互注册
- cloud-provider-payment8002 服务名 payment8001 相同，端口号不同的相同服务（验证负载均衡）
