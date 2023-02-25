package com.corewell.study.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.corewell.study.annotation.AddLog;
import com.corewell.study.config.UserRequest;
import com.corewell.study.domain.Log;
import com.corewell.study.domain.response.AccountDo;
import com.corewell.study.service.LogService;
import com.corewell.study.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2023/02/25/11:29
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class AddLogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.corewell.study.annotation.AddLog)")
    public void addLogCut() {

    }

    @Before(value = "addLogCut()")
    public Object before(JoinPoint point) {
        log.info("====================AddLogAspect before come in start====================");
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        AddLog addLog = method.getAnnotation(AddLog.class);
        Object interfaceType = AnnotationResolver.newInstance().resolver(point, addLog.interfaceType());
        Object interfaceName = AnnotationResolver.newInstance().resolver(point, addLog.interfaceName());
        Object interfaceInfo = AnnotationResolver.newInstance().resolver(point, addLog.interfaceInfo());
        Object deviceId = AnnotationResolver.newInstance().resolver(point, addLog.dataId());

        System.out.println("h航少看点火开关00000" + JSON.toJSONString(interfaceInfo) + "索拉卡复合弓：" + JSON.toJSONString(interfaceName) + "索拉卡复合弓：" + JSON.toJSONString(interfaceType));
        String token = UserRequest.getCurrentToken();
        String account = JwtUtil.getUserId(token);
        Map<String, Object> map = JwtUtil.getInfo(token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(map);
        AccountDo accountDo = jsonObject.toJavaObject(AccountDo.class);
        System.out.println("h航少看点火开关222222" + JSON.toJSONString(token) + "名称，修改后" + JSON.toJSONString(accountDo) + "索拉卡复合弓：" + JSON.toJSONString(account));
        Log log = new Log();
        log.setAccount(account);
        log.setAccountId(Long.valueOf(map.get("id").toString()));
        log.setCreateTime(new Date());
        log.setInterfaceType(Long.valueOf(interfaceType.toString()));
        log.setInterfaceName(interfaceName.toString());
        log.setInterfaceInfo(interfaceInfo.toString());
        log.setDeviceId(Long.valueOf(deviceId.toString()));
        logService.insertLog(log);
        return null;
    }
}
