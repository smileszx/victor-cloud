package com.micro.rpc.service.impl;

import com.micro.rpc.service.SomeService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * RPC 服务接口实现类
 * @Author victor su
 * @Date 2019/10/24 22:32
 **/
@Slf4j
public class SomeServiceImpl implements SomeService{
    @Override
    public String sayHello(String msg) {
        log.info("My name is dubbo provider service.");
        return "Hello, " + msg;
    }
}
