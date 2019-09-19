package com.micro.redis.service;

import com.micro.redis.demo.ArticleInfo;
import com.micro.redis.demo.ResultMsg;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/19 22:09
 **/
public interface PublishArticleService {

    ResultMsg publishArticle (ArticleInfo info);
}
