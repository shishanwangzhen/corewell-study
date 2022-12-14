package com.corewell.study.service.impl;

import com.corewell.study.dao.GroupDao;
import com.corewell.study.dao.StudentDao;
import com.corewell.study.domain.Group;
import com.corewell.study.domain.request.GroupReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/09/14:54
 * @Description:
 */
@Service("GroupService")
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public ResultMsg findGroup(GroupReq projectReq) {
        List<Group> projectList = groupDao.findGroup(projectReq);
        return ResultMsg.success(projectList);
    }

    @Override
    public ResultMsg insertGroup(Group group) {
        group.setCreateTime(new Date());
        group.setStatus("1");
        int result = groupDao.insertGroup(group);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateGroup(Group group) {
        group.setUpdateTime(new Date());

        int result = groupDao.updateGroup(group);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.UPDATE_FAILED);
    }

    @Override
    public ResultMsg updateGroupStatus(Long id) {
        int result = groupDao.updateGroupStatus(id);
        studentDao.updateGroupStudentByGroupId(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.DELETE_FAILED);
    }

    @Override
    public ResultMsg updateGroupStudent(Long id) {
        int result = studentDao.updateGroupStudent(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.DELETE_FAILED);
    }


}
