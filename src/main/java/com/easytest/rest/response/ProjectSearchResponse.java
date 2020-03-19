package com.easytest.rest.response;

import com.easytest.Exception.EasyException;
import com.easytest.model.Project;

import java.util.List;

public class ProjectSearchResponse {


    private List<Project> projectList;

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
