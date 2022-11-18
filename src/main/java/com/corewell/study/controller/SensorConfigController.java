package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.SensorConfig;
import com.corewell.study.domain.request.SensorConfigReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.SensorConfigService;
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
@RequestMapping("/core/sensorConfig")
@Api(tags = "传感器")
public class SensorConfigController {
    @Resource
    private SensorConfigService sensorConfigService;

    @ApiOperation("查询传感器")
    @PostMapping("/findSensorConfig")
    public ResultMsg findSensorConfig(@RequestBody SensorConfigReq sensorConfigReq) {
        ResultMsg resultMsg = sensorConfigService.findSensorConfig(sensorConfigReq);
        return resultMsg;

    }

    @ApiOperation("传感器修改")
    @PostMapping("/updateSensorConfig")
    public ResultMsg updateSensorConfig(@RequestBody SensorConfig sensorConfig) {
        System.out.println(JSON.toJSON(sensorConfig));
        ResultMsg resultMsg = sensorConfigService.updateSensorConfig(sensorConfig);
        return resultMsg;

    }

    @ApiOperation("传感器新增")
    @PostMapping("/insertSensorConfig")
    public ResultMsg insertSensorConfig(@RequestBody SensorConfig sensorConfig) {
        System.out.println(JSON.toJSON(sensorConfig));
        ResultMsg resultMsg = sensorConfigService.insertSensorConfig(sensorConfig);
        return resultMsg;

    }

    @ApiOperation("传感器删除")
    @PostMapping("/updateSensorConfigStatus")
    public ResultMsg updateSensorConfigStatus(Long id) {
        ResultMsg resultMsg = sensorConfigService.updateSensorConfigStatus(id);
        return resultMsg;

    }

}
