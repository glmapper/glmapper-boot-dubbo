package com.glmapper.bridge.boot;

import com.glmapper.bridge.boot.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author: guolei.sgl (glmapper_2018@163.com) 2019/2/26 2:16 PM
 * @since:
 **/
@SpringBootApplication
public class DubboConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(async = false)
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(helloService.SayHello("glmapper"));
        };
    }

}
