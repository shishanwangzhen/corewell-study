package com.corewell.study.service;

import com.corewell.study.domain.result.ResultMsg;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface DeviceNumberService {
    /**
     * 查询设备序列号
     *
     * @return
     */
    ResultMsg findDeviceNumber();


}
