package com.micro.redis.test.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @Description
 * 测试商品排行场景
 * @Author victor su
 * @Date 2019/9/17 22:44
 **/
public class ProductRank {

    private static final long PRODUCT_KINDS = 30;

    private static Jedis jedis = new Jedis("192.168.1.105", 6379, 10000);

    public static void main(String[] args) {
        String key = "product:rank";

        try {
            if(jedis.exists(key))
                jedis.del(key);

            List<String> productList = new ArrayList<>();

            //初始化商品列表
            for (int i=0; i<PRODUCT_KINDS; i++) {
                productList.add("product:" + UUID.randomUUID().toString());
            }

            //计算商品销售量，模拟
            for (int j = 0; j<productList.size(); j++) {
                int sales = (int) (Math.random() * 20000);
                //sorted set 有序集合
                jedis.zadd(key, sales, productList.get(j));
            }


            System.out.println("==================== " + key + " =======================");

            Set<Tuple> sortedProductList = jedis.zrevrangeWithScores(key, 0, -1);
            for(Tuple product : sortedProductList) {
                System.out.println("产品ID： " + product.getElement() + ", 销量： "
                        + Double.valueOf(product.getScore()).intValue());
            }

            System.out.println("==================== " + key + " =======================");
            System.out.println("==================== Top 5 热销商品 =======================");

            //获取销量前五列表并输出
            Set<Tuple> sortedTopList = jedis
                    .zrevrangeWithScores(key, 0, 4);
            for(Tuple product : sortedTopList) {
                System.out.println("产品ID： " + product.getElement() + ", 销量： "
                        + Double.valueOf(product.getScore()).intValue());
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            jedis.quit();
            jedis.close();
        }
    }
}
