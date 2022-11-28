package com.corewell.study.dao;

import com.corewell.study.domain.Device;
import com.corewell.study.domain.request.DeviceReq;
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
     * @param DeviceReq
     * @return
     */
    List<Device> findDevice(DeviceReq DeviceReq);

    /**
     * 新增设备
     *
     * @param Device
     * @return
     */
    int insertDevice(Device Device);

    /**
     * 修改设备
     *
     * @param Device
     * @return
     */
    int updateDevice(Device Device);

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    int updateDeviceStatus(@Param("id") Long id);


}
