package com.corewell.study.dao;

import com.corewell.study.domain.SensorConfig;
import com.corewell.study.domain.request.SensorConfigReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface SensorConfigDao {
    /**
     * 查询采集器
     *
     * @param decoderReq
     * @return
     */
    List<SensorConfig> findSensorConfig(SensorConfigReq decoderReq);

    /**
     * 新增采集器
     *
     * @param sensorConfig
     * @return
     */
    int insertSensorConfig(SensorConfig sensorConfig);

    /**
     * 修改采集器
     *
     * @param sensorConfig
     * @return
     */
    int updateSensorConfig(SensorConfig sensorConfig);

    /**
     * 删除采集器
     *
     * @param id
     * @return
     */
    int updateSensorConfigStatus(@Param("id") Long id);


}
