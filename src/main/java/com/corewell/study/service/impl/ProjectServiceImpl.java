package com.corewell.study.service.impl;

import com.corewell.study.dao.ProjectDao;
import com.corewell.study.domain.Project;
import com.corewell.study.domain.request.ProjectReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/09/11:44
 * @Description:
 */
@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Override
    public ResultMsg findProject(ProjectReq projectReq) {
        List<Project> projectList=projectDao.findProject(projectReq);


        return ResultMsg.success(projectList);
    }

    @Override
    public ResultMsg insertProject(Project project) {
        project.setCreateTime(new Date());
        project.setStatus("1");
        int result = projectDao.insertProject(project);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateProject(Project project) {
        project.setUpdateTime(new Date());
        int result = projectDao.updateProject(project);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateProjectStatus(Long id) {
        int result = projectDao.updateProjectStatus(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }
}
