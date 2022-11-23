package com.corewell.study.service.impl;

import com.corewell.study.dao.SensorConfigDao;
import com.corewell.study.domain.SensorConfig;
import com.corewell.study.domain.request.SensorConfigReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.SensorConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/17/13:31
 * @Description:
 */
@Service("SensorConfigService")
public class SensorConfigServiceImpl implements SensorConfigService {

    @Autowired
    private SensorConfigDao sensorConfigDao;

    @Override
    public ResultMsg findSensorConfig(SensorConfigReq sensorConfigReq) {
        List<SensorConfig> sensorConfigList = sensorConfigDao.findSensorConfig(sensorConfigReq);
        return ResultMsg.success(sensorConfigList);
    }

    @Override
    public ResultMsg insertSensorConfig(SensorConfig sensorConfig) {
        sensorConfig.setCreateTime(new Date());
        sensorConfig.setDeleteFlag("1");
        int result = sensorConfigDao.insertSensorConfig(sensorConfig);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateSensorConfig(SensorConfig sensorConfig) {
        sensorConfig.setUpdateTime(new Date());

        int result = sensorConfigDao.updateSensorConfig(sensorConfig);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.UPDATE_FAILED);
    }

    @Override
    public ResultMsg updateSensorConfigStatus(Long id) {
        int result = sensorConfigDao.updateSensorConfigStatus(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.DELETE_FAILED);
    }
}
