package com.easytest.dao;

import com.easytest.model.Project;

import java.util.List;

public interface ProjectDao {

    void save(Project project);

    Project getProjectById(Long id);

    Project getProjectByName(String name);

    List<Project> getProject(Long id,String name);

    void delete(Project project);

}

