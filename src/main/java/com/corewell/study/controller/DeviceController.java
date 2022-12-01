package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.Device;
import com.corewell.study.domain.request.DeviceBindingReq;
import com.corewell.study.domain.request.DeviceReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/10/31/14:41
 * @Description:
 */
@RestController
@RequestMapping("/core/Device")
@Api(tags = "设备")
public class DeviceController {
    @Resource
    private DeviceService DeviceService;

    @ApiOperation("查询设备")
    @PostMapping("/findDevice")
    public ResultMsg findDevice(@RequestBody DeviceReq deviceReq) {
        ResultMsg resultMsg = DeviceService.findDevice(deviceReq);
        return resultMsg;

    }

    @ApiOperation("设备修改")
    @PostMapping("/updateDevice")
    public ResultMsg updateDevice(@RequestBody Device device) {
        System.out.println(JSON.toJSON(device));
        ResultMsg resultMsg = DeviceService.updateDevice(device);
        return resultMsg;

    }

    @ApiOperation("设备新增")
    @PostMapping("/insertDevice")
    public ResultMsg insertDevice(@RequestBody Device device) {
        System.out.println(JSON.toJSON(device));
        ResultMsg resultMsg = DeviceService.insertDevice(device);
        return resultMsg;

    }

    @ApiOperation("设备删除")
    @PostMapping("/updateDeviceStatus")
    public ResultMsg updateDeviceStatus(Long id) {
        ResultMsg resultMsg = DeviceService.updateDeviceStatus(id);
        return resultMsg;

    }

    @ApiOperation("项目配置设备")
    @PostMapping("/updateDeviceBinding")
    public ResultMsg updateDeviceBinding(@RequestBody DeviceBindingReq deviceBindingReq) {
        System.out.println(JSON.toJSON(deviceBindingReq));
        ResultMsg resultMsg = DeviceService.updateDeviceBinding(deviceBindingReq);
        return resultMsg;

    }

}
