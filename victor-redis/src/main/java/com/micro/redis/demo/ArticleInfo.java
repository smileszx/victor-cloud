package com.micro.redis.demo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description
 * 文章内容
 * @Author victor su
 * @Date 2019/9/19 22:13
 **/
@Data
@Accessors(chain = true)
public class ArticleInfo {
    private Long articleId;

    private String title;

    private String link;

    private String poster;

    private Double time;

    private Integer votes;

}
