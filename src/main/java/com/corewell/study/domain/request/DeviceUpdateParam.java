package com.corewell.study.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("设备")
public class DeviceUpdateParam {

    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称", required = true, example = "")
    private String deviceName;

    /**
     * 协议类型 "tcp","modbus" "mdtcp","udp","mqtt","tp500","coap","http","nbiot" 注意区分大小写 必填参数
     */
    @ApiModelProperty(value = "协议类型  tcp,modbus,mdtcp,udp,mqtt,tp500coap,http,nbiot 注意区分大小写 必填参数", required = true, example = "")
    private String linkType;
    /**
     * 掉线延时
     */
    @ApiModelProperty(value = "掉线延时", required = false, example = "")
    private Long timescale;

    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id", required = true, example = "")
    private Long deviceId;

    /**
     * 删除的传感器Id，多个Id之间用英文逗号分隔 ，可选参数，没有需要删除的传感器则不用传
     */
    @ApiModelProperty(value = "删除的传感器Id，多个Id之间用英文逗号分隔 ，可选参数，没有需要删除的传感器则不用传", required = true, example = "")
    private String delSensorIds;

    /**
     * 传感器集合
     */
    @ApiModelProperty(value = "删除的传感器Id，多个Id之间用英文逗号分隔 ，可选参数，没有需要删除的传感器则不用传", required = true, example = "")
    private List<SensorParam> sensorList;

}
