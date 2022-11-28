package com.corewell.study.service;

import com.corewell.study.domain.SensorConfig;
import com.corewell.study.domain.request.SensorConfigReq;
import com.corewell.study.domain.result.ResultMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface SensorConfigService {
    /**
     * 查询设备
     *
     * @param sensorConfigReq
     * @return
     */
    ResultMsg findSensorConfig(SensorConfigReq sensorConfigReq);

    /**
     * 新增设备
     *
     * @param sensorConfig
     * @return
     */
    ResultMsg insertSensorConfig(SensorConfig sensorConfig);

    /**
     * 修改设备
     *
     * @param sensorConfig
     * @return
     */
    ResultMsg updateSensorConfig(SensorConfig sensorConfig);

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    ResultMsg updateSensorConfigStatus(@Param("id") Long id);


}
