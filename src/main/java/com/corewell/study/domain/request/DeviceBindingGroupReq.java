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
@ApiModel("项目组绑定设备")
public class DeviceBindingGroupReq {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = true, example = "")
    private Long id;

    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id", required = true, example = "")
    private Long groupId;


}
