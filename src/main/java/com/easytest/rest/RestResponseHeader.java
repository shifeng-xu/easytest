package com.easytest.rest;

/**
 * 通用api返回结果头
 */
public class RestResponseHeader {

    private Integer code;

    private String msg;

    public RestResponseHeader(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

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
}
