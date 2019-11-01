package com.micro.rpc.service.impl;

import com.micro.rpc.service.SomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description
 * RPC 服务接口实现类
 * @Author victor su
 * @Date 2019/10/24 22:32
 **/
@Slf4j
@Service
public class SomeServiceImpl implements SomeService{
    @Override
    public String sayHello(String msg) {
        log.info("My name is dubbo provider service.");
        return "Hello, " + msg;
    }

    @Override
    public Integer getId(String name) {
        return name.hashCode();
    }
}
