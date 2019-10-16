package com.micro.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * 测试Controller
 * @Author victor su
 * @Date 2019/10/16 23:15
 **/
@RequestMapping("/victor")
@RestController
public class WelcomeController {

    /**
     * jmeter压测接口，可以看出tomcat线程池最大线程数默认是200，当前测试基于tomcat8
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String welcome () {
        System.out.println(Thread.currentThread().getName() + " hello world !");
        return "hello world";
    }
}
