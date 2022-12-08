package com.corewell.study.service;

import com.corewell.study.domain.Device;
import com.corewell.study.domain.request.*;
import com.corewell.study.domain.result.ResultMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface DeviceService {
    /**
     * 查询设备
     *
     * @param deviceReq
     * @return
     */
    ResultMsg findDevice(DeviceReq deviceReq);

    /**
     * 根据deviceId查询设备详情
     *
     * @param deviceId
     * @return
     */
    ResultMsg findDeviceByDeviceId(Long deviceId);

    /**
     * 新增设备
     *
     * @param deviceInsertParam
     * @return
     */
    ResultMsg insertDevice(DeviceInsertParam deviceInsertParam);

    /**
     * 修改设备
     *
     * @param deviceUpdateParam
     * @return
     */
    ResultMsg updateDevice(DeviceUpdateParam deviceUpdateParam);

    /**
     * 删除设备
     *
     * @param deviceId
     * @return
     */
    ResultMsg deleteDevice(Long deviceId);
    /**
     * 设备绑定项目
     *
     * @param deviceBindingReq
     * @return
     */
    ResultMsg updateDeviceBinding(DeviceBindingReq deviceBindingReq);

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    ResultMsg updateDeviceBindingById(Long id);

    /**
     * 设备开关下行控制
     *
     * @param deviceSwitcherParam
     * @return
     */
    ResultMsg switcherController(DeviceSwitcherParam deviceSwitcherParam);

    /**
     * 设备数据下行
     *
     * @param deviceWriteParam
     * @return
     */
    ResultMsg deviceWrite(DeviceWriteParam deviceWriteParam);
}
