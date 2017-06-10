package com.han.hello.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：hello
 * Created by hqhan on 2017/6/10 0010.
 */

@CommonsLog
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("路径：/hello:host:"+instance.getHost()+","+"service_id:"+instance.getServiceId());

        return "hello world";
    }

}
