package com.easytest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class TestCase extends BaseEntity{

    @Column(nullable = false)
    private String name;

//    @Column
//    private Long projectId;

    @Column
    private String Env;

    //执行频率、通信类型，方法，header，body，前置actionID，后置actionid，取值规则id，备注
    @Column(nullable = false)
    private String commMethod;

    private Integer frequence;

    private String httpMethods;

    private String httpHeader;

    private String httpBody;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Action> preAction;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Action> nextAction;
    //private Long nextActionId;

    @Column(nullable = false)
    private Long valueRuleId;

    @Column
    private String note;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnv() {
        return Env;
    }

    public void setEnv(String env) {
        Env = env;
    }

    public String getCommMethod() {
        return commMethod;
    }

    public void setCommMethod(String commMethod) {
        this.commMethod = commMethod;
    }

    public Integer getFrequence() {
        return frequence;
    }

    public void setFrequence(Integer frequence) {
        this.frequence = frequence;
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

    public List<Action> getPreAction() {
        return preAction;
    }

    public void setPreAction(List<Action> preAction) {
        this.preAction = preAction;
    }

    public List<Action> getNextAction() {
        return nextAction;
    }

    public void setNextAction(List<Action> nextAction) {
        this.nextAction = nextAction;
    }
}
