package com.corewell.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.corewell.study.dao.DeviceDao;
import com.corewell.study.dao.DeviceNumberDao;
import com.corewell.study.domain.Device;
import com.corewell.study.domain.DeviceNumber;
import com.corewell.study.domain.request.DeviceBindingReq;
import com.corewell.study.domain.request.DeviceInsertParam;
import com.corewell.study.domain.request.DeviceReq;
import com.corewell.study.domain.request.DeviceUpdateParam;
import com.corewell.study.domain.response.DeviceDTO;
import com.corewell.study.domain.response.DeviceDo;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.service.DeviceService;
import com.corewell.study.timing.GetAccessToken;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/17/13:31
 * @Description:
 */
@Service("DeviceService")
public class DeviceServiceImpl implements DeviceService {
    private static final String TLINK_URL = "https://app.dtuip.com/api/device/";
    private static final String TLINK_ADDDEVICE_URL = TLINK_URL + "addDevice";
    private static final String TLINK_UPDATEDEVICE_URL = TLINK_URL + "updateDevice";
    private static final String TLINK_DELETEDEVICE_URL = TLINK_URL + "deleteDevice";
    private static final String TLINK_GETSINGLEDEVICEDATAS_URL = TLINK_URL + "getSingleDeviceDatas";
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private GetAccessToken getAccessToken;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeviceNumberDao deviceNumberDao;

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer" + " " + getAccessToken.getAccessToken());
        headers.add("Content-Type", "application/json");
        headers.add("tlinkAppId", "621d35860cce451a886b9329affb52c6");
        return headers;
    }

    @Override
    public ResultMsg findDevice(DeviceReq deviceReq) {
        List<DeviceDo> DeviceDOList = deviceDao.findDevice(deviceReq);
        return ResultMsg.success(DeviceDOList);
    }

    @Override
    public ResultMsg findDeviceByDeviceId(Long deviceId) {
        Response response = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);

            mapParam.put("userId", 77632);
            mapParam.put("deviceId", deviceId);

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(TLINK_GETSINGLEDEVICEDATAS_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("deviceNo查询设备还参：：" + responseEntity.getBody());
            JSONObject jsonObject = JSON.parseObject(responseEntity.getBody());
            String flag = jsonObject.get("flag").toString();
            if ("00".equals(flag)) {
                DeviceDTO deviceDTO = JSON.parseObject(jsonObject.get("device").toString(), DeviceDTO.class);
                System.out.println("deviceDTO::::::" + JSON.toJSONString(deviceDTO));
                return ResultMsg.success(deviceDTO);
            } else {
                return ResultMsg.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error();
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    @Override
    public ResultMsg insertDevice(DeviceInsertParam deviceInsertParam) {

        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632);
            mapParam.put("deviceNo", deviceInsertParam.getDeviceNo());

            HttpHeaders headers = getHeaders();
            System.out.println("新增设备ru参：：" + JSON.toJSONString(mapParam));
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(TLINK_ADDDEVICE_URL, new HttpEntity<Map>(mapParam, headers), String.class);
            System.out.println("新增设备还参：：" + responseEntity.getBody());
            if (!"00".equals(JSON.parseObject(responseEntity.getBody()).get("flag").toString())) {
                return ResultMsg.error();
            }
            ResponseEntity<String> responseEntity1 = restTemplate.postForEntity(TLINK_GETSINGLEDEVICEDATAS_URL, new HttpEntity<Map>(mapParam, headers), String.class);
            System.out.println("deviceNo查询设备还参：：" + responseEntity1.getBody());
            JSONObject jsonObject = JSON.parseObject(responseEntity1.getBody());
            String flag = jsonObject.get("flag").toString();
            if ("00".equals(flag)) {
                DeviceDTO deviceDTO = JSON.parseObject(jsonObject.get("device").toString(), DeviceDTO.class);
                System.out.println("deviceDTO::::::" + JSON.toJSONString(deviceDTO));
                String deviceNo = deviceDTO.getDeviceNo();
                Device device = new Device();
                device.setDeviceId(deviceDTO.getId());
                device.setDeviceName(deviceInsertParam.getDeviceName());
                device.setDeviceNo(deviceNo);
                device.setIsDelete(0L);
                device.setBinding("0");
                device.setType(deviceInsertParam.getType());
                device.setCreatorId(deviceInsertParam.getCreatorId());
                device.setCreateTime(new Date());
                deviceDao.insertDevice(device);
                DeviceNumber deviceNumber = new DeviceNumber();
                deviceNumber.setDeviceNo(deviceNo);
                deviceNumber.setDeviceId(deviceDTO.getId());
                deviceNumberDao.updateDeviceNumberBind(deviceNumber);
            } else {
                return ResultMsg.error();
            }

        } catch (RestClientException e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return ResultMsg.error();
        }
        return ResultMsg.success();
    }

    @Override
    public ResultMsg updateDevice(DeviceUpdateParam deviceUpdateParam) {

        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("lat", "22.601376");
            mapParam.put("lng", "113.956591");
            mapParam.put("userId", 77632L);
            mapParam.put("sensorList", deviceUpdateParam.getSensorList());
            mapParam.put("deviceName", deviceUpdateParam.getDeviceName());
            mapParam.put("timescale", deviceUpdateParam.getTimescale());
            mapParam.put("linkType", deviceUpdateParam.getLinkType());
            mapParam.put("deviceId", deviceUpdateParam.getDeviceId());
            mapParam.put("delSensorIds", deviceUpdateParam.getDelSensorIds());
            System.out.println("修改设备ru参：：" + JSON.toJSONString(mapParam));
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(TLINK_UPDATEDEVICE_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("修改设备还参：：" + responseEntity.getBody());
            if (!"00".equals(JSON.parseObject(responseEntity.getBody()).get("flag").toString())) {
                return ResultMsg.error();
            }

        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        Device device = new Device();
        device.setDeviceId(deviceUpdateParam.getDeviceId());
        if (StringUtils.isNotBlank(deviceUpdateParam.getLinkType())) {
            device.setLinkType(deviceUpdateParam.getLinkType());
        }
        if (deviceUpdateParam.getTimescale() != null) {
            device.setTimescale(deviceUpdateParam.getTimescale());
        }
        if (StringUtils.isNotBlank(deviceUpdateParam.getDeviceName())) {
            device.setDeviceName(deviceUpdateParam.getDeviceName());
        }
        deviceDao.updateDevice(device);
        return ResultMsg.success();
    }

    @Override
    public ResultMsg deleteDevice(Long deviceId) {
        ResponseEntity<String> responseEntity = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", deviceId);
            System.out.println("删除设备ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_DELETEDEVICE_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("删除设备还参：：" + responseEntity.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String flag = jsonObject.get("flag").toString();
        if ("00".equals(flag)) {
            deviceDao.deleteDevice(deviceId);
            DeviceNumber deviceNumber = new DeviceNumber();
            deviceNumber.setDeviceId(deviceId);
            deviceNumber.setStatus(0);
            deviceNumberDao.updateDeviceNumber(deviceId);
        } else {
            return ResultMsg.error();
        }
        return ResultMsg.success();
    }

    @Override
    public ResultMsg updateDeviceBinding(DeviceBindingReq deviceBindingReq) {
        int result = deviceDao.updateDeviceBinding(deviceBindingReq);
        System.out.println("绑定结果：：：" + result);
        if (result > 0) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateDeviceBindingById(Long id) {
        int result = deviceDao.updateDeviceBindingById(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }
}
