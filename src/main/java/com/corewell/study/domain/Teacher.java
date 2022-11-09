package com.corewell.study.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@ApiModel("教师")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = true, example = "")
    private Long id;
    /**
     * 账号
     */
    @ApiModelProperty(value = "账号", required = true, example = "")
    private String account;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "")
    private String password;
    /**
     * 名字
     */
    @ApiModelProperty(value = "名字", required = true, example = "")
    private String name;

}
