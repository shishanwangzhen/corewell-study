package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.Agreement;
import com.corewell.study.domain.Group;
import com.corewell.study.domain.request.AgreementReq;
import com.corewell.study.domain.request.GroupReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.AgreementService;
import com.corewell.study.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/10/31/14:41
 * @Description:
 */
@RestController
@RequestMapping("/core/agreement")
@Api(tags = "协议")
public class AgreementController {
    @Resource
    private AgreementService agreementService;

    @ApiOperation("查询项目")
    @PostMapping("/findAgreement")
    public ResultMsg findAgreement(@RequestBody AgreementReq agreementReq) {
        ResultMsg resultMsg = agreementService.findAgreement(agreementReq);
        return resultMsg;

    }

    @ApiOperation("协议修改")
    @PostMapping("/updateAgreement")
    public ResultMsg updateAgreement(@RequestBody Agreement agreement) {
        System.out.println(JSON.toJSON(agreement));
        ResultMsg resultMsg = agreementService.updateAgreement(agreement);
        return resultMsg;

    }

    @ApiOperation("协议新增")
    @PostMapping("/insertAgreement")
    public ResultMsg insertAgreement(@RequestBody Agreement agreement) {
        System.out.println(JSON.toJSON(agreement));
        ResultMsg resultMsg = agreementService.insertAgreement(agreement);
        return resultMsg;

    }

    @ApiOperation("协议删除")
    @PostMapping("/updateAgreementStatus")
    public ResultMsg updateAgreementStatus(Long id) {
        ResultMsg resultMsg = agreementService.updateAgreementStatus(id);
        return resultMsg;

    }

}
