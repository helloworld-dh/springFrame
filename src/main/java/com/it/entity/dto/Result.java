package com.it.entity.dto;

import lombok.Data;

/**
 * @ClassName: Result
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
@Data
public class Result<T> {
    //状态码
    private int code;
    //消息
    private String msg;
    //返回数据
    private T data;
}
