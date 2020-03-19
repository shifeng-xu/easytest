package com.easytest.service.impl;

import com.easytest.Exception.EasyException;
import com.easytest.dao.ProjectDao;
import com.easytest.model.Project;
import com.easytest.service.IProjectManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProjectManageImpl implements IProjectManage {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public boolean checkProjectName(String name) {
        Project project=projectDao.getProjectByName(name);
        if(project==null)
            return true;
        else
            return false;
    }

    @Override
    public EasyException.Code save(String name,String description) {
        //检查项目是否重名
        if(!checkProjectName(name)){
            return EasyException.Code.NAME_EXIST;
        }
        Project project=new Project();
        project.setName(name);
        project.setDescription(description);
        projectDao.save(project);
        return EasyException.Code.STATUS_OK;

    }
    /*
    根据条件查找project
     */
    @Override
    public List<Project> findProject(Long id,String name){
        List<Project> projects= projectDao.getProject(id, name);
        return projects;
    }

}




