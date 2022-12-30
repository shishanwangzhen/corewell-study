package com.corewell.study.dao;

import com.corewell.study.domain.Device;
import com.corewell.study.domain.request.DeviceBindingReq;
import com.corewell.study.domain.request.DeviceReq;
import com.corewell.study.domain.response.DeviceDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface DeviceDao {
    /**
     * 查询设备
     *
     * @param deviceReq
     * @return
     */
    List<DeviceDo> findDevice(DeviceReq deviceReq);

    /**
     * 新增设备
     *
     * @param device
     * @return
     */
    int insertDevice(Device device);

    /**
     * 修改设备
     *
     * @param device
     * @return
     */
    int updateDevice(Device device);


    /**
     * 修改被控设备
     *
     * @param device
     * @return
     */
    int updateControllerDevice(Device device);

    /**
     * 删除设备
     *
     * @param deviceId
     * @return
     */
    int deleteDevice(@Param("deviceId") Long deviceId);

    /**
     * 删除设备通过id
     *
     * @param id
     * @return
     */
    int deleteDeviceById(@Param("id") Long id);

    /**
     * 查询被控设备
     *
     * @param device
     * @return
     */
    List<Device> selectControllerDevice(Device device);


    /**
     * 解绑被控设备控制器
     * @param deviceId
     * @return
     */
    int unbindDeviceNumberByDeviceId(@Param("deviceId") Long deviceId);

    /**
     * 解绑被控设备控制器
     * @param sensorId
     * @return
     */
    int unbindDeviceNumberBindBySensorId(@Param("sensorId") String sensorId);

    /**
     * 解绑被控设备控制器
     * @param id
     *
     * @return
     */
    int unbindDeviceNumberBindById(@Param("id") Long id);

    /**
     * 删除项目
     *
     * @param projectId
     * @return
     */
    int updateBindingByProjectId(@Param("projectId") Long projectId);

    /**
     * 删除项目
     *
     * @param bindingId
     * @return
     */
    int updateBindingByBindingId(Long bindingId);

    /**
     * 修改设备
     *
     * @param deviceBindingReq
     * @return
     */
    int updateDeviceBinding(DeviceBindingReq deviceBindingReq);

    /**
     * 解绑设备
     *
     * @param id
     * @return
     */
    int updateDeviceBindingById(@Param("id") Long id);



}
