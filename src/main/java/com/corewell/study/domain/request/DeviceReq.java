package com.corewell.study.domain.request;

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
@ApiModel("设备查询条件")
public class DeviceReq {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = false, example = "")
    private Long id;

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

}
