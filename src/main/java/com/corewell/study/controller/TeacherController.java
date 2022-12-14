package com.corewell.study.controller;

import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/10/31/14:41
 * @Description:
 */

@RestController
@RequestMapping("/teacher")
@Api(tags = "老师")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @ApiOperation("查询老师")
    @PostMapping("/findTeacher")
    public ResultMsg findTeacher() {
        ResultMsg resultMsg = teacherService.findTeacher();
        return resultMsg;

    }

}
