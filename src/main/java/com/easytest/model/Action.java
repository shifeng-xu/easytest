package com.easytest.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Action extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column
    private Integer actionOrder;

    private String commMethod; //通信方式


    private String httpMethods;  //get,post...

    @Column(length = 512)
    private String httpHeader;  //报文头

    @Column(length = 512)
    private String httpBody;  //报文体

    @Column
    private Long valueRuleId;  //取值规则

    @Column
    private String note;  //备注


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCommMethod() {
        return commMethod;
    }

    public void setCommMethod(String commMethod) {
        this.commMethod = commMethod;
    }

    public String getHttpMethods() {
        return httpMethods;
    }

    public void setHttpMethods(String httpMethods) {
        this.httpMethods = httpMethods;
    }

    public String getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(String httpHeader) {
        this.httpHeader = httpHeader;
    }

    public String getHttpBody() {
        return httpBody;
    }

    public void setHttpBody(String httpBody) {
        this.httpBody = httpBody;
    }

    public Long getValueRuleId() {
        return valueRuleId;
    }

    public void setValueRuleId(Long valueRuleId) {
        this.valueRuleId = valueRuleId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getActionOrder() {
        return actionOrder;
    }

    public void setActionOrder(Integer actionOrder) {
        this.actionOrder = actionOrder;
    }
}
