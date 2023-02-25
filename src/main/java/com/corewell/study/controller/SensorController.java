package com.corewell.study.controller;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.Sensor;
import com.corewell.study.domain.request.SensorReq;
import com.corewell.study.domain.request.SensorUpdateReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.SensorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/10/31/14:41
 * @Description:
 */
@RestController
@RequestMapping("/core/sensor")
@Api(tags = "传感器")
public class SensorController {
    @Resource
    private SensorService SensorService;

    @ApiOperation("查询传感器")
    @PostMapping("/findSensor")
    public ResultMsg findSensor(@RequestBody SensorReq sensorReq) {
        ResultMsg resultMsg = SensorService.findSensor(sensorReq);
        return resultMsg;

    }

    @ApiOperation("传感器设置量程")
    @PostMapping("/updateSensorRange")
    public ResultMsg updateSensorRange(@RequestBody SensorUpdateReq sensorUpdateReq) {
        System.out.println(JSON.toJSON(sensorUpdateReq));
        ResultMsg resultMsg = SensorService.updateSensorRange(sensorUpdateReq);
        return resultMsg;

    }

/*    @ApiOperation("传感器修改")
    @PostMapping("/updateSensor")
    @ApiIgnore
    public ResultMsg updateSensor(@RequestBody Sensor sensor) {
        System.out.println(JSON.toJSON(sensor));
        ResultMsg resultMsg = SensorService.updateSensor(sensor);
        return resultMsg;

    }

    @ApiOperation("传感器新增")
    @PostMapping("/insertSensor")
    @ApiIgnore
    public ResultMsg insertSensor(@RequestBody Sensor sensor) {
        System.out.println(JSON.toJSON(sensor));
        ResultMsg resultMsg = SensorService.insertSensor(sensor);
        return resultMsg;

    }

    @ApiOperation("传感器删除")
    @PostMapping("/updateSensorStatus")
    @ApiIgnore
    public ResultMsg updateSensorStatus(Long id) {
        ResultMsg resultMsg = SensorService.updateSensorStatus(id);
        return resultMsg;

    }*/

}
