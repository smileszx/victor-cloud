package com.micro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Description 测试slf4j + log4j2
 * @Author victor su
 * @Date 2019/9/10 23:43
 **/
public class LogSystemClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogSystemClient.class);

    public static void main(String[] args) {
        LOGGER.info("Test log4j2 info {}", new Date());
        LOGGER.warn("Test log4j2 warn {}" , new Date());
        LOGGER.error("Test log4j2 error {}" , new Date());

    }
}
