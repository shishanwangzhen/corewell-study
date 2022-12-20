package com.corewell.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.corewell.study.component.WebSocketServer;
import com.corewell.study.domain.request.PushDataParam;
import com.corewell.study.domain.request.SensorsDates;
import com.corewell.study.service.PushDataService;
import com.corewell.study.utils.InfluxDbUtils;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
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
    private InfluxDbUtils influxDbUtils;

    @Override
    public void getPushData(PushDataParam pushData) {
        if (pushData==null||pushData.getDeviceId()==null){
            return;
        }
        String data=JSON.toJSONString(pushData);
        System.out.println("getPushData:"+data);
        try {
          webSocketServer.sendMessageAllUser(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<SensorsDates> sensorsDates=pushData.getSensorsDates();
        String deviceId=pushData.getDeviceId().toString();
        if (sensorsDates.size()> 0){
            for (SensorsDates sensorDates : sensorsDates) {
                InfluxDB influxDB = influxDbUtils.getInfluxDB();
    		//CORE_STUDY为表名
            influxDB.write(Point.measurement("CORE_STUDY").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .tag("deviceId",deviceId)
                    .tag("sensorsId", sensorDates.getSensorsId().toString())
                    .addField("isAlarm", sensorDates.getIsAlarm())
                    .tag("sensorsTypeId", sensorDates.getSensorsTypeId().toString())
                    .addField("isLine",sensorDates.getIsLine())
                    .addField("reVal",sensorDates.getReVal())
                    .addField("value",sensorDates.getValue())
                    .build());
            }
        }


    }
}
