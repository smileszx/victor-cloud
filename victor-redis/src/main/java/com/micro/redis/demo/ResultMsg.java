package com.micro.redis.demo;

import lombok.Data;

/**
 * @Description
 * 返回信息统一格式
 * @Author victor su
 * @Date 2019/9/19 22:10
 **/
@Data
public class ResultMsg {

    private Integer code;

    private String msg;

    private Object data;
}
