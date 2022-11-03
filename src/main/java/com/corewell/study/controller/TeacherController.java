/*
package com.corewell.study.controller;

import com.corewell.study.domain.Account;
import com.corewell.study.domain.request.AccountReq;
import com.corewell.study.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

*/
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/10/31/14:41
 * @Description:
 *//*

@RestController
@RequestMapping("/teacher")
@Api(tags = "登录")
public class TeacherController {
    @Resource
    private AccountService accountService;

    @ApiOperation("教师登录")
    @PostMapping("/teacher")
    public Account loginTeacher(@RequestBody AccountReq accountReq){
        String account=accountReq.getAccount();
        return accountService.selectAccount(account);

    }


    @ApiOperation("学生登录")
    @PostMapping("/teacher")
    public Account loginStudent(@RequestBody AccountReq accountReq){

        String account=accountReq.getAccount();
        return accountService.selectAccount(account);

    }

}
*/
