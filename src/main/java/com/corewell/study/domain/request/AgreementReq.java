package com.corewell.study.domain.request;

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
@ApiModel("协议")
public class AgreementReq {

  /**
   * 主键id
   */
  @ApiModelProperty(value = "主键id", required = true, example = "")
  private Long id;
  /**
   * 协议名称
   */
  @ApiModelProperty(value = "协议名称", required = true, example = "")
  private String name;
  /**
   * 协议编号
   */
  @ApiModelProperty(value = "协议编号", required = true, example = "")
  private String number;
  /**
   * 协议类型
   */
  @ApiModelProperty(value = "协议类型", required = true, example = "")
  private String type;
  /**
   * 备注
   */
  @ApiModelProperty(value = "备注", required = true, example = "")
  private String remarks;
  /**
   * 创建者id
   */
  @ApiModelProperty(value = "创建者id", required = true, example = "")
  private Long creatorId;

}
