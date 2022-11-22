package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.Project;
import com.corewell.study.domain.request.ProjectReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/10/31/14:41
 * @Description:
 */
@RestController
@RequestMapping("/core/project")
@Api(tags = "项目")
public class ProjectController {
    @Resource
    private ProjectService projectService;

    @ApiOperation("查询项目")
    @PostMapping("/findProject")
    public ResultMsg findProject(@RequestBody ProjectReq projectReq) {
        ResultMsg resultMsg = projectService.findProject(projectReq);
        return resultMsg;

    }

    @ApiOperation("项目信息修改")
    @PostMapping("/updateProject")
    public ResultMsg updateProject(@RequestBody Project project) {
        System.out.println(JSON.toJSON(project));
        ResultMsg resultMsg = projectService.updateProject(project);
        return resultMsg;

    }

    @ApiOperation("项目信息新增")
    @PostMapping("/insertProject")
    public ResultMsg insertProject(@RequestBody Project project) {
        System.out.println(JSON.toJSON(project));
        ResultMsg resultMsg = projectService.insertProject(project);
        return resultMsg;

    }

    @ApiOperation("项目删除")
    @PostMapping("/updateProjectStatus")
    public ResultMsg updateProjectStatus(Long id) {
        ResultMsg resultMsg = projectService.updateProjectStatus(id);
        return resultMsg;

    }

    @ApiOperation("项目一键删除")
    @PostMapping("/updateProjectStatusByCreatorId")
    public ResultMsg updateProjectStatusByCreatorId(Long creatorId) {
        ResultMsg resultMsg = projectService.updateProjectStatusByCreatorId(creatorId);
        return resultMsg;

    }

}
