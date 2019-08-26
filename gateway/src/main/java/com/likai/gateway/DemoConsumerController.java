package com.likai.gateway;

import com.alibaba.dubbo.config.annotation.Reference;
import com.likai.api.service.ConfigService;
import com.likai.api.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * DemoConsumerController
 * 消费者控制层
 *
 * @author xiaoze
 * @date 2018/6/7
 */
@RestController
public class DemoConsumerController {

    private final static Logger logger = LoggerFactory.getLogger(DemoConsumerController.class);

    @Reference(version = "1.0.0")
    private DemoService demoService;


    @Reference(version = "1.0.0")
    private ConfigService configService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return demoService.dogets(name);
    }

    @RequestMapping("/testconfig/{name}")
    public String testConfig(@PathVariable("name") String name) {
        return configService.getConfig();
    }
}

