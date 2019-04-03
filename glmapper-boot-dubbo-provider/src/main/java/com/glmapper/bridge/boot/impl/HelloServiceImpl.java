package com.glmapper.bridge.boot.impl;


import com.glmapper.bridge.boot.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author: guolei.sgl (glmapper_2018@163.com) 2019/2/26 2:10 PM
 * @since:
 **/
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String SayHello(String name) {
        return "Hello , "+name;
    }
}
