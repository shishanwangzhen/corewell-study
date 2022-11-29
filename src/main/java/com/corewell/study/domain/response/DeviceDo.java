package com.corewell.study.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("设备查询还参")
public class DeviceDo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = false, example = "")
    private Long id;
    /**
     * 设备型号
     */
    @ApiModelProperty(value = "设备型号", required = false, example = "")
    private String model;
    /**
     * 设备编号
     */
    @ApiModelProperty(value = "设备编号", required = false, example = "")
    @NotNull(message = "number不能为空")
    private String number;
    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称", required = false, example = "")
    private String name;
    /**
     * 协议类型
     */
    @ApiModelProperty(value = "协议类型", required = false, example = "")
    private String agreement;
    /**
     * 厂商
     */
    @ApiModelProperty(value = "厂商", required = false, example = "")
    private String manufacturer;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = false, example = "")
    private String remarks;
    /**
     * 绑定状态（0.未绑定项目，1.已绑定项目）
     */
    @ApiModelProperty(value = "绑定状态（0.未绑定项目，1.已绑定项目）", required = false, example = "")
    private String binding;
    /**
     * 工作状态（0.未绑定，1.在线，2.离线）
     */
    @ApiModelProperty(value = "工作状态（0.未绑定，1.在线，2.离线）", required = false, example = "")
    private String status;
    /**
     * 设备类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）
     */
    @ApiModelProperty(value = "设备类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）", required = false, example = "")
    private String type;
    /**
     * 设备是否报警，(0 未报警，1已报警)
     */
    @ApiModelProperty(value = "设备是否报警，(0 未报警，1已报警)", required = false, example = "")
    private String isAlarms;
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
     * 状态（0.删除，1.正常）
     */
    @ApiModelProperty(value = "状态（0.删除，1.正常）", required = false, example = "")
    private String deleteFlag;
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
     * 绑定项目负责人
     */
    @ApiModelProperty(value = "绑定项目负责人", required = false, example = "")
    private String bindingName;
    /**
     * 解码器
     */
    @ApiModelProperty(value = "解码器", required = false, example = "")
    private String decoderName;
    /**
     * 设备导入人
     */
    @ApiModelProperty(value = "设备导入人", required = false, example = "")
    private String creatorName;
    /**
     * 绑定项目
     */
    @ApiModelProperty(value = "绑定项目", required = false, example = "")
    private String projectName;



}
