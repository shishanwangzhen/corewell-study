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
@ApiModel("学生用户")
@AllArgsConstructor
@NoArgsConstructor
public class StudentStudentReq {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", required = true, example = "")
    private Long id;

    /**
     * 状态（0.待审核，1.审核通过，2.审核未通过）
     */
    @ApiModelProperty(value = "状态（0.待审核，1.审核通过，2.审核未通过）", required = true, example = "0")
    private String status;

}
