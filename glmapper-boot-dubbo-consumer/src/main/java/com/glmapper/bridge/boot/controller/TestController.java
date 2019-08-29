package com.glmapper.bridge.boot.controller;

import com.glmapper.bridge.boot.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/7/27 2:00 PM
 * @since:
 **/
@RestController
public class TestController {
    @Reference(timeout = 10000)
    private HelloService helloService;

    @RequestMapping("test")
    public String test(){
        return helloService.SayHello("glmapper");
    }
}
