package com.micro.redis;

import com.micro.redis.demo.ArticleInfo;
import com.micro.redis.demo.ResultMsg;
import com.micro.redis.service.PublishArticleService;
import com.micro.redis.service.impl.PublishArticleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/12 22:38
 **/
public class JedisTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JedisTest.class);

    public static void main(String[] args) {
        ArticleInfo info = new ArticleInfo();
        info.setArticleId((long) 1)
                .setTitle("深入学习Redis")
                .setLink("http://www.baidu.con")
                .setPoster("user:88238")
                .setTime(Double.valueOf(System.currentTimeMillis()))
                .setVotes(24342);

        PublishArticleService service = new PublishArticleServiceImpl();

        ResultMsg msg = service.publishArticle(info);

        LOGGER.error(msg.toString());

    }
}
