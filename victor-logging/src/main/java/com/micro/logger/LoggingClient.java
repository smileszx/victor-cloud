package com.micro.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 测试slf4j + log4j2
 * @Author victor su
 * @Date 2019/9/10 23:43
 **/
public class LoggingClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingClient.class);

    public static void main(String[] args) {
        for (int i=0; i<100000;i++) {
            LOGGER.info("Test log4j2 info");
            LOGGER.warn("Test log4j2 warn");
            LOGGER.error("Test log4j2 error");
        }

    }
}
