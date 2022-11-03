package com.corewell.study.dao;

import com.corewell.study.domain.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface AccountDao {
    /**
     * 查询账号
     *
     * @param account
     * @return
     */
    Account selectAccount(String account);
}
