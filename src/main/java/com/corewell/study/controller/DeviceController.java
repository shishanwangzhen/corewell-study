package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.Device;
import com.corewell.study.domain.request.*;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

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
        System.out.println("findDevice入参：：：：" + JSON.toJSONString(deviceReq));
        ResultMsg resultMsg = DeviceService.findDevice(deviceReq);
        return resultMsg;

    }
    @ApiOperation("查询设备和状态")
    @PostMapping("/findDeviceAndIsLine")
    public ResultMsg findDeviceAndIsLine(@RequestBody DeviceReq deviceReq) {
        ResultMsg resultMsg = DeviceService.findDeviceAndIsLine(deviceReq);
        return resultMsg;

    }

    @ApiOperation("定时任务查询设备状态")
    @PostMapping("/findDeviceIsLine")
    @ApiIgnore
    public ResultMsg findDeviceIsLine(Long deviceId) {
        ResultMsg resultMsg = DeviceService.findDeviceIsLine(deviceId);
        return resultMsg;

    }

    @ApiOperation("查询采集控制设备")
    @PostMapping("/findControllerAndCollectionDevice")
    public ResultMsg findControllerAndCollectionDevice(@RequestBody ControllerAndCollectionDeviceReq controllerAndCollectionDeviceReq) {
        ResultMsg resultMsg = DeviceService.findControllerAndCollectionDevice(controllerAndCollectionDeviceReq);
        return resultMsg;

    }

    @ApiOperation("查询设备绑定项目组")
    @PostMapping("/findDeviceBindGroup")
    public ResultMsg findDeviceBindGroup(Long projectId) {
        ResultMsg resultMsg = DeviceService.findDeviceBindGroup(projectId);
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

    @ApiOperation("视频设备修改")
    @PostMapping("/updateVideoDevice")
    public ResultMsg updateVideoDevice(@RequestBody Device device) {
        System.out.println(JSON.toJSON(device));
        ResultMsg resultMsg = DeviceService.updateVideoDevice(device);
        return resultMsg;

    }

    @ApiOperation("设备新增")
    @PostMapping("/insertDevice")
    public ResultMsg insertDevice(@RequestBody DeviceInsertParam deviceInsertParam) {
        System.out.println(JSON.toJSON(deviceInsertParam));
        ResultMsg resultMsg = DeviceService.insertDevice(deviceInsertParam);
        return resultMsg;

    }


    @ApiOperation("视频设备删除")
    @PostMapping("/deleteVideoDevice")
    public ResultMsg deleteVideoDevice(Long id) {
        System.out.println(JSON.toJSON(id));
        ResultMsg resultMsg = DeviceService.deleteVideoDevice(id);
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

    @ApiOperation("项目组绑定设备")
    @PostMapping("/updateDeviceBindingGroup")
    public ResultMsg updateDeviceBindingGroup(@RequestBody DeviceBindingGroupReq deviceBindingGroupReq) {
        System.out.println(JSON.toJSON(deviceBindingGroupReq));
        ResultMsg resultMsg = DeviceService.updateDeviceBindingGroup(deviceBindingGroupReq);
        return resultMsg;

    }

    @ApiOperation("设备移除项目组")
    @PostMapping("/updateBindingGroupById")
    public ResultMsg updateBindingGroupById(Long id) {
        ResultMsg resultMsg = DeviceService.updateBindingGroupById(id);
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
    @ApiIgnore
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

    @ApiOperation("获取tcp/udp协议标签")
    @PostMapping("/getProtocolLabel")
    public ResultMsg getProtocolLabel(Long deviceId) {
        ResultMsg resultMsg = DeviceService.getProtocolLabel(deviceId);
        return resultMsg;
    }

    @ApiOperation("获取mqtt/tp500/coap协议读写标识")
    @PostMapping("/getFlag")
    public ResultMsg getFlag(@RequestBody GetSensorFlagReq getSensorFlagReq) {
        ResultMsg resultMsg = DeviceService.getFlag(getSensorFlagReq);
        return resultMsg;
    }


    @ApiOperation("设置mqtt/tp500/coap协议读写标识")
    @PostMapping("/setFlag")
    public ResultMsg setFlag(@RequestBody SetSensorFlagReq setSensorFlagReq) {
        ResultMsg resultMsg = DeviceService.setFlag(setSensorFlagReq);
        return resultMsg;
    }

    @ApiOperation("设置tcp/udp协议标签")
    @PostMapping("/setProtocolLabel")
    public ResultMsg setProtocolLabel(@RequestBody ProtocolLabelReq protocolLabelReq) {
        ResultMsg resultMsg = DeviceService.setProtocolLabel(protocolLabelReq);
        return resultMsg;
    }


    @ApiOperation("获取单个传感器数据")
    @PostMapping("/getSingleSensorDatas")
    public ResultMsg getSingleSensorDatas(Long sensorId) {
        ResultMsg resultMsg = DeviceService.getSingleSensorDatas(sensorId);
        return resultMsg;
    }


}
