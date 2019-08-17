package com.likai.serviceproxy.provider;

import com.likai.api.service.DemoService;
import com.likai.datebase.model.User;
import com.likai.serviceproxy.bussiness.UserBussiness;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Resource
    private UserBussiness userBussiness;

    @Override
    public String dogets(String name) {
        List<User> userList = userBussiness.quer_all();
        String ss = userList.toString();
        logger.error(ss);
        return "Hello " + name + "from spring boot " + ss;
    }
}
