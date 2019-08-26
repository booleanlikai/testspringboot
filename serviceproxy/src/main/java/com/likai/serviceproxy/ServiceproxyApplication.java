package com.likai.serviceproxy;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableDubbo
@ComponentScans({
        @ComponentScan(basePackages = "com.likai")
})
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class ServiceproxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceproxyApplication.class, args);
    }

}
