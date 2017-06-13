package com.han.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 * Created by hqhan on 2017/6/13 0013.
 */


@RestController
public class GatewayController {

    @RequestMapping("/local/hello")
    public boolean hello(){
        return true;
    }
}
