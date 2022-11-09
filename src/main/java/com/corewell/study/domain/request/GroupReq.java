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
@ApiModel("项目组")
public class GroupReq {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = true, example = "")
    private Long id;
    /**
     * 项目组编号
     */
    @ApiModelProperty(value = "项目组编号", required = true, example = "")
    private String number;
    /**
     * 项目组名称
     */
    @ApiModelProperty(value = "项目组名称", required = true, example = "")
    private String name;
    /**
     * 项目组描述
     */
    @ApiModelProperty(value = "项目组描述", required = true, example = "")
    private String info;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id", required = true, example = "")
    private String creatorId;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id", required = true, example = "")
    private Long projectId;
    /**
     * 状态（0.删除，1.正常）
     */
    @ApiModelProperty(value = "状态（0.删除，1.正常）", required = true, example = "")
    private String status;

}
