package com.corewell.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.corewell.study.component.WebSocketServer;
import com.corewell.study.domain.request.PushDataParam;
import com.corewell.study.domain.request.SensorsDates;
import com.corewell.study.service.PushDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 863586395
 */
@Service("PushDataService")
public class PushDataServiceImpl implements PushDataService {

    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public void getPushData(PushDataParam pushData) {
        System.out.println("getPushData:"+JSON.toJSONString(pushData));
        try {
            webSocketServer.sendMessage(JSON.toJSONString(pushData));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<SensorsDates> sensorsDates=pushData.getSensorsDates();
        if (sensorsDates.size()> 0){
            for (SensorsDates sensorDates : sensorsDates) {


            }
        }


    }
}
