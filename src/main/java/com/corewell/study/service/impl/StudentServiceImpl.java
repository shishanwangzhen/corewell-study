package com.corewell.study.service.impl;

import com.corewell.study.dao.StudentDao;
import com.corewell.study.domain.Student;
import com.corewell.study.domain.request.StudentReq;
import com.corewell.study.domain.request.StudentStudentReq;
import com.corewell.study.domain.response.AccountDo;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.StudentService;
import com.corewell.study.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/03/13:10
 * @Description:
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public ResultMsg selectStudentByAccount(String account, String password) {
        AccountDo accountDo = studentDao.selectStudentByAccount(account);
        if (accountDo == null) {
            return new ResultMsg(ResultStatusCode.NO_USER);
        }
        if (!password.equals(accountDo.getPassword())) {
            return new ResultMsg(ResultStatusCode.LOGIN_ERR);
        }
        //准备存放在IWT中的自定义数据
        Map<String, Object> info = new HashMap<>();
        info.put("account", account);
        //生成JWT字符串
        String token = JwtUtil.sign(account, info);
        accountDo.setToken(token);
        return ResultMsg.success(accountDo);
    }

    @Override
    public ResultMsg findStudent(StudentReq studentReq) {
        List<Student> studentList = studentDao.findStudent(studentReq);
        return ResultMsg.success(studentList);
    }

    @Override
    public ResultMsg insertStudent(Student student) {
        StudentReq studentReq = new StudentReq();
        studentReq.setAccount(student.getAccount());
        List<Student> studentList = studentDao.findStudent(studentReq);
        if (studentList != null && studentList.get(0) != null) {
            return new ResultMsg(ResultStatusCode.USER_CODE_ONLY);
        }
        student.setCreateTime(new Date());
        student.setStatus("0");
        int result = studentDao.insertStudent(student);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateStudent(Student student) {
        student.setUpdateTime(new Date());
        int result = studentDao.updateStudent(student);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateStudentStatus(StudentStudentReq studentStudentReq) {
        int result = studentDao.updateStudentStatus(studentStudentReq);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }
}
