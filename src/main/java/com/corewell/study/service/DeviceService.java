package com.corewell.study.service;

import com.corewell.study.domain.request.*;
import com.corewell.study.domain.result.ResultMsg;
import org.apache.ibatis.annotations.Mapper;

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

    /**
     * 传感器数据上报
     *
     * @param sendDataPointParam
     * @return
     */
    ResultMsg sendDataPoint(SendDataPointParam sendDataPointParam);


    /**
     * 获取设备传感器历史数据
     *
     * @param sensorHistoryParam
     * @return
     */
    ResultMsg getSensorHistroy(SensorHistoryParam sensorHistoryParam);

    /**
     * 获取设备参数
     *
     * @param deviceId
     * @return
     */
    ResultMsg getParams(Long deviceId);

    /**
     * 设置参数
     *
     * @param setParamsReq
     * @return
     */
    ResultMsg setParams(SetParamsReq setParamsReq);

    /**
     * modbus 协议读写指令设置
     *
     * @param modbusReq
     * @return
     */
    ResultMsg setModbus(ModbusReq modbusReq);


    /**
     * 获取modbus读写指令
     *
     * @param modbusReq
     * @return
     */
    ResultMsg getModbus(ModbusReq modbusReq);

    /**
     * modbus读写指令修改
     *
     * @param modbusReq
     * @return
     */
    ResultMsg updateModbus(ModbusReq modbusReq);

    /**
     * 获取tcp/udp协议标签
     *
     * @param deviceId
     * @return
     */
    ResultMsg getProtocolLabel(Long deviceId);

    /**
     * tcp/udp协议标签设置
     *
     * @param protocolLabelReq
     * @return
     */
    ResultMsg setProtocolLabel(ProtocolLabelReq protocolLabelReq);


    /**
     * 获取mqtt/tp500/coap协议读写标识
     *
     * @param getSensorFlagReq
     * @return
     */
    ResultMsg getFlag(GetSensorFlagReq getSensorFlagReq);

    /**
     * 设置mqtt/tp500/coap协议读写标识
     *
     * @param setFlagReq
     * @return
     */
    ResultMsg setFlag(SetSensorFlagReq setFlagReq);
}
