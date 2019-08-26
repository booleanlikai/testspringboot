package com.likai.serviceproxy.provider;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.likai.api.service.ConfigService;
import org.apache.dubbo.config.annotation.Service;


@Service(version = "1.0.0")
public class ConfigServiceImpl implements ConfigService {

    @NacosValue(value = "${useLocalCache:xiaoming}", autoRefreshed = true)
    private String example;

    @Override
    public String getConfig() {
        return example;
    }
}
