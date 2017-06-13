package com.han;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Description：网关
 * Created by hqhan on 2017/6/13 0013.
 */

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }
}
