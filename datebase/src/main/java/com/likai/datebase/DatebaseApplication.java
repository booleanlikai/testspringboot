package com.likai.datebase;

import com.likai.datebase.configure.DruidDataSourceProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = "com.likai.datebase.dao")
public class DatebaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatebaseApplication.class, args);
    }

}
