package com.corewell.study.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
@ApiModel("学生账号注册申请信息")
@AllArgsConstructor
@NoArgsConstructor
public class Approve {

    private long id;
    private String name;
    private String school;
    private String major;
    private String account;
    private String password;
    private String phone;
    private String email;
    private String status;
    private Date createTime;
    private Date updateTime;

}
