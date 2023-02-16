package com.corewell.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.corewell.study.component.WebSocketServer;
import com.corewell.study.constants.BaseRedisKeyConstants;
import com.corewell.study.dao.SensorDao;
import com.corewell.study.domain.Sensor;
import com.corewell.study.domain.request.PushDataParam;
import com.corewell.study.domain.request.SensorsDates;
import com.corewell.study.service.PushDataService;
import com.corewell.study.utils.InfluxDbUtils;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 863586395
 */
@Service("PushDataService")
public class PushDataServiceImpl implements PushDataService {

    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SensorDao sensorDao;

    @Autowired
    private InfluxDbUtils influxDbUtils;


    @Override
    public void getPushData(PushDataParam pushData) {
        if (pushData == null || pushData.getDeviceId() == null) {
            return;
        }
        Long deviceId = pushData.getDeviceId();
        if (stringRedisTemplate.hasKey(BaseRedisKeyConstants.DEVICE_KEY + deviceId)) {
            pushData.setType("1");
            List<SensorsDates> sensorsDatesList = pushData.getSensorsDates();
            Sensor sensor;
            Long sensorId;
            for (SensorsDates sensorsDates : sensorsDatesList) {
                sensorId = sensorsDates.getSensorsId();
                if (stringRedisTemplate.hasKey(BaseRedisKeyConstants.SENSOR_KEY + deviceId + ":" + sensorId)) {
                    String sensorStr = stringRedisTemplate.opsForValue().get(BaseRedisKeyConstants.SENSOR_KEY + deviceId + ":" + sensorId);
                    sensor = JSONObject.parseObject(sensorStr, Sensor.class);
                } else {
                    sensor = sensorDao.findSensorBySensorId(sensorId);
                    stringRedisTemplate.opsForValue().set(BaseRedisKeyConstants.SENSOR_KEY +deviceId+":"+ sensorId, JSON.toJSONString(sensor), 24 * 60 * 60 * 1000, TimeUnit.MILLISECONDS);
                }
                Double reVal = Double.valueOf(sensorsDates.getReVal());
                sensorsDates.setIsAbnormal(0L);
                if (sensor.getMinimum().compareTo(reVal)>0 || sensor.getMaximum().compareTo(reVal)<0) {
                    sensorsDates.setIsAbnormal(1L);
                    StringBuilder command = new StringBuilder();
                    command.append("SELECT reVal FROM CORE_STUDY where sensorsId=");
                    command.append("'");
                    command.append(sensorsDates.getSensorsId());
                    command.append("'");
                    command.append(" order by time desc limit 3");
                    QueryResult resultMsg =influxDbUtils.getInfluxDB().query(new Query(command.toString(), "test"));
                    System.out.println("查询历史数据还参：resultMsg" + JSONObject.toJSON(resultMsg));
                    if (resultMsg!=null&&resultMsg.getResults()!=null&&resultMsg.getResults().get(0)!=null&&resultMsg.getResults().get(0).getSeries().get(0).getValues()!=null){
                        List<List<Object>> strings= resultMsg.getResults().get(0).getSeries().get(0).getValues();
                        Double avg=0D;
                        for (List<Object> objectList:strings){
                            avg=avg+ Double.valueOf(objectList.get(1).toString());
                        }
                        avg=avg/3;
                        sensorsDates.setReVal(avg.toString());
                    }
                }
            }
        }
        String data = JSON.toJSONString(pushData);
        System.out.println("getPushData:" + data);
        try {
            webSocketServer.sendMessageAllUser(data);
            rabbitTemplate.convertAndSend("core-study-queue", data);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
