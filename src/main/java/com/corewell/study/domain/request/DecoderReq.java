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
@ApiModel("解码器查询条件")
public class DecoderReq {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = false, example = "")
    private Long id;

    /**
     * 解码器名称
     */
    @ApiModelProperty(value = "解码器名称", required = false, example = "")
    private String name;

    /**
     * 解码器编号
     */
    @ApiModelProperty(value = "解码器编号", required = false, example = "")
    private String number;

    /**
     * 解码器型号
     */
    @ApiModelProperty(value = "解码器型号", required = false, example = "")
    private String model;

    /**
     * 解码器路径
     */
    @ApiModelProperty(value = "解码器路径", required = false, example = "")
    private String path;

    /**
     * 解码器端口
     */
    @ApiModelProperty(value = "解码器端口", required = false, example = "")
    private String port;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = false, example = "")
    private String remarks;

    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id", required = false, example = "")
    private Long creatorId;

    /**
     * 协议id
     */
    @ApiModelProperty(value = "协议id", required = false, example = "")
    private Long agreementId;

}
