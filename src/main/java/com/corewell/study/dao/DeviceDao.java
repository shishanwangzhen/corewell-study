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
     * 删除设备
     *
     * @param id
     * @return
     */
    int updateDeviceStatus(@Param("id") Long id);
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



}
