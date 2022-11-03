package com.corewell.study.service.impl;

import com.corewell.study.dao.StudentDao;
import com.corewell.study.domain.response.AccountDo;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/03/13:10
 * @Description:
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public ResultMsg selectStudent(String account, String password) {
        AccountDo accountDo = studentDao.selectStudent(account);
        if (accountDo == null) {
            return new ResultMsg(ResultStatusCode.NO_USER);
        }
        if (!password.equals(accountDo.getPassword())) {
            return new ResultMsg(ResultStatusCode.LOGIN_ERR);
        }
        return ResultMsg.success(accountDo);
    }
}
