package com.han.gateway.spring;

import com.han.gateway.filter.AccessFilter;
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
    @DependsOn("restTemplate")
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
