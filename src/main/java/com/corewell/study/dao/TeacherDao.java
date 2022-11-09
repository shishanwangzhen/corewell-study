package com.corewell.study.dao;

import com.corewell.study.domain.Student;
import com.corewell.study.domain.Teacher;
import com.corewell.study.domain.request.StudentReq;
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
public interface TeacherDao {
    /**
     * 查询账号
     *
     * @param account
     * @return
     */
    AccountDo selectTeacher(String account);

    /**
     * 查询老师
     *
     * @return
     */
    List<Teacher> findTeacher();
}
