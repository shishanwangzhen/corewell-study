package com.corewell.study.service;

import com.corewell.study.domain.Account;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
public interface AccountService {
    /**
     * 查询账号
     *
     * @param account
     * @return
     */
    Account selectAccount(String account);
}
