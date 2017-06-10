package com.han;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description：
 * Created by hqhan on 2017/6/10 0010.
 */

@EnableEurekaServer
@SpringBootApplication
public class Eureka3Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Eureka3Application.class).web(true).run(args);
    }


}
