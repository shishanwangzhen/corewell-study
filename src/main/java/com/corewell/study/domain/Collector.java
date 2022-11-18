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
@ApiModel("采集器")
public class Collector {

  /**
   * 主键id
   */
  @ApiModelProperty(value = "主键id", required = true, example = "")
  private Long id;
  /**
   * 设备型号
   */
  @ApiModelProperty(value = "设备型号", required = true, example = "")
  private String model;
  /**
   * 设备编号
   */
  @ApiModelProperty(value = "设备编号", required = true, example = "")
  private String number;
  /**
   * 采集器名称
   */
  @ApiModelProperty(value = "采集器名称", required = true, example = "")
  private String name;
  /**
   * 备注
   */
  @ApiModelProperty(value = "备注", required = true, example = "")
  private String remarks;
  /**
   * 状态（0.未绑定，1.在线，2.离线）
   */
  @ApiModelProperty(value = "状态（0.未绑定，1.在线，2.离线）", required = true, example = "")
  private String status;
  /**
   * 创建者id
   */
  @ApiModelProperty(value = "创建者id", required = true, example = "")
  private Long creatorId;
  /**
   * 解码器id
   */
  @ApiModelProperty(value = "解码器id", required = true, example = "")
  private Long decoderId;
  /**
   * 协议id
   */
  @ApiModelProperty(value = "协议id", required = true, example = "")
  private Long agreementId;
  /**
   * 状态（0.删除，1.正常）
   */
  @ApiModelProperty(value = "状态（0.删除，1.正常）", required = true, example = "")
  private String deleteFlag;
  /**
   * 创建时间
   */
  @ApiModelProperty(value = "创建时间", required = true, example = "")
  private Date createTime;
  /**
   * 修改时间
   */
  @ApiModelProperty(value = "修改时间", required = true, example = "")
  private Date updateTime;
}
