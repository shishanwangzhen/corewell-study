package com.corewell.study.service.impl;

import com.corewell.study.dao.AccountDao;
import com.corewell.study.domain.Account;
import com.corewell.study.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/17:04
 * @Description:
 */
@Service("AccountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public Account selectAccount(String account) {
        return accountDao.selectAccount(account);
    }
}
