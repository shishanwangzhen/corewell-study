package com.corewell.study.dao;

import com.corewell.study.domain.response.AccountDo;
import org.apache.ibatis.annotations.Mapper;


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
}
