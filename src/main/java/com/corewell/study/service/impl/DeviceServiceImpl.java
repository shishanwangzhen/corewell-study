package com.corewell.study.service.impl;

import com.corewell.study.dao.DeviceDao;
import com.corewell.study.domain.Device;
import com.corewell.study.domain.request.DeviceReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/17/13:31
 * @Description:
 */
@Service("DeviceService")
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao DeviceDao;

    @Override
    public ResultMsg findDevice(DeviceReq deviceReq) {
        List<Device> DeviceList = DeviceDao.findDevice(deviceReq);
        return ResultMsg.success(DeviceList);
    }

    @Override
    public ResultMsg insertDevice(Device device) {
        device.setCreateTime(new Date());
        device.setStatus("0");
        device.setDeleteFlag("1");
        int result = DeviceDao.insertDevice(device);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateDevice(Device device) {
        device.setUpdateTime(new Date());
        int result = DeviceDao.updateDevice(device);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.UPDATE_FAILED);
    }

    @Override
    public ResultMsg updateDeviceStatus(Long id) {
        int result = DeviceDao.updateDeviceStatus(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.DELETE_FAILED);
    }
}
