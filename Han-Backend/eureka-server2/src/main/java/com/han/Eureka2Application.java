package com.han;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description：注册中心2
 * Created by hqhan on 2017/6/9 0009.
 */

@EnableEurekaServer
@SpringBootApplication
public class Eureka2Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Eureka2Application.class).web(true).run(args);
    }


}
