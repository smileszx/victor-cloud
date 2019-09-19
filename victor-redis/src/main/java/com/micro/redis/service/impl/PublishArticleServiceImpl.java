package com.micro.redis.service.impl;

import com.micro.redis.demo.ArticleInfo;
import com.micro.redis.demo.ResultMsg;
import com.micro.redis.service.PublishArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/19 22:25
 **/
public class PublishArticleServiceImpl implements PublishArticleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishArticleServiceImpl.class);

    private static Jedis jedis = new Jedis("192.168.1.160", 6379, 10000);


    @Override
    public ResultMsg publishArticle(ArticleInfo info) {
        ResultMsg msg = new ResultMsg();
        msg.setData(info);
        Map<String,String> map = new HashMap<>();
        map.put("title", info.getTitle());
        map.put("link", info.getLink());
        map.put("poster", info.getPoster());
        map.put("time", String.valueOf(info.getTime()));
        map.put("votes", String.valueOf(info.getVotes()));

        Long result = jedis.hset("article:" + info.getArticleId(), map);

        if(result>0) {
            msg.setCode(200);
            msg.setMsg("success");
        } else {
            msg.setCode(500);
            msg.setMsg("exists or fail");
        }
        return msg;
    }
}
