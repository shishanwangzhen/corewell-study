package com.corewell.study.domain.request;

import com.corewell.study.domain.response.ResultDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/12/09/11:58
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("ProtocolLabelReq")
public class ProtocolLabelReq{

    /**
     * 协议类型 取值范围 tcp/udp 必选项
     */
    @ApiModelProperty(value = "协议类型 取值范围 tcp/udp 必选项", required = true, example = "tcp")
    private String linktype;
    /**
     * 设备Id
     */
    @ApiModelProperty(value = "设备Id", required = true, example = "")
    private String deviceId;
    /**
     * 当前协议对应的解析标签
     */
    @ApiModelProperty(value = "当前协议对应的解析标签", required = true, example = "[H:#],[D?],[S:,],[D?],[S:,],[D?],[T:#]")
    private String protocolLabel;

}
