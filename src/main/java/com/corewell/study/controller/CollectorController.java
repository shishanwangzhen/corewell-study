package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.Collector;
import com.corewell.study.domain.request.CollectorReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.CollectorService;
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
@RequestMapping("/core/Collector")
@Api(tags = "采集器")
public class CollectorController {
    @Resource
    private CollectorService CollectorService;

    @ApiOperation("查询采集器")
    @PostMapping("/findCollector")
    public ResultMsg findCollector(@RequestBody CollectorReq CollectorReq) {
        ResultMsg resultMsg = CollectorService.findCollector(CollectorReq);
        return resultMsg;

    }

    @ApiOperation("采集器修改")
    @PostMapping("/updateCollector")
    public ResultMsg updateCollector(@RequestBody Collector Collector) {
        System.out.println(JSON.toJSON(Collector));
        ResultMsg resultMsg = CollectorService.updateCollector(Collector);
        return resultMsg;

    }

    @ApiOperation("采集器新增")
    @PostMapping("/insertCollector")
    public ResultMsg insertCollector(@RequestBody Collector Collector) {
        System.out.println(JSON.toJSON(Collector));
        ResultMsg resultMsg = CollectorService.insertCollector(Collector);
        return resultMsg;

    }

    @ApiOperation("采集器删除")
    @PostMapping("/updateCollectorStatus")
    public ResultMsg updateCollectorStatus(Long id) {
        ResultMsg resultMsg = CollectorService.updateCollectorStatus(id);
        return resultMsg;

    }

}
