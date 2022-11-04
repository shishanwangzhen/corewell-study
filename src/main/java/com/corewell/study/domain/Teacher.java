package com.corewell.study.domain;


import io.swagger.annotations.ApiModel;
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

    private Long id;
    private String account;
    private String password;

}
