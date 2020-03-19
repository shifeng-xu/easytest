package com.easytest.rest;

public class RestResponse {

    private RestResponseHeader header;

    public RestResponse(Integer code,String msg,Object body){
        RestResponseHeader header=new RestResponseHeader(code,msg);
        this.header=header;
        this.body=body;
    }

    private Object body;

    public RestResponseHeader getHeader() {
        return header;
    }

    public void setHeader(RestResponseHeader header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
