package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.Decoder;
import com.corewell.study.domain.request.DecoderReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.DecoderService;
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
@RequestMapping("/core/decoder")
@Api(tags = "编码器")
public class DecoderController {
    @Resource
    private DecoderService decoderService;

    @ApiOperation("查询编码器")
    @PostMapping("/findDecoder")
    public ResultMsg findDecoder(@RequestBody DecoderReq decoderReq) {
        ResultMsg resultMsg = decoderService.findDecoder(decoderReq);
        return resultMsg;

    }

    @ApiOperation("编码器修改")
    @PostMapping("/updateDecoder")
    public ResultMsg updateDecoder(@RequestBody Decoder decoder) {
        System.out.println(JSON.toJSON(decoder));
        ResultMsg resultMsg = decoderService.updateDecoder(decoder);
        return resultMsg;

    }

    @ApiOperation("编码器新增")
    @PostMapping("/insertDecoder")
    public ResultMsg insertDecoder(@RequestBody Decoder decoder) {
        System.out.println(JSON.toJSON(decoder));
        ResultMsg resultMsg = decoderService.insertDecoder(decoder);
        return resultMsg;

    }

    @ApiOperation("编码器删除")
    @PostMapping("/updateDecoderStatus")
    public ResultMsg updateDecoderStatus(Long id) {
        ResultMsg resultMsg = decoderService.updateDecoderStatus(id);
        return resultMsg;

    }

}
