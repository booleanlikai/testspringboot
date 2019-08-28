package com.likai.serviceproxy.bussiness.impl;


import com.likai.api.model.User;

import com.likai.datebase.service.UserServiceImpl;
import com.likai.serviceproxy.bussiness.UserBussiness;

import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.List;

@Component
public class UserBussinessImpl implements UserBussiness {

    @Resource
    private UserServiceImpl userService;

    @Override
    public List<User> quer_all() {
        return userService.query_all();
    }
}
