package com.likai.serviceproxy.provider;

import com.likai.api.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0", interfaceName ="DemoServiceImpl" )
public class DemoServiceImpl implements DemoService {
    @Override
    public String dogets(String name) {
        return "Hello "+name+"from spring boot ";
    }
}
