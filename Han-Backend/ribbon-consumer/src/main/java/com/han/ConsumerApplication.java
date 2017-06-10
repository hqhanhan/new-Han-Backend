package com.han;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description：消费端
 * Created by hqhan on 2017/6/10 0010.
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ConsumerApplication.class).web(true).run(args);
    }

}
