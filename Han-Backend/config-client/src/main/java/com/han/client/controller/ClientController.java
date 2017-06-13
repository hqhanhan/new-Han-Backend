package com.han.client.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 * Created by hqhan on 2017/6/13 0013.
 */

@RefreshScope
@RestController
public class ClientController {

    @Autowired
    private Environment environment;

    @RequestMapping("/from")
    public String from(){

        return environment.getProperty("from");
    }




}
