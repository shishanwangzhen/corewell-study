package com.corewell.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.corewell.study.component.WebSocketServer;
import com.corewell.study.domain.request.PushDataParam;
import com.corewell.study.service.PushDataService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 863586395
 */
@Service("PushDataService")
public class PushDataServiceImpl implements PushDataService {

    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @Override
    public void getPushData(PushDataParam pushData) {
        if (pushData == null || pushData.getDeviceId() == null) {
            return;
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
