package com.easytest.web;


import com.easytest.Exception.EasyException;
import com.easytest.rest.RestResponse;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 通用返回结果包装器
 * 将RestController返回的Object包装为RestResponse
 */
public class ControllerResponseHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果不是RestResponse类型，则转换成RestResponse类型
        if(!(body instanceof RestResponse) ){
            return new RestResponse(EasyException.Code.STATUS_OK.getNum(),"OK",body);
        }

        return body;
    }
}
