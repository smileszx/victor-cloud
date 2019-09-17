package com.micro.redis.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/16 22:11
 **/
public class JedisApiTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(JedisApiTest.class);

    private static Jedis jedis = new Jedis("192.168.1.101", 6379, 10000);

    /**
     * String
     */
    @Test
    public void testRedisString () {
        for (int i=0; i<10; i++) {
            jedis.set("string-"+i, "字符串类型" + i);
        }
        LOGGER.error(String.valueOf(jedis.keys("string*")));
    }

    /**
     * List
     */
    @Test
    public void testRedisList () {
        if (jedis.exists("list"))
            jedis.del("list");

        jedis.lpush("list", "1", "2", "3", "4");

        jedis.rpush("list", "5", "6", "7", "8");

        LOGGER.error(String.valueOf(jedis.lrange("list", 0, -1)));

        String lpop = jedis.lpop("list");

        LOGGER.error(String.join(",", lpop, String.valueOf(jedis.lrange("list", 0, -1))));

        String rpop = jedis.rpop("list");

        LOGGER.error(String.join(",", rpop, String.valueOf(jedis.lrange("list", 0, -1))));
    }


    /**
     * Hash
     */
    @Test
    public void testRedisHash () {
        if (jedis.exists("hash:device"))
            jedis.del("hash:device");

        jedis.hset("hash:device", "sort", "分拣机器人");

        LOGGER.error(String.valueOf(jedis.hgetAll("hash")));

        Map<String, String> map = new HashMap<>();
        map.put("battery", "电池健康");
        map.put("charge", "充电次数");
        map.put("distance", "运行里程");

        jedis.hset("hash:device", map);

        LOGGER.error(String.valueOf(jedis.hgetAll("hash:device")));


        jedis.hdel("hash:device", "charge");

        LOGGER.error(String.valueOf(jedis.hgetAll("hash:device")));

    }

    /**
     * sorted set
     */

    @Test
    public void testRedisZset () {
        if(jedis.exists("zset"))
            jedis.del("zset");

        jedis.zadd("zset", 1.0, "积极主动");
        jedis.zadd("zset", 1.2, "双赢");
        Map<String, Double> map = new HashMap<>();
        for (int i=0; i<10;i++) {
            map.put("测试"+i, Double.valueOf(i));
        }
        jedis.zadd("zset", map);

        LOGGER.error(String.valueOf(jedis.zrange("zset", 0, -1)));

        LOGGER.error(String.valueOf(jedis.zrangeByScoreWithScores("zset", 0, 100)));

    }

    @Test
    public void testRedisSet() {
        if(jedis.exists("set"))
            jedis.del("set");
        jedis.sadd("set", "曹操", "孙权", "刘备", "刘备");

        LOGGER.error(String.valueOf(jedis.smembers("set")));
    }

    @Test
    public void testSetNX() {
        if(jedis.exists("lock"))
            jedis.del("lock");

        Long first = jedis.setnx("lock", "和氏璧");

        LOGGER.error(first + jedis.get("lock") + jedis.exists("lock"));

        Long second = jedis.setnx("lock", "和氏璧");

        LOGGER.error(second + jedis.get("lock") + jedis.exists("lock"));



    }

    @Test
    public void testMulti() {
        //Redis 事务
        Transaction tx =jedis.multi();

        tx.mset("a", "1", "b", "2");

        tx.sadd("c", "3", "4");

        tx.exec();

        LOGGER.error("提交事务后：" + jedis.mget("a", "b") + " , " + jedis.smembers("c"));

    }

    @Test
    public void testWatch() throws InterruptedException {
        //监控键值，如果发生变化，事务不执行，实现乐观锁
        String wr = jedis.watch("jay");

        LOGGER.error(wr);


        Thread.sleep(2000);


        Transaction tx = jedis.multi();

        tx.set("jay", "123");

        List<Object> r = tx.exec();

        LOGGER.error(jedis.get("jay") + ", exec结果：" + r);

    }

}
