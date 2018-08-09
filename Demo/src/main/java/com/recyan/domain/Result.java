package com.recyan.domain;

import org.springframework.stereotype.Component;

/**
 * http请求返回值处理
 * Created by Yan_Jiang on 2018/8/9.
 */
@Component
public class Result<T> {

    private Integer code; //错误码

    private String msg; //错误信息

    private T data; //具体内容

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
