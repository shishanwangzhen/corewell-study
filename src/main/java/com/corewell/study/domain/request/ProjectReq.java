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
@ApiModel("项目")
public class ProjectReq {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = true, example = "")
    private Long id;
    /**
     * 项目编号
     */
    @ApiModelProperty(value = "项目编号", required = true, example = "")
    private String number;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称", required = true, example = "")
    private String name;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id", required = true, example = "")
    private Long creatorId;
    /**
     * 项目描述
     */
    @ApiModelProperty(value = "项目描述", required = true, example = "")
    private String info;
    /**
     * 状态（0.删除，1.正常）
     */
    @ApiModelProperty(value = "状态（0.删除，1.正常）", required = true, example = "")
    private String status;

}
