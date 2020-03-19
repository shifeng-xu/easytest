package com.easytest.service;

import com.easytest.Exception.EasyException;
import com.easytest.model.Project;

import java.util.List;

public interface IProjectManage {

    boolean checkProjectName(String name);

    EasyException.Code save(String name,String description);

    List<Project> findProject(Long id, String name);



}
