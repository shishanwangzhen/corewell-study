package com.corewell.study.service.impl;

import com.corewell.study.dao.TeacherDao;
import com.corewell.study.domain.response.AccountDo;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.TeacherService;
import com.corewell.study.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public ResultMsg selectTeacher(String account, String password) {
        AccountDo accountDo = teacherDao.selectTeacher(account);
        accountDo.setToken(UUIDUtil.get32uuid());
        if (accountDo == null) {
            return new ResultMsg(ResultStatusCode.NO_USER);
        }
        if (!password.equals(accountDo.getPassword())) {
            return new ResultMsg(ResultStatusCode.LOGIN_ERR);
        }
        return ResultMsg.success(accountDo);
    }
}
