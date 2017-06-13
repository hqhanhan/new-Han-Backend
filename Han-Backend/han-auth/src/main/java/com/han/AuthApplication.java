package com.han;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description：server-auth
 * Created by hqhan on 2017/6/9 0009.
 */

@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(AuthApplication.class).web(true).run(args);
    }


}
