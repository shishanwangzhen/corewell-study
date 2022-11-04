package com.corewell.study.dao;

import com.corewell.study.domain.Student;
import com.corewell.study.domain.request.StudentReq;
import com.corewell.study.domain.request.StudentStudentReq;
import com.corewell.study.domain.response.AccountDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface StudentDao {
    /**
     * 查询账号
     *
     * @param account
     * @return
     */
    AccountDo selectStudentByAccount(String account);

    /**
     * 查询账号
     *
     * @param studentReq
     * @return
     */
    List<Student> findStudent(StudentReq studentReq);

    /**
     * 注册新增学生
     *
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 审核学生注册申请
     *
     * @param studentStudentReq
     * @return
     */
    int updateStudentStatus(StudentStudentReq studentStudentReq);


}
