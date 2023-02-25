package com.corewell.study.service;

import com.corewell.study.domain.Log;
import com.corewell.study.domain.request.LogReq;
import com.corewell.study.domain.result.ResultMsg;
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
public interface LogService {
    /**
     * 查询传感器
     *
     * @param logReq
     * @return
     */
    ResultMsg findLog(LogReq logReq);


    /**
     * 新增传感器
     *
     * @param log
     * @return
     */
    int insertLog(Log log);
}