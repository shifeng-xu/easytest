package com.easytest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;


@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Project extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<TestCase> testCases;   //项目下关联的case

    @OneToMany(cascade = {CascadeType.ALL})
    private List<GlobalParam> globalParams; //隶属于项目的全局变量



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public List<GlobalParam> getGlobalParams() {
        return globalParams;
    }

    public void setGlobalParams(List<GlobalParam> globalParams) {
        this.globalParams = globalParams;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
