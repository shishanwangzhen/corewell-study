package com.corewell.study.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2023/03/17/15:03
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("一键主键id集合")
public class IdsParam {

    /**
     * 一键主键id集合
     */
    @ApiModelProperty(value = "一键主键id集合", required = true, example = "")
   private List<String> stringList;
}
