package com.corewell.study.controller;

import com.corewell.study.domain.request.AccountReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.StudentService;
import com.corewell.study.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/login")
@Api(tags = "登录")
public class LoginController {

    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    @ApiOperation("教师登录")
    @PostMapping("/teacher")
    public ResultMsg loginTeacher(@RequestBody AccountReq accountReq) {
        String account = accountReq.getAccount();
        String password = accountReq.getPassword();
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return new ResultMsg(ResultStatusCode.USERNAME_PASSWORD_NULL);
        }
        ResultMsg resultMsg = teacherService.selectTeacher(account, password);
        return resultMsg;

    }


    @ApiOperation("学生登录")
    @PostMapping("/student")
    public ResultMsg loginStudent(@RequestBody AccountReq accountReq) {
        String account = accountReq.getAccount();
        String password = accountReq.getPassword();
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return new ResultMsg(ResultStatusCode.USERNAME_PASSWORD_NULL);
        }
        ResultMsg resultMsg = studentService.selectStudent(account, password);
        return resultMsg;

    }

}
