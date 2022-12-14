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
     * 查询设备
     *
     * @param decoderReq
     * @return
     */
    List<SensorConfig> findSensorConfig(SensorConfigReq decoderReq);

    /**
     * 新增设备
     *
     * @param sensorConfig
     * @return
     */
    int insertSensorConfig(SensorConfig sensorConfig);

    /**
     * 修改设备
     *
     * @param sensorConfig
     * @return
     */
    int updateSensorConfig(SensorConfig sensorConfig);

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    int updateSensorConfigStatus(@Param("id") Long id);


}
