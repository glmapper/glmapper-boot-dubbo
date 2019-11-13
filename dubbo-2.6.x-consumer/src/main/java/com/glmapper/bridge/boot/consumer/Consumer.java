/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.glmapper.bridge.boot.consumer;

import com.glmapper.bridge.boot.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ImportResource("classpath:META-INF/spring/echo-consumer.xml")
public class Consumer implements ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(Consumer.class).run(args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        HelloService echoService = (HelloService) applicationContext.getBean("echoService"); // get remote service proxy
        new Thread(() -> {
            for (; ; ) {
                try {
                    TimeUnit.SECONDS.sleep(5L);
                    String status1 = echoService.SayHello("Hello world!");
                    LOGGER.info(">>>>>>>> echo result: " + status1);
                } catch (Exception e) {
                    LOGGER.error(">>>>>>>> echo result: " + e.getMessage());
                }
            }
        }).start();
    }
}