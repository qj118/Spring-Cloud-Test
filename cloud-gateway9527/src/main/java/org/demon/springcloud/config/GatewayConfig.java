package org.demon.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author demon
 * @create 2020-12-15 8:59
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        /**
         * 参数：
         *  1. route id
         *  2. 函数型接口，通过 path 断言返回 uri
         */
        routes.route("baidu_tech", r -> r.path("/tech").uri("http://news.baidu.com/tech"))
              .route("baidu_internet", r -> r.path("/internet").uri("http://news.baidu.com/tech"));

        return routes.build();
    }
}
