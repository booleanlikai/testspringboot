package com.likai.serviceproxy.provider;

import com.likai.api.service.UserService;
import com.likai.api.model.User;
import com.likai.serviceproxy.bussiness.UserBussiness;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service(version = "1.0.0" ,timeout = 30000)
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserBussiness userBussiness;

    @Override
    public Object dogets(String name) {
        List<User> userList = userBussiness.quer_all();
        return userList;
    }
}
