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
@ApiModel("学生用户查询条件")
@AllArgsConstructor
@NoArgsConstructor
public class StudentReq {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = false, example = "")
    private Long id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "主键id", required = false, example = "")
    private String name;
    /**
     * 学校
     */
    @ApiModelProperty(value = "学校", required = false, example = "")
    private String school;
    /**
     * 专业
     */
    @ApiModelProperty(value = "专业", required = false, example = "")
    private String major;
    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", required = false, example = "")
    private String account;
    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式", required = false, example = "")
    private String phone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", required = false, example = "")
    private String email;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = false, example = "123456")
    private String password;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = false, example = "")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", required = false, example = "")
    private Date updateTime;
    /**
     * 角色
     */
    @ApiModelProperty(value = "角色", required = false, example = "0")
    private String role;
    /**
     * 状态（0.待审核，1.审核通过，2.审核未通过）
     */
    @ApiModelProperty(value = "状态（0.待审核，1.审核通过，2.审核未通过）", required = false, example = "0")
    private String status;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id", required = false, example = "1")
    private Long projectId;
    /**
     * 项目组id
     */
    @ApiModelProperty(value = "项目组id", required = false, example = "1")
    private Long groupId;
    /**
     * 老师id
     */
    @ApiModelProperty(value = "老师id", required = false, example = "1")
    private Long teacherId;

}
