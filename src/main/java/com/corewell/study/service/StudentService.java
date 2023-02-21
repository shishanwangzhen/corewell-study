package com.corewell.study.service;

import com.corewell.study.domain.Student;
import com.corewell.study.domain.request.StudentReq;
import com.corewell.study.domain.request.StudentStatusReqParam;
import com.corewell.study.domain.result.ResultMsg;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
public interface StudentService {
    /**
     * 查询账号
     *
     * @param account
     * @param password
     * @return
     */
    ResultMsg selectStudentByAccount(String account, String password);

    /**
     * 查询学生信息
     *
     * @param studentReq
     * @return
     */
    ResultMsg findStudent(StudentReq studentReq);

    /**
     * 查询组成员
     *
     * @param groupId
     * @return
     */
    ResultMsg selectStudentGroup(Long groupId);

    /**
     * 查询学生信息
     *
     * @param id
     * @return
     */
    ResultMsg selectStudentById(Long id);

    /**
     * 注册新增学生
     *
     * @param student
     * @return
     */
    ResultMsg insertStudent(Student student);

    /**
     * 修改账号
     *
     * @param student
     * @return
     */
    ResultMsg updateStudent(Student student);


    /**
     * 审核学生注册申请
     *
     * @param studentStatusReqParam
     * @return
     */
    ResultMsg updateStudentStatus(StudentStatusReqParam studentStatusReqParam);

    /**
     * 批量审核学生注册申请
     *
     * @param ids
     * @return
     */
    ResultMsg updateStudentStatusByIds(List<Long> ids);


}
