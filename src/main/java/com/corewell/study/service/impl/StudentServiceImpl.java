package com.corewell.study.service.impl;

import com.corewell.study.dao.StudentDao;
import com.corewell.study.domain.Student;
import com.corewell.study.domain.request.StudentReq;
import com.corewell.study.domain.request.StudentStudentReq;
import com.corewell.study.domain.response.AccountDo;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.StudentService;
import com.corewell.study.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        accountDo.setToken(UUIDUtil.get32uuid());
        if (accountDo == null) {
            return new ResultMsg(ResultStatusCode.NO_USER);
        }
        if (!password.equals(accountDo.getPassword())) {
            return new ResultMsg(ResultStatusCode.LOGIN_ERR);
        }
        return ResultMsg.success(accountDo);
    }

    @Override
    public ResultMsg findStudent(StudentReq studentReq) {
        List<Student> studentList = studentDao.findStudent(studentReq);
        return ResultMsg.success(studentList);
    }

    @Override
    public ResultMsg insertStudent(Student student) {
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
