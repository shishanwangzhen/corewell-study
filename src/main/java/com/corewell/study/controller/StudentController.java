package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.config.UserRequest;
import com.corewell.study.domain.Student;
import com.corewell.study.domain.request.StudentReq;
import com.corewell.study.domain.request.StudentStatusReqParam;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.StudentService;
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
@RequestMapping("/core/student")
@Api(tags = "学生")
public class StudentController {
    @Resource
    private StudentService studentService;

    @ApiOperation("查询学生")
    @PostMapping("/selectStudent")
    public ResultMsg selectStudent(@RequestBody StudentReq studentReq) {
        ResultMsg resultMsg = studentService.findStudent(studentReq);
        return resultMsg;

    }

    @ApiOperation("查询组成员")
    @PostMapping("/selectStudentGroup")
    public ResultMsg selectStudentGroup(Long id) {
        System.out.println("查询组成员 id");
        ResultMsg resultMsg = studentService.selectStudentGroup(id);
        return resultMsg;

    }

    @ApiOperation("查询学生信息")
    @PostMapping("/selectStudentById")
    public ResultMsg selectStudentById(Long id) {
        ResultMsg resultMsg = studentService.selectStudentById(id);
        return resultMsg;

    }

    @ApiOperation("学生信息修改")
    @PostMapping("/updateStudent")
    public ResultMsg updateStudent(@RequestBody Student student) {
        ResultMsg resultMsg = studentService.updateStudent(student);
        return resultMsg;

    }
    @ApiOperation("删除学生信息")
    @PostMapping("/deleteStudentById")
    public ResultMsg deleteStudentById(Long id) {
        ResultMsg resultMsg = studentService.deleteStudentById(id);
        return resultMsg;

    }

    @ApiOperation("批量修改学生状态")
    @PostMapping("/updateStudentStatus")
    public ResultMsg updateStudentStatus(@RequestBody StudentStatusReqParam studentStatusReqParam) {
        ResultMsg resultMsg = studentService.updateStudentStatus(studentStatusReqParam);
        return resultMsg;

    }

}
