package com.likai.gateway.Handler;

import com.alibaba.dubbo.config.annotation.Reference;

import com.likai.api.model.User;
import com.likai.api.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Component
public class UserHandler {
    @Reference(version = "1.0.0", check = false)
    private UserService demoService;

    public List<User> sayHello(@PathVariable("name") String name) {
        List<User>list = (List<User>) demoService.dogets(name);
        return list;
    }
}
