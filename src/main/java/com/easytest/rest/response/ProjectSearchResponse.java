package com.easytest.rest.response;

import com.easytest.Exception.EasyException;
import com.easytest.model.Project;

import java.util.List;

public class ProjectSearchResponse {

    private EasyException.Code code;

    private List<Project> projectList;


    public EasyException.Code getCode() {
        return code;
    }

    public void setCode(EasyException.Code code) {
        this.code = code;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
