package com.likai.datebase;

import com.likai.api.model.User;
import com.likai.datebase.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatebaseApplicationTests {

    @Resource
    private UserServiceImpl userService;

    @Test
    public void contextLoads() {
        List<User> userList = userService.query_all();
        System.out.println(userList);
        List<User> userList1 = userService.query_all_ss();
        System.out.println(userList);
    }

}
