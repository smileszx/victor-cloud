package com.micro.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/12 22:38
 **/
public class JedisTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JedisTest.class);

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.101", 6379, 10000);

        jedis.flushAll();

        jedis.set("zhejiangweishi", "中国好声音");

        LOGGER.error(String.valueOf(jedis.keys("*")));

        LOGGER.info("Jedis server: {}", jedis.ping());

    }
}
