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
@ApiModel("传感器配置")
public class SensorConfig {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = false, example = "")
    private Long id;
    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称", required = false, example = "")
    private String chineseName;
    /**
     * 英文名称
     */
    @ApiModelProperty(value = "英文名称", required = false, example = "")
    private String englishName;
    /**
     * 传感器节点
     */
    @ApiModelProperty(value = "传感器节点", required = false, example = "")
    private String systemName;
    /**
     * 单位
     */
    @ApiModelProperty(value = "单位", required = false, example = "")
    private String unity;
    /**
     * 解码器编号
     */
    @ApiModelProperty(value = "解码器编号", required = false, example = "")
    private String number;
    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id", required = false, example = "")
    private Long creatorId;
    /**
     * 采集器id
     */
    @ApiModelProperty(value = "采集器id", required = false, example = "")
    private Long CollectorId;
    /**
     * 状态（0.删除，1.正常）
     */
    @ApiModelProperty(value = "状态（0.删除，1.正常）", required = false, example = "")
    private String deleteFlag;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = false, example = "")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", required = false, example = "")
    private Date updateTime;
}
