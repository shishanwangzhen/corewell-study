package com.corewell.study.service.impl;

import com.corewell.study.dao.TeacherDao;
import com.corewell.study.domain.response.AccountDo;
import com.corewell.study.domain.response.TeacherDTO;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.TeacherService;
import com.corewell.study.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Service("TeacherService")
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public ResultMsg selectTeacher(String account, String password) {
        AccountDo accountDo = teacherDao.selectTeacher(account);
        if (accountDo == null) {
            return new ResultMsg(ResultStatusCode.NO_USER);
        }
        if (!password.equals(accountDo.getPassword())) {
            return new ResultMsg(ResultStatusCode.LOGIN_ERR);
        }
        //准备存放在IWT中的自定义数据
        Map<String, Object> info = new HashMap<>(16);
        info.put("id", accountDo.getId());
        info.put("account", account);
        info.put("password", accountDo.getPassword());
        info.put("name", accountDo.getName());

        //生成JWT字符串
        String token = JwtUtil.sign(account, info);
        accountDo.setToken(token);
        return ResultMsg.success(accountDo);
    }

    @Override
    public ResultMsg findTeacher() {
        List<TeacherDTO> teacherList = teacherDao.findTeacher();
        return ResultMsg.success(teacherList);
    }
}
