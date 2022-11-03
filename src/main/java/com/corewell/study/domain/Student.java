package com.corewell.study.domain;


import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class Student {

    private Long id;
    private String name;
    private String school;
    private String major;
    private String account;
    private String phone;
    private String email;
    private String password;
    private Date createTime;
    private Date updateTime;
    private String role;
    private String status;
    private Long projectId;
    private Long groupId;

}
