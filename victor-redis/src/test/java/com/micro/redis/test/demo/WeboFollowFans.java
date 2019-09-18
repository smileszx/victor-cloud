package com.micro.redis.test.demo;

import redis.clients.jedis.Jedis;

/**
 * @Description
 * 微博关注及粉丝
 * @Author victor su
 * @Date 2019/9/18 15:24
 **/
public class WeboFollowFans {

    private static Jedis jedis = new Jedis("192.168.1.105", 6379, 10000);

    public static void main(String[] args) {

        //微博社交关系

        //三种状态: 我的粉丝、我的关注、互粉

        //假设两个用户，用户ID分别为666和888

        // 1. 关注好友
        // 两个步骤：第一步，将对方写入我的关注中；第二步，将我写入对方的粉丝中
        // ZADD 666:follow time(时间戳) 888
        // ZADD 888:fans time(时间戳) 666
        String userA = "666";
        String userB = "888";

        jedis.zadd(userA + ":follow", System.currentTimeMillis(),userB);
        jedis.zadd(userA + ":fans", System.currentTimeMillis(),userB);

        jedis.zadd(userB + ":fans", System.currentTimeMillis(), userA);
        jedis.zadd(userB + ":follow", System.currentTimeMillis(), userA);

        System.out.println(userA +":follow  ==> " + jedis.zrange(userA + ":follow", 0, -1) + ", 关注数：" + jedis.zcard(userA + ":follow"));

        System.out.println(userB +":fans  ==> " + jedis.zrange(userB + ":fans", 0, -1)+ ", 粉丝数：" + jedis.zcard(userB + ":fans"));



        // 2. 取消关注
        // 两个步骤：第一步，将对方从我的关注列表移除；第二步，将我从对方的粉丝中移除
        //ZREM 666:follow 888
        //ZREM 888:fans 666


//        jedis.zrem(userA + ":follow", userB);
//        jedis.zrem(userB + ":fans", userA);

        System.out.println(userA +":follow  ==> " + jedis.zrange(userA + ":follow", 0, -1) + ", 关注数：" + jedis.zcard(userA + ":follow"));

        System.out.println(userB +":fans  ==> " + jedis.zrange(userB + ":fans", 0, -1)+ ", 粉丝数：" + jedis.zcard(userB + ":fans"));

        //3. 人物关系

        //我单向关注Ta，即我关注Ta，但是Ta没有关注我
        //ZSCORE 1:follow 2 #ture
        //ZSCORE 1:fans 2 #false

        Double follow = jedis.zscore(userA + ":follow", userB);

        Double fans = jedis.zscore(userA + ":fans", userB);

        System.out.println(userA + "==>" + follow);
        System.out.println(userA + "==>" + fans);


    }

}
