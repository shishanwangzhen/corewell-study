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
@ApiModel("PushDataParam")
public class PushDataParam {

  /**
   * 00代表成功
   */
  @ApiModelProperty(value = "00代表成功", required = false, example = "00")
  private String flag;
  /**
   * 用户ID
   */
  @ApiModelProperty(value = "用户ID", required = false, example = "77632")
  private Long deviceUserid;
  /**
   * 企业ID
   */
  @ApiModelProperty(value = "企业ID", required = true, example = "")
  private Long parentUserId;
  /**
   * 发送时间
   */
  @ApiModelProperty(value = "发送时间", required = true, example = "")
  private String time;

  /**
   * 原始数据
   */
  @ApiModelProperty(value = "原始数据", required = false, example = "")
  private String rawData;
  /**
   * 设备ID
   */
  @ApiModelProperty(value = "设备ID", required = false, example = "")
  private Long deviceId;
  /**
   * 传感器数据
   */
  @ApiModelProperty(value = "传感器数据", required = false, example = "")
  private List<SensorsDates> sensorsDates;


}
