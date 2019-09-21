package com.micro.redis.test.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * Redis集群测试
 * @Author victor su
 * @Date 2019/9/21 13:19
 **/
public class RedisClusterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisClusterTest.class);

    @Test
    public void testCluster () {

        Set<HostAndPort> nodes = new HashSet<>();

        nodes.add(new HostAndPort("192.168.1.101", 7001));
        nodes.add(new HostAndPort("192.168.1.101", 7002));
        nodes.add(new HostAndPort("192.168.1.101", 7003));
        nodes.add(new HostAndPort("192.168.1.101", 7004));
        nodes.add(new HostAndPort("192.168.1.101", 7005));
        nodes.add(new HostAndPort("192.168.1.101", 7006));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("redis-cluster", "my jedis cluster test");

        String result = cluster.get("redis-cluster");
        LOGGER.error(result);

        LOGGER.error(cluster.get("k1"));

        cluster.close();

    }
}
