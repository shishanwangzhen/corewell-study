package com.corewell.study.domain.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
@ApiModel("学生信息")
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable {

    /**
     * 角色
     */
    @ApiModelProperty(value = "角色", required = false, example = "")
    private String role;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称", required = false, example = "")
    private String projectName;

}
