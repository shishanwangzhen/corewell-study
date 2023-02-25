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
@ApiModel("查询日志入参")
public class LogReq {

  /**
   * 用户账号id
   */
  @ApiModelProperty(value = "用户账号id", required = false, example = "")
  private Long accountId;
  /**
   * 用户账号
   */
  @ApiModelProperty(value = "用户账号", required = false, example = "")
  private String account;
  /**
   * 接口类型（1.删除，2.修改）
   */
  @ApiModelProperty(value = "接口类型（1.删除，2.修改）", required = false, example = "")
  private Long interfaceType;

  /**
   * 开始时间
   */
  @ApiModelProperty(value = "开始时间", required = false, example = "")
  private Date startTime;

  /**
   * 结束时间
   */
  @ApiModelProperty(value = "结束时间", required = false, example = "")
  private Date endTime;

}
