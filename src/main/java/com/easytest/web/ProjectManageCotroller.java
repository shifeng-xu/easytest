package com.easytest.web;


import com.easytest.Exception.EasyException;
import com.easytest.model.Project;
import com.easytest.rest.request.ProjectSaveRequest;
import com.easytest.rest.request.ProjectSearchRequest;
import com.easytest.rest.response.ProjectSaveResponse;
import com.easytest.rest.response.ProjectSearchResponse;
import com.easytest.service.IProjectManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectManageCotroller {

    @Autowired
    private IProjectManage projectManageService;

    /**
     * 新建一个项目
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ProjectSaveResponse saveProject(@RequestBody ProjectSaveRequest request){

        EasyException.Code result=projectManageService.save(request.getName(),request.getDescription());

        ProjectSaveResponse response=new ProjectSaveResponse();
        response.setCode(result);
        return response;

    }

    /**
     * 按条件搜索项目（只返回项目ID和名称）
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ProjectSearchResponse searchResponse(@RequestBody ProjectSearchRequest request){
        List<Project> projectList= projectManageService.findProject(request.getId(),request.getName());
        ProjectSearchResponse response=new ProjectSearchResponse();
        response.setProjectList(projectList);
        response.setCode(EasyException.Code.STATUS_OK);
        return response;
    }

}
