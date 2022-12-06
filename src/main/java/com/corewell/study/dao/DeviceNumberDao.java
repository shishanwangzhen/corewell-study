package com.corewell.study.dao;

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
public interface DeviceNumberDao {
    /**
     * 查询可用设备序列号
     *
     * @return
     */
    List<String> findDeviceNumber();


}
