package com.corewell.study.service.impl;

import com.corewell.study.annotation.AddLog;
import com.corewell.study.dao.DeviceDao;
import com.corewell.study.dao.GroupDao;
import com.corewell.study.dao.ProjectDao;
import com.corewell.study.dao.StudentDao;
import com.corewell.study.domain.Project;
import com.corewell.study.domain.request.ProjectReq;
import com.corewell.study.domain.response.ProjectDo;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
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
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private DeviceDao deviceDao;

    @Override
    public ResultMsg findProject(ProjectReq projectReq) {
        List<ProjectDo> projectDos = projectDao.findProject(projectReq);
        return ResultMsg.success(projectDos);
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
    @AddLog(interfaceType = "2", interfaceInfo = "项目信息修改", interfaceName = "updateProject", dataId = "#{project.id}")
    public ResultMsg updateProject(Project project) {
        project.setUpdateTime(new Date());
        int result = projectDao.updateProject(project);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.UPDATE_FAILED);
    }

    @Override
    @AddLog(interfaceType = "1", interfaceInfo = "项目删除", interfaceName = "updateProjectStatus", dataId = "#{id}")
    public ResultMsg updateProjectStatus(Long id) {
        int result = projectDao.updateProjectStatus(id);
        studentDao.updateProjectStudentByProjectId(id);
        groupDao.updateGroupStatusByProjectId(id);
        deviceDao.updateBindingByProjectId(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.DELETE_FAILED);
    }

    @Override
    @AddLog(interfaceType = "1", interfaceInfo = "项目一键删除", interfaceName = "updateProjectStatusByCreatorId", dataId = "#{creatorId}")
    public ResultMsg updateProjectStatusByCreatorId(Long creatorId) {
        int result = projectDao.updateProjectStatusByCreatorId(creatorId);
        studentDao.updateProjectStatusByTeacherId(creatorId);
        groupDao.updateGroupStatusByCreatorId(creatorId);
        deviceDao.updateBindingByBindingId(creatorId);
        System.out.println("删除数目：：：：：" + result);
        if (result >= 0) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.DELETE_FAILED);
    }
}
