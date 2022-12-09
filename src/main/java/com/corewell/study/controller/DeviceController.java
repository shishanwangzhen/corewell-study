package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.request.*;
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

    @ApiOperation("根据deviceId查询设备详情")
    @PostMapping("/findDeviceByDeviceId")
    public ResultMsg findDeviceByDeviceId(Long deviceId) {
        ResultMsg resultMsg = DeviceService.findDeviceByDeviceId(deviceId);
        return resultMsg;

    }


    @ApiOperation("设备修改")
    @PostMapping("/updateDevice")
    public ResultMsg updateDevice(@RequestBody DeviceUpdateParam deviceUpdateParam) {
        System.out.println(JSON.toJSON(deviceUpdateParam));
        ResultMsg resultMsg = DeviceService.updateDevice(deviceUpdateParam);
        return resultMsg;

    }

    @ApiOperation("设备新增")
    @PostMapping("/insertDevice")
    public ResultMsg insertDevice(@RequestBody DeviceInsertParam deviceInsertParam) {
        System.out.println(JSON.toJSON(deviceInsertParam));

        ResultMsg resultMsg = DeviceService.insertDevice(deviceInsertParam);
        return resultMsg;

    }

    @ApiOperation("设备删除")
    @PostMapping("/deleteDevice")
    public ResultMsg deleteDevice(Long deviceId) {
        ResultMsg resultMsg = DeviceService.deleteDevice(deviceId);
        return resultMsg;

    }

    @ApiOperation("项目配置设备")
    @PostMapping("/updateDeviceBinding")
    public ResultMsg updateDeviceBinding(@RequestBody DeviceBindingReq deviceBindingReq) {
        System.out.println(JSON.toJSON(deviceBindingReq));
        ResultMsg resultMsg = DeviceService.updateDeviceBinding(deviceBindingReq);
        return resultMsg;

    }

    @ApiOperation("项目解绑设备")
    @PostMapping("/updateDeviceBindingById")
    public ResultMsg updateDeviceBindingById(Long id) {
        ResultMsg resultMsg = DeviceService.updateDeviceBindingById(id);
        return resultMsg;

    }

    @ApiOperation("设备开关下行控制")
    @PostMapping("/switcherController")
    public ResultMsg switcherController(@RequestBody DeviceSwitcherParam deviceSwitcherParam) {
        ResultMsg resultMsg = DeviceService.switcherController(deviceSwitcherParam);
        return resultMsg;

    }

    @ApiOperation("设备数据下行")
    @PostMapping("/deviceWrite")
    public ResultMsg deviceWrite(@RequestBody DeviceWriteParam deviceWriteParam) {
        ResultMsg resultMsg = DeviceService.deviceWrite(deviceWriteParam);
        return resultMsg;
    }

    @ApiOperation("传感器数据上报")
    @PostMapping("/sendDataPoint")
    public ResultMsg sendDataPoint(@RequestBody SendDataPointParam sendDataPointParam) {
        ResultMsg resultMsg = DeviceService.sendDataPoint(sendDataPointParam);
        return resultMsg;
    }

    @ApiOperation("获取设备传感器历史数据")
    @PostMapping("/getSensorHistroy")
    public ResultMsg getSensorHistroy(@RequestBody SensorHistoryParam sensorHistoryParam) {
        ResultMsg resultMsg = DeviceService.getSensorHistroy(sensorHistoryParam);
        return resultMsg;
    }


    @ApiOperation("获取设备参数")
    @PostMapping("/getParams")
    public ResultMsg getParams(Long deviceId) {
        ResultMsg resultMsg = DeviceService.getParams(deviceId);
        return resultMsg;
    }
    @ApiOperation("设置参数")
    @PostMapping("/setParams")
    public ResultMsg setParams(@RequestBody SetParamsReq setParamsReq) {
        ResultMsg resultMsg = DeviceService.setParams(setParamsReq);
        return resultMsg;
    }

    @ApiOperation("modbus 协议读写指令设置")
    @PostMapping("/setModbus")
    public ResultMsg setModbus(@RequestBody ModbusReq modbusReq) {
        ResultMsg resultMsg = DeviceService.setModbus(modbusReq);
        return resultMsg;
    }


    @ApiOperation("获取modbus读写指令")
    @PostMapping("/getModbus")
    public ResultMsg getModbus(@RequestBody ModbusReq modbusReq) {
        ResultMsg resultMsg = DeviceService.getModbus(modbusReq);
        return resultMsg;
    }


    @ApiOperation("modbus读写指令修改")
    @PostMapping("/updateModbus")
    public ResultMsg updateModbus(@RequestBody ModbusReq modbusReq) {
        ResultMsg resultMsg = DeviceService.updateModbus(modbusReq);
        return resultMsg;
    }


}
