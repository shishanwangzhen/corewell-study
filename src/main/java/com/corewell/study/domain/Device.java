package com.corewell.study.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("设备")
public class Device {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = false, example = "")
    private Long id;
    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id", required = false, example = "")
    private Long deviceId;

    /**
     * 设备组Id
     */
    @ApiModelProperty(value = "设备组Id", required = false, example = "")
    private Long groupId;
    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称", required = true, example = "")
    private String deviceName;

    /**
     * 设备序列号
     */
    @ApiModelProperty(value = "设备序列号", required = false, example = "")
    private String deviceNo;
    /**
     * 设备在地图上的经度
     */
    @ApiModelProperty(value = "设备在地图上的经度", required = false, example = "")
    private String lng;
    /**
     * 设备在地图上的纬度
     */
    @ApiModelProperty(value = "设备在地图上的纬度", required = false, example = "")
    private String lat;
    /**
     * 协议类型 "tcp","modbus" "mdtcp","udp","mqtt","tp500","coap","http","nbiot" 注意区分大小写 必填参数
     */
    @ApiModelProperty(value = "协议类型  tcp,modbus,mdtcp,udp,mqtt,tp500coap,http,nbiot 注意区分大小写 必填参数", required = true, example = "")
    private String linkType;
    /**
     * 设备是否报警，(0 未报警，1已报警)
     */
    @ApiModelProperty(value = "设备是否报警，(0 未报警，1已报警)", required = false, example = "")
    private String isAlarms;
    /**
     * 掉线延时
     */
    @ApiModelProperty(value = "掉线延时", required = false, example = "")
    private Long timescale;
    /**
     * 设备图标
     */
    @ApiModelProperty(value = "设备图标", required = false, example = "")
    private String iocUrl;
    /**
     * 是否在线 0 否 1 是
     */
    @ApiModelProperty(value = "是否在线 0 否 1 是", required = false, example = "")
    private Long isLine;
    /**
     * 是否删除 0 否 1 是 2禁用
     */
    @ApiModelProperty(value = "是否删除 0 否 1 是 2禁用", required = false, example = "")
    private Long isDelete;

    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id", required = false, example = "")
    private Long userId;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = false, example = "")
    private String userName;
    /**
     * 设备类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）
     */
    @ApiModelProperty(value = "设备类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）", required = false, example = "")
    private String type;

    /**
     * 绑定状态（0.未绑定项目，1.已绑定项目）
     */
    @ApiModelProperty(value = "绑定状态（0.未绑定项目，1.已绑定项目）", required = false, example = "")
    private String binding;
    /**
     * 项目负责人id
     */
    @ApiModelProperty(value = "项目负责人id", required = false, example = "")
    private Long bindingId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id", required = false, example = "")
    private Long projectId;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id", required = true, example = "")
    private Long creatorId;
    /**
     * 解码器id
     */
    @ApiModelProperty(value = "解码器id", required = false, example = "")
    private Long decoderId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = false, example = "")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", required = false, example = "")
    private Date updateTime;

    /**
     * 控制器id
     */
    @ApiModelProperty(value = "控制器id", required = true, example = "")
    private Long controllerDeviceId;
    /**
     * 控制器通道id
     */
    @ApiModelProperty(value = "控制器通道id", required = false, example = "")
    private Long sensorId;

    /**
     * 开启指令
     */
    @ApiModelProperty(value = "开启指令", required = false, example = "")
    private String switchOn;
    /**
     * 关闭指令
     */
    @ApiModelProperty(value = "关闭指令", required = false, example = "")
    private String switchOff;

    /**
     * 控制器名称
     */
    @ApiModelProperty(value = "控制器名称", required = false, example = "")
    private String controllerDeviceName;

    /**
     * 控制器序列号
     */
    @ApiModelProperty(value = "控制器序列号", required = false, example = "")
    private String controllerDeviceNo;



}
