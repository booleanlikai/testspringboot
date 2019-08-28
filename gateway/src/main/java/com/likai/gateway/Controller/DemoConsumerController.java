package com.likai.gateway.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.likai.api.Responesmodel.Users;
import com.likai.api.model.User;
import com.likai.api.service.ConfigService;
import com.likai.api.service.DemoService;
import com.likai.gateway.Handler.UserHandler;
import com.likai.gateway.exception.myException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * DemoConsumerController
 * 消费者控制层
 *
 * @author xiaoze
 * @date 2018/6/7
 */
@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
public class DemoConsumerController {

    private final static Logger logger = LoggerFactory.getLogger(DemoConsumerController.class);

    @Reference(version = "1.0.0", check = false, timeout = 30000)
    private DemoService demoService;


    @Reference(version = "1.0.0", check = false, timeout = 30000)
    private ConfigService configService;

    @Autowired
    private UserHandler userHandler;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) throws Exception {
        throw new myException("N002", "ceshi");
    }

    @RequestMapping("/testxml/{name}")
    public Users testxml(@PathVariable("name") String name, @RequestBody User user) throws Exception {
        logger.error(user.toString());
        List<User> list = userHandler.sayHello(name);
        Users users = new Users(list);
        return users;
    }

    @RequestMapping("/testconfig/{name}")
    public String testConfig(@PathVariable("name") String name) {
        return configService.getConfig();
    }

    @RequestMapping("/sayHello1/{name}")
    public List sayHello1(@PathVariable("name") String name) {
        return userHandler.sayHello(name);
    }
}

