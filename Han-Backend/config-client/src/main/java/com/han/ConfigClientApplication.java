package com.han;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description：配置中心客户端
 * Created by hqhan on 2017/6/13 0013.
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
    }
}
