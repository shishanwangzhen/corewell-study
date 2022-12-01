package com.corewell.study.service;

import com.corewell.study.domain.Device;
import com.corewell.study.domain.request.DeviceBindingReq;
import com.corewell.study.domain.request.DeviceReq;
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
     * 新增设备
     *
     * @param device
     * @return
     */
    ResultMsg insertDevice(Device device);

    /**
     * 修改设备
     *
     * @param device
     * @return
     */
    ResultMsg updateDevice(Device device);

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    ResultMsg updateDeviceStatus(@Param("id") Long id);
    /**
     * 设备绑定项目
     *
     * @param deviceBindingReq
     * @return
     */
    ResultMsg updateDeviceBinding(DeviceBindingReq deviceBindingReq);


}
