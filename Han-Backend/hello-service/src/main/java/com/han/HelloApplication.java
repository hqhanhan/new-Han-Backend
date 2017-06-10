package com.han;


import com.netflix.discovery.endpoint.EndpointUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Description：server-provider
 * Created by hqhan on 2017/6/9 0009.
 */

@EnableDiscoveryClient
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {


        new SpringApplicationBuilder(HelloApplication.class).web(true).run(args);
    }


}
