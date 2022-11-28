package com.corewell.study.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("传感器配置查询条件")
public class SensorConfigReq {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = false, example = "")
    private Long id;
    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称", required = false, example = "")
    private String chineseName;
    /**
     * 英文名称
     */
    @ApiModelProperty(value = "英文名称", required = false, example = "")
    private String englishName;
    /**
     * 传感器节点
     */
    @ApiModelProperty(value = "传感器节点", required = false, example = "")
    private String systemName;
    /**
     * 单位
     */
    @ApiModelProperty(value = "单位", required = false, example = "")
    private String unity;
    /**
     * 解码器编号
     */
    @ApiModelProperty(value = "解码器编号", required = false, example = "")
    private String number;
    /**
     * 设备类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）
     */
    @ApiModelProperty(value = "设备类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）", required = false, example = "")
    private String type;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id", required = false, example = "")
    private Long creatorId;
    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id", required = false, example = "")
    private Long DeviceId;

}
