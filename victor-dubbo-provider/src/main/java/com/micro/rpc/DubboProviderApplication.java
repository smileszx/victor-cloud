package com.micro.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description
 * Dubbo 服务提供者
 * @Author victor su
 * @Date 2019/10/24 22:15
 **/
@SpringBootApplication
@ImportResource(locations = "spring-dubbo-provider.xml")
public class DubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
