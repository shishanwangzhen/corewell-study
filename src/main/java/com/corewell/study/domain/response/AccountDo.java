package com.corewell.study.domain.response;


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
public class AccountDo {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 账号
     */
    private String account;
    /**
     * 账号
     */
    private String name;
    /**
     * 密码
     */
    private String password;

    /**
     * token
     */
    private String token;


}
