package com.corewell.study.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.corewell.study.domain.request.PushDataParam;
import com.corewell.study.domain.request.SensorsDates;
import com.corewell.study.utils.InfluxDbUtils;
import org.apache.commons.lang3.StringUtils;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/12/20/17:15
 * @Description:
 */
@Component
@RabbitListener(queues = "core-study-queue")  //指定队列
public class RabbitReceiver {
    @Autowired
    private InfluxDbUtils influxDbUtils;

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver  : 消费成功：" + msg);
        PushDataParam pushData = JSON.parseObject(msg, PushDataParam.class);
        List<SensorsDates> sensorsDates = pushData.getSensorsDates();
        String deviceId = pushData.getDeviceId().toString();
        if (sensorsDates.size() > 0) {
            for (SensorsDates sensorDates : sensorsDates) {
                System.out.println("sensorDates:  :" + sensorDates);
                InfluxDB influxDB = influxDbUtils.getInfluxDB();
                //CORE_STUDY为表名
                if (sensorDates.getSensorsTypeId()==1){
                    influxDB.write("test", "", Point.measurement("CORE_STUDY")
                            .time(System.currentTimeMillis()+8*60*60*1000, TimeUnit.MILLISECONDS)
                            .tag("deviceId", deviceId)
                            .tag("sensorsId", sensorDates.getSensorsId().toString())
                            .addField("isAlarm", sensorDates.getIsAlarm())
                            .tag("sensorsTypeId", sensorDates.getSensorsTypeId().toString())
                            .addField("isLine", sensorDates.getIsLine())
                            .addField("reVal", sensorDates.getReVal())
                            .addField("value", sensorDates.getValue())
                            .build());
                }else if (sensorDates.getSensorsTypeId()==2){
                    influxDB.write("test", "", Point.measurement("CORE_STUDY")
                            .time(System.currentTimeMillis()+8*60*60*1000, TimeUnit.MILLISECONDS)
                            .tag("deviceId", deviceId)
                            .tag("sensorsId", sensorDates.getSensorsId().toString())
                            .addField("isAlarm", sensorDates.getIsAlarm())
                            .tag("sensorsTypeId", sensorDates.getSensorsTypeId().toString())
                            .addField("switcher", sensorDates.getSwitcher())
                            .addField("isHeartbeat", sensorDates.getIsHeartbeat())
                            .build());
                }

            }
        }
    }
}