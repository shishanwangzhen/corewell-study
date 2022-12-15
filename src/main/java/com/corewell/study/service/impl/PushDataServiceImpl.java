package com.corewell.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.corewell.study.component.WebSocketServer;
import com.corewell.study.domain.request.PushDataParam;
import com.corewell.study.service.PushDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 863586395
 */
@Service("PushDataService")
public class PushDataServiceImpl implements PushDataService {

    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public void getPushData(PushDataParam pushData) {
        String data=JSON.toJSONString(pushData);
        System.out.println("getPushData:"+data);
        try {
          webSocketServer.sendMessageAllUser(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
      /*  List<SensorsDates> sensorsDates=pushData.getSensorsDates();
        if (sensorsDates.size()> 0){
            for (SensorsDates sensorDates : sensorsDates) {


            }
        }*/


    }
}
