package com.likai.datebase.service;

import com.likai.datebase.dao.UserMapper;
import com.likai.datebase.model.User;
import com.likai.datebase.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> query_all() {
        return userMapper.selectAll();
    }

    public List<User> query_all_ss() {
        return userMapper.selectAll_s();
    }
}
