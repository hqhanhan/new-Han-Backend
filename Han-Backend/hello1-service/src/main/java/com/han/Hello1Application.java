package com.han;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description：server-provider
 * Created by hqhan on 2017/6/9 0009.
 */

@EnableDiscoveryClient
@SpringBootApplication
public class Hello1Application {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Hello1Application.class).web(true).run(args);
    }


}
