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
@ApiModel("GetSensorFlagReq")
public class GetSensorFlagReq {
    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id", required = true, example = "")
    private Long deviceId;
    /**
     * 协议类型 取值范围 mqtt/tp500/coap
     */
    @ApiModelProperty(value = "设备名称", required = true, example = "mqtt")
    private String linktype;


}
