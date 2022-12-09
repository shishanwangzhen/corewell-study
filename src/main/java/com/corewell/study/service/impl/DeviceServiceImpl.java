package com.corewell.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.corewell.study.dao.DeviceDao;
import com.corewell.study.dao.DeviceNumberDao;
import com.corewell.study.domain.Device;
import com.corewell.study.domain.DeviceNumber;
import com.corewell.study.domain.request.*;
import com.corewell.study.domain.response.*;
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
    private static final String TLINK_SWITCHER_URL = TLINK_URL + "switcherController";
    private static final String TLINK_WRITE_URL = TLINK_URL + "deviceWrite";
    private static final String TLINK_SENDDATAPOINT_URL = TLINK_URL + "sendDataPoint";
    private static final String TLINK_HISTORY_URL = TLINK_URL + "getSensorHistroy";
    private static final String TLINK_GETPARAMS_URL = TLINK_URL + "getParams";
    private static final String TLINK_SETPARAMS_URL = TLINK_URL + "setParams";
    private static final String TLINK_SETMODBUS_URL = TLINK_URL + "setModbus";
    private static final String TLINK_GETMODBUS_URL = TLINK_URL + "getModbus";
    private static final String TLINK_UPDATEMODBUS_URL = TLINK_URL + "updateModbus";
    private static final String TLINK_GETPROTOCOLLABEL_URL = TLINK_URL + "getProtocolLabel";
    private static final String TLINK_SETPROTOCOLLABEL_URL = TLINK_URL + "setProtocolLabel";
    private static final String TLINK_GETFLAG_URL = TLINK_URL + "getFlag";
    private static final String TLINK_SETFLAG_URL = TLINK_URL + "setFlag";


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
        }
    }

    @Override
    public ResultMsg insertDevice(DeviceInsertParam deviceInsertParam) {

        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("deviceNo", deviceInsertParam.getDeviceNo());
            mapParam.put("lat", "22.601376");
            mapParam.put("lng", "113.956591");
            mapParam.put("linkType", deviceInsertParam.getLinkType());
            mapParam.put("timescale", deviceInsertParam.getTimescale());
            mapParam.put("userId", 77632L);
            mapParam.put("deviceName", deviceInsertParam.getDeviceName());
            mapParam.put("sensorList", deviceInsertParam.getSensorList());
            HttpHeaders headers = getHeaders();
            System.out.println("新增设备ru参：：" + JSON.toJSONString(mapParam));
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(TLINK_ADDDEVICE_URL, new HttpEntity<Map>(mapParam, headers), String.class);
            System.out.println("新增设备还参：：" + responseEntity);
            if (!JSON.parseObject(responseEntity.getBody()).containsKey("deviceId")) {
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
                device.setBinding("0");
                device.setLinkType(deviceDTO.getLinktype());
                device.setTimescale(Long.valueOf(deviceDTO.getDefaultTimescale()));
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
        device.setUpdateTime(new Date());
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

    @Override
    public ResultMsg switcherController(DeviceSwitcherParam deviceSwitcherParam) {
        ResponseEntity<String> responseEntity = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceNo", deviceSwitcherParam.getDeviceNo());
            mapParam.put("switcher", deviceSwitcherParam.getSwitcher());
            mapParam.put("sensorId", deviceSwitcherParam.getSensorId());

            System.out.println("设备开关下行控制ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_SWITCHER_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("设备开关下行控制还参：：" + responseEntity.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String flag = jsonObject.get("flag").toString();
        if ("00".equals(flag)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.error();
        }
    }


    @Override
    public ResultMsg deviceWrite(DeviceWriteParam deviceWriteParam) {
        ResponseEntity<String> responseEntity = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceNo", deviceWriteParam.getDeviceNo());
            mapParam.put("value", deviceWriteParam.getValue());
            mapParam.put("sensorId", deviceWriteParam.getSensorId());

            System.out.println("设备数据下行ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_WRITE_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("设备数据下行还参：：" + responseEntity.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String flag = jsonObject.get("flag").toString();
        if ("00".equals(flag)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg sendDataPoint(SendDataPointParam sendDataPointParam) {
        ResponseEntity<String> responseEntity = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceNo", sendDataPointParam.getDeviceNo());
            mapParam.put("addTime", sendDataPointParam.getAddTime());
            mapParam.put("sensorDatas", sendDataPointParam.getSensorDatas());

            System.out.println("传感器数据上报ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_SENDDATAPOINT_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("传感器数据上报还参：：" + responseEntity.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String flag = jsonObject.get("flag").toString();
        if ("00".equals(flag)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg getSensorHistroy(SensorHistoryParam sensorHistoryParam) {
        ResponseEntity<String> responseEntity = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("sensorId", sensorHistoryParam.getSensorId());
            mapParam.put("startDate", sensorHistoryParam.getStartDate());
            mapParam.put("endDate", sensorHistoryParam.getEndDate());
            mapParam.put("pagingState", sensorHistoryParam.getPagingState());
            mapParam.put("pageSize", sensorHistoryParam.getPageSize());

            System.out.println("获取设备传感器历史数据ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_HISTORY_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("设备数据下行还参：：" + responseEntity.toString());
            SensorHistoryDTO sensorHistoryDTO = JSON.parseObject(responseEntity.getBody(), SensorHistoryDTO.class);
            String flag = sensorHistoryDTO.getFlag();
            if ("00".equals(flag)) {
                return ResultMsg.success(sensorHistoryDTO);
            } else {
                return ResultMsg.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg getParams(Long deviceId) {
        ResponseEntity<String> responseEntity = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", deviceId);

            System.out.println("获取设备参数ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_GETPARAMS_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("获取设备参数还参：：" + responseEntity.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String flag = jsonObject.get("flag").toString();
        if ("00".equals(flag) && jsonObject.containsKey("params")) {
            return ResultMsg.success(jsonObject.get("params"));
        } else {
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg setParams(SetParamsReq setParamsReq) {
        ResponseEntity<String> responseEntity = null;
        String flag = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", setParamsReq.getDeviceId());
            mapParam.put("params", setParamsReq.getParams());
            mapParam.put("isWrite", setParamsReq.getIsWrite());

            System.out.println("设置参数ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_SETPARAMS_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("设置参数还参：：" + responseEntity.getBody());
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            flag = jsonObject.get("flag").toString();
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        if ("00".equals(flag)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg setModbus(ModbusReq modbusReq) {
        ResponseEntity<String> responseEntity = null;
        String flag = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", modbusReq.getDeviceId());
            mapParam.put("linktype", modbusReq.getLinktype());
            mapParam.put("modbusList", modbusReq.getModbusList());

            System.out.println("modbus 协议读写指令设置ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_SETMODBUS_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("modbus 协议读写指令设置还参：：" + responseEntity.getBody());
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            flag = jsonObject.get("flag").toString();
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        if ("00".equals(flag)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.error();
        }
    }


    @Override
    public ResultMsg getModbus(ModbusReq modbusReq) {
        ResponseEntity<String> responseEntity = null;
        String flag = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", modbusReq.getDeviceId());
            mapParam.put("linktype", modbusReq.getLinktype());

            System.out.println("获取modbus读写指令ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_GETMODBUS_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("获取modbus读写指令还参：：" + responseEntity.getBody());
            ModbusDTO modbusDTO = JSON.parseObject(responseEntity.getBody(), ModbusDTO.class);
            flag = modbusDTO.getFlag();
            if ("00".equals(flag)) {
                return ResultMsg.success(modbusDTO);
            } else {
                return ResultMsg.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
    }


    @Override
    public ResultMsg updateModbus(ModbusReq modbusReq) {
        ResponseEntity<String> responseEntity = null;
        String flag = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", modbusReq.getDeviceId());
            mapParam.put("linktype", modbusReq.getLinktype());
            mapParam.put("modbusList", modbusReq.getModbusList());

            System.out.println("modbus读写指令修改ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_UPDATEMODBUS_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("modbus读写指令修改还参：：" + responseEntity.getBody());
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            flag = jsonObject.get("flag").toString();
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        if ("00".equals(flag)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg getProtocolLabel(Long deviceId) {
        ResponseEntity<String> responseEntity = null;
        String flag = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", deviceId);

            System.out.println("获取tcp/udp协议标签ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_GETPROTOCOLLABEL_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("获取tcp/udp协议标签还参：：" + responseEntity.getBody());
            ProtocolLabelDTO protocolLabelDTO = JSON.parseObject(responseEntity.getBody(), ProtocolLabelDTO.class);
            flag = protocolLabelDTO.getFlag();
            if ("00".equals(flag)) {
                return ResultMsg.success(protocolLabelDTO);
            } else {
                return ResultMsg.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg setProtocolLabel(ProtocolLabelReq protocolLabelReq) {
        ResponseEntity<String> responseEntity = null;
        String flag = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", protocolLabelReq.getDeviceId());
            mapParam.put("linktype", protocolLabelReq.getLinktype());
            mapParam.put("protocolLabel", protocolLabelReq.getProtocolLabel());

            System.out.println("tcp/udp协议标签设置ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_SETPROTOCOLLABEL_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("tcp/udp协议标签设置还参：：" + responseEntity.getBody());
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            flag = jsonObject.get("flag").toString();
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        if ("00".equals(flag)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg getFlag(GetSensorFlagReq getSensorFlagReq) {
        ResponseEntity<String> responseEntity = null;
        String flag = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", getSensorFlagReq.getDeviceId());
            mapParam.put("linktype", getSensorFlagReq.getLinktype());

            System.out.println("获取mqtt/tp500/coap协议读写标识ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_GETFLAG_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("获取mqtt/tp500/coap协议读写标识还参：：" + responseEntity.getBody());
            GetFlagDTO getFlagDTO = JSON.parseObject(responseEntity.getBody(), GetFlagDTO.class);
            flag = getFlagDTO.getFlag();
            if ("00".equals(flag)) {
                return ResultMsg.success(getFlagDTO);
            } else {
                return ResultMsg.error();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
    }

    @Override
    public ResultMsg setFlag(SetSensorFlagReq setFlagReq) {
        ResponseEntity<String> responseEntity = null;
        String flag = null;
        try {
            Map<String, Object> mapParam = new HashMap<>(16);
            mapParam.put("userId", 77632L);
            mapParam.put("deviceId", setFlagReq.getDeviceId());
            mapParam.put("linktype", setFlagReq.getLinktype());
            mapParam.put("sensorList", setFlagReq.getSensorList());

            System.out.println("设置mqtt/tp500/coap协议读写标识ru参：：" + JSON.toJSONString(mapParam));
            responseEntity = restTemplate.postForEntity(TLINK_SETFLAG_URL, new HttpEntity<Map>(mapParam, getHeaders()), String.class);
            System.out.println("设置mqtt/tp500/coap协议读写标识还参：：" + responseEntity.getBody());
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            flag = jsonObject.get("flag").toString();
        } catch (RestClientException e) {
            e.printStackTrace();
            return ResultMsg.error();
        }
        if ("00".equals(flag)) {
            return ResultMsg.success();
        } else {
            return ResultMsg.error();
        }
    }
}
