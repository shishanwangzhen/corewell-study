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
@ApiModel("用户登录")
@AllArgsConstructor
@NoArgsConstructor
public class AccountReq {
    /**
     * 账号
     */
    @ApiModelProperty(value = "学号", required = true, example = "admin")
    private String account;
    /**
     * 账号
     */
    @ApiModelProperty(value = "学号", required = true, example = "123456")
    private String password;

}
