package com.corewell.study.timing;

import com.alibaba.fastjson.JSONObject;
import com.corewell.study.constants.BaseRedisKeyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/08/14:28
 * @Description: 将tlink传感器数据同步到省农业平台
 */
@Component
public class GetAccessToken {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final String LOGIN_URL = "https://app.dtuip.com/oauth/token?grant_type=password&username=bydwadmin&password=bydwadmin123";
    String accessToken = null;
    HttpHeaders headers = new HttpHeaders();


    /**
     * 常用表达式例子
     * (1)0/2 * * * * ? 表示每2秒执行任务
     * (1)0 0/2 * * * ? 表示每2分钟 执行任务
     * (1)0 0 2 1 * ?表示在每月的1日的凌晨2点调整任务
     * (2)0 15 10 ? * MON-FRI 表示周一到周五每天上午10:15执行作业
     * (3) 0 15 10 ? 6L 2002-2006 表示2002-2006年的每个月的最后一个星期五上午10:15执行作
     * (4)0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
     * (5) 0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
     * (6)0 0 12 ? * WED 表示每个星期三中午12点
     * (7)0 0 12 * * ? 每天中午12点触发
     * (8)0 15 10 ? * * 每天上午10:15触发
     * (9)0 15 10 * * ? 每天上午10:15触发
     * (10)0 15 10 * * ? 每天上午10:15触发
     * (11) 0 15 10 * * ? 2005 2005年的每天上午10:15触发
     * (12)0 * 14 * * ? 在每天下午2点到下午2:59期间的每1分钟触发(13)00/514**? 在每天下午2点到下午2:55期间的每5分钟触发
     * (14)0 0/5 14,18 * * ? 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
     * (15)0 0-5 14 * * ? 在每天下午2点到下午2:05期间的每1分钟触发
     */


    @Scheduled(cron = "0 0 2,8,16 * * ?")
    public void getAccessToken() {
        System.out.println("————————————$$$$$$$$$$$" + new Date() + "定时任务getAccessToken开始————————————————————");
        try {
            headers.clear();
            headers.add("authorization", "Basic NGI4NDIwZDRkYzk3NGZkNDgyODUwODZkMDkwMjJmOWI6YzliM2RjYjBkNjcxNDE0YTg2Mjg2ZmQyZDNmMGM2N2I=");
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(LOGIN_URL, new HttpEntity<Map>(null, headers), String.class);
            System.out.println(responseEntity.getBody());
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            accessToken = jsonObject.get("access_token").toString();
            stringRedisTemplate.opsForValue().set(BaseRedisKeyConstants.redis_key_pre + "access_token", accessToken);
            System.out.println("获取tlink的access_token值为：" + stringRedisTemplate.opsForValue().get("access_token"));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}






