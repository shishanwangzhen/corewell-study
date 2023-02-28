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
@ApiModel("modbus协议读写指令查询入参")
public class ModbusGetReq {
    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id", required = true, example = "")
    private Long deviceId;
    /**
     * 协议类型 取值范围 modbus,mdtcp 必选参数
     */
    @ApiModelProperty(value = "协议类型 取值范围 modbus,mdtcp 必选参数", required = true, example = "modbus")
    private String linktype;

}
