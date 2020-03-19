package com.easytest.service.impl;

import com.easytest.Exception.EasyException;
import com.easytest.dao.ProjectDao;
import com.easytest.model.Project;
import com.easytest.service.IProjectManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManageImpl implements IProjectManage {

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

    /**
     * 创建新项目
     * @param name
     * @param description
     * @return
     */
    @Override
    public EasyException.Code save(Long id,String name,String description) {
        //新建的项目检查是否重名
//        if(!checkProjectName(name)&&id==null){
//            return EasyException.Code.NAME_EXIST;
//        }
        //不是新项目，则先查询出来
        if(id!=null){
            Project project=projectDao.getProjectById(id);
            project.setName(name);
            project.setDescription(description);
            projectDao.save(project);
            return EasyException.Code.STATUS_OK;

        }
        //新项目
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




