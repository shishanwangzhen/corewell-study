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
@ApiModel("设备查询条件")
public class DeviceReq {

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
    private String number;
    /**
     * 设备名称
     */
    @ApiModelProperty(value = "名称", required = false, example = "")
    private String name;
    /**
     * 状态（0.未绑定，1.在线，2.离线）
     */
    @ApiModelProperty(value = "状态（0.未绑定，1.在线，2.离线）", required = false, example = "")
    private String status;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id", required = false, example = "")
    private Long creatorId;

}
