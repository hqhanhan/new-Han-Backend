package com.han.gateway.spring;

import com.han.gateway.filter.AccessFilter;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.RestTemplate;

/**
 * Description：
 * Created by hqhan on 2017/6/13 0013.
 */

@Configuration
public class GatewayConfig {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    /**
     * 此实例配合使用路由命名规则，关于版本的规则  [便于代码版本管理]
     * 如 hello-service-v1,按照此路由方式，路径为 /v1/hello-service
     *
     * 如不匹配，则使用默认的配置方式，查看配置文件的注释
     * @return
     */
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
//
//        return  new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
//    }

}
