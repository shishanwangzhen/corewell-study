/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80031
Source Host           : localhost:3306
Source Database       : core_farming

Target Server Type    : MYSQL
Target Server Version : 80031
File Encoding         : 65001

Date: 2023-01-30 09:42:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agreement
-- ----------------------------
DROP TABLE IF EXISTS `agreement`;
CREATE TABLE `agreement` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '协议名称',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '协议编号',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '协议类型',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.删除，1.正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='协议';

-- ----------------------------
-- Records of agreement
-- ----------------------------
INSERT INTO `agreement` VALUES ('1', 'TCP', '1', 'TCP', 'TCP', '2022-11-16 11:21:39', null, '1', '1');
INSERT INTO `agreement` VALUES ('2', 'HTTP', '2', 'HTTP', 'HTTP', '2022-11-26 11:22:15', null, '1', '1');

-- ----------------------------
-- Table structure for decoder
-- ----------------------------
DROP TABLE IF EXISTS `decoder`;
CREATE TABLE `decoder` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器名称',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '解码器编号',
  `model` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器型号',
  `manufacturer` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '厂商',
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）',
  `agreement` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '协议类型',
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器路径',
  `port` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器端口',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.删除，1.正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_key` (`number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='解码器';

-- ----------------------------
-- Records of decoder
-- ----------------------------
INSERT INTO `decoder` VALUES ('1', '56', '002', 'HAHF', 'B', '1', 'CoAP', '1', '1', '5555', '2022-11-25 11:46:32', '2022-12-02 13:58:46', '1', '0');
INSERT INTO `decoder` VALUES ('2', '2', '2', '2', null, '1', '1', '2', '2', '2', '2022-11-25 11:46:58', '2022-12-01 14:56:06', '1', '0');
INSERT INTO `decoder` VALUES ('3', '数据解码器', '001', 'A048', '厂商A', '1', 'MQTT', '哈哈哈', '8080', null, '2022-12-01 13:52:28', null, null, '1');
INSERT INTO `decoder` VALUES ('4', '水肥机解码器', '15', '5', '5', '1', 'HTTP', '5', '5', '5555', '2022-12-01 14:05:43', '2022-12-02 14:45:11', '1', '0');
INSERT INTO `decoder` VALUES ('7', '水肥机', '2005', 'c527', '厂家A ', '2', 'https', '127.0.0.1', '8080', ' 协议：https 修改控制器解码器配置 协议：https 修改控制器解码器配置 协议：https 修改控制器解码器配置 协议：https 修改控制器解码器配置 协议：https 修改控制器解码器配置 协议：https 修改控制器解码器配置 协议：https 修改控制器解码器配置 协议：https 修改控制器解码器配置', '2022-12-02 13:07:23', '2022-12-02 13:11:50', '1', '1');
INSERT INTO `decoder` VALUES ('8', '二氧化碳采集器解码器', '16', 'AE006', '厂家A', '1', 'http', '555555', '5050', '你好', '2022-12-02 13:50:04', null, '1', '1');

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `device_id` int DEFAULT NULL COMMENT '设备id',
  `device_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备名称',
  `deviceNo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备序列号',
  `link_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '协议类型 tcp,modbus,mdtcp,udp,mqtt,tp500coap,http,nbiot 注意区分大小写',
  `timescale` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '掉线延时',
  `ioc_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备图标',
  `is_delete` int DEFAULT '0' COMMENT '是否删除 0 否 1 是 2禁用',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）',
  `binding` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT '绑定状态（0.未绑定项目，1.已绑定项目）',
  `binding_id` int DEFAULT NULL COMMENT '项目负责人id',
  `project_id` int DEFAULT NULL COMMENT '项目id',
  `group_id` int DEFAULT NULL COMMENT '项目组id',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `video_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '视频地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='采集设备';

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('60', '187894', '句容葡萄园采集2号设备', 'JSNL202212060000', 'tcp', '5000', null, '0', '1', '1', '1', '87', '0', '1', '2022-12-08 09:34:13', '2023-01-18 13:53:04', null);
INSERT INTO `device` VALUES ('64', '188035', '饲料车间1号控制器', 'JSNL202212060007', 'modbus', '6000', null, '0', '2', '0', '0', '0', '0', '1', '2022-12-08 13:41:01', '2023-01-18 15:21:44', null);
INSERT INTO `device` VALUES ('65', '188039', '句容草莓棚采集器', 'JSNL202212060004', 'modbus', '500', null, '0', '1', '1', '1', '88', '0', '1', '2022-12-08 13:46:09', '2023-01-10 13:28:22', null);
INSERT INTO `device` VALUES ('66', '188043', '5号鸡舍喂集1号控制器', 'JSNL202212060005', 'HTTP', '500', null, '0', '2', '1', '1', '87', '0', '1', '2022-12-08 13:53:27', '2023-01-16 11:54:08', null);
INSERT INTO `device` VALUES ('67', '188045', '5号鸡舍风机北控制器', 'JSNL202212060006', 'modbus', '6000', null, '0', '2', '1', '1', '88', '0', '1', '2022-12-08 13:54:48', '2023-01-05 17:35:41', null);
INSERT INTO `device` VALUES ('68', '188051', '4号鸡舍喂集2号控制器', 'JSNL202212060008', 'HTTP', '6000', null, '0', '2', '1', '2', '74', '0', '1', '2022-12-08 14:04:33', '2022-12-14 09:26:55', null);
INSERT INTO `device` VALUES ('71', '188817', '丰瑞源大棚二号采集器', 'JSNL202212080007', 'tcp', '4000', null, '0', '1', '1', '1', '87', '0', '1', '2022-12-13 10:04:46', '2023-01-17 14:48:35', null);
INSERT INTO `device` VALUES ('73', '190262', '水肥一体化一号控制器', 'JSNL202212080004', 'modbus', '5000', null, '0', '2', '1', '1', '87', '0', '1', '2022-12-26 09:36:32', '2023-01-18 13:53:09', null);
INSERT INTO `device` VALUES ('81', '190739', '测试采集器', 'JSNL202212060003', 'mqtt', '3000', null, '0', '1', '1', '1', '87', '40', '1', '2022-12-29 09:31:17', '2023-01-17 14:00:24', null);
INSERT INTO `device` VALUES ('84', '190857', '水肥一体化3号控制器', 'JSNL202212080003', 'tcp', '5000', null, '0', '2', '1', '1', '87', '33', '1', '2022-12-29 14:58:49', '2023-01-17 13:47:41', null);
INSERT INTO `device` VALUES ('88', '191506', '测试台ZigBee采集器', 'KWCAHJCJCO221201', 'tcp', '180', null, '0', '1', '1', '1', '87', '33', '1', '2023-01-03 09:32:46', '2023-01-18 14:34:32', null);
INSERT INTO `device` VALUES ('89', '192053', '测试台控制设备01', 'KWCASXTHMI202201', 'modbus', '180', null, '0', '2', '1', '1', '87', '33', '1', '2023-01-05 09:56:40', '2023-01-18 14:35:09', null);
INSERT INTO `device` VALUES ('90', '192464', '摄像头1', 'JSNL202212080001', 'mqtt', '60', null, '0', '4', '1', '1', '87', '0', '1', '2023-01-06 18:55:03', '2023-01-18 13:52:40', null);
INSERT INTO `device` VALUES ('91', '192511', '草莓园监控设备', 'JSNL202212080008', 'modbus', '5000', null, '0', '4', '1', '1', '87', '0', '1', '2023-01-07 16:38:07', '2023-01-18 13:52:25', null);
INSERT INTO `device` VALUES ('92', '192647', '酸甜果采集器', 'JSNL202212080002', 'modbus', '5000', null, '0', '1', '1', '1', '87', '36', '1', '2023-01-09 10:59:22', '2023-01-17 13:53:09', null);
INSERT INTO `device` VALUES ('93', '192692', '测试台NB采集器', 'KWCAHJCJ0A221201', 'tcp', '180', null, '0', '1', '1', '1', '87', '33', '1', '2023-01-09 14:55:44', '2023-01-18 14:34:55', null);

-- ----------------------------
-- Table structure for device_number
-- ----------------------------
DROP TABLE IF EXISTS `device_number`;
CREATE TABLE `device_number` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `deviceNo` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备序列号',
  `device_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备id',
  `status` int DEFAULT '0' COMMENT '设备序列号状态（0.未绑定，1.已绑定）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `deviceNo_key` (`deviceNo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备序列号';

-- ----------------------------
-- Records of device_number
-- ----------------------------
INSERT INTO `device_number` VALUES ('1', 'JSNL202212060000', '187894', '1');
INSERT INTO `device_number` VALUES ('2', 'KWCAHJCJ0A221201', '192692', '1');
INSERT INTO `device_number` VALUES ('3', 'KWCAHJCJCO221201', '191506', '1');
INSERT INTO `device_number` VALUES ('4', 'JSNL202212060003', '190739', '1');
INSERT INTO `device_number` VALUES ('5', 'JSNL202212060004', '188039', '1');
INSERT INTO `device_number` VALUES ('6', 'JSNL202212060005', '188043', '1');
INSERT INTO `device_number` VALUES ('7', 'JSNL202212060006', '188045', '1');
INSERT INTO `device_number` VALUES ('8', 'JSNL202212060007', '188035', '1');
INSERT INTO `device_number` VALUES ('9', 'JSNL202212060008', '188051', '1');
INSERT INTO `device_number` VALUES ('10', 'JSNL202212060009', null, '0');
INSERT INTO `device_number` VALUES ('11', 'KWCASXTHMI202201', '192053', '1');
INSERT INTO `device_number` VALUES ('12', 'JSNL202212080001', '192464', '1');
INSERT INTO `device_number` VALUES ('13', 'JSNL202212080002', '192647', '1');
INSERT INTO `device_number` VALUES ('14', 'JSNL202212080003', '190857', '1');
INSERT INTO `device_number` VALUES ('15', 'JSNL202212080004', '190262', '1');
INSERT INTO `device_number` VALUES ('16', 'JSNL202212080005', null, '0');
INSERT INTO `device_number` VALUES ('17', 'JSNL202212080006', null, '0');
INSERT INTO `device_number` VALUES ('18', 'JSNL202212080007', '188817', '1');
INSERT INTO `device_number` VALUES ('19', 'JSNL202212080008', '192511', '1');
INSERT INTO `device_number` VALUES ('20', 'JSNL202212080009', null, '0');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目组编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目组名称',
  `info` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目组描述',
  `project_id` int DEFAULT NULL COMMENT '项目id',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.删除，1.正常）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目组';

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('1', '022', '22', '2222222', '1', '0', '2022-11-09 17:10:47', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('2', '3', '项目5', '3', '67', '0', '2022-11-14 13:43:01', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('3', '10086', '项目2', '测试1', null, '0', '2022-11-14 13:44:48', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('4', '1', '项目2', '测试1', null, '0', '2022-11-14 13:47:34', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('5', '10086', '项目2', '11', null, '0', '2022-11-14 13:48:24', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('6', '1', '1', '1', null, '0', '2022-11-14 14:01:39', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('7', '2', '1', '3', null, '0', '2022-11-14 14:02:04', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('8', '1', '1', '1', null, '0', '2022-11-14 14:16:58', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('9', 'string', 'string', 'string', null, '1', '2022-11-22 17:00:23', '2022-11-22 16:30:33', null);
INSERT INTO `group` VALUES ('10', '001', '小组1', null, '76', '0', '2022-11-22 17:07:16', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('11', '002', '3', null, '67', '0', '2022-11-22 17:07:51', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('12', '003', '小组3', '新建小组', '67', '0', '2022-11-22 17:09:01', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('13', '003', '小组4', null, '67', '0', '2022-11-22 17:30:37', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('14', '003', 'xiaozu', null, '67', '0', '2022-11-22 17:31:52', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('15', '03', '02', null, '67', '0', '2022-11-22 17:33:13', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('16', '0', '0', null, '67', '0', '2022-11-22 17:36:29', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('17', '3', '3', null, '67', '0', '2022-11-22 17:36:41', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('18', '3', '02', '3', '67', '0', '2022-11-22 17:39:14', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('19', '05', '05', null, '67', '0', '2022-11-22 17:39:26', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('22', '05', '项目组1', '测试\n\n', '67', '0', '2022-11-23 11:49:25', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('23', '12', '0', null, '67', '0', '2022-11-23 13:53:14', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('24', '1', '2', null, '67', '0', '2022-11-23 13:57:15', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('25', '001', '最强小组', null, '70', '0', '2022-11-24 09:28:06', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('26', '002', '青青草原', null, '70', '0', '2022-11-24 09:31:55', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('27', '001', '小组一号', null, '80', '0', '2022-11-24 15:25:17', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('28', '002', '小组2号', null, '80', '0', '2022-11-24 15:26:38', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('29', '001', '小组一号', null, '84', '0', '2022-11-24 15:37:40', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('30', '3', '项目组4', null, '86', '0', '2022-11-24 15:48:14', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('31', '1', '喜气洋洋', null, '86', '0', '2022-11-24 15:49:44', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('32', '001', '项目组01', null, '1', '0', '2022-11-24 16:17:49', '2022-11-24 16:40:39', '1');
INSERT INTO `group` VALUES ('33', '5', '项目组3', '江苏农林23届3班，第二次全体实验，第一项目组实验，目标：采集植物生长环境温度，湿度，pH值。', '87', '1', '2022-11-24 16:41:21', '2023-01-18 13:48:17', '1');
INSERT INTO `group` VALUES ('34', '002', '项目组2', null, '87', '0', '2022-11-25 11:17:13', '2023-01-09 16:01:29', '1');
INSERT INTO `group` VALUES ('35', '003', '小组3', null, '87', '0', '2022-11-25 11:34:42', '2023-01-09 16:06:02', '1');
INSERT INTO `group` VALUES ('36', '004', '项目组4', null, '87', '1', '2022-11-26 09:04:40', null, '1');
INSERT INTO `group` VALUES ('37', '005', '项目组5', null, '87', '0', '2022-12-01 16:06:16', '2023-01-09 12:28:26', '1');
INSERT INTO `group` VALUES ('38', '006', '项目组6', '', '87', '0', '2022-12-01 16:07:32', '2023-01-09 15:53:03', '1');
INSERT INTO `group` VALUES ('39', '002', '超级无敌', null, '88', '1', '2023-01-07 15:27:26', null, '1');
INSERT INTO `group` VALUES ('40', '007', '项目组7', null, '87', '1', '2023-01-09 15:50:41', null, '1');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目名称',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  `info` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目描述',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.删除，1.正常）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('2', 'string', 'string', null, 'string', '1', '2022-11-14 09:36:52', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('3', 'string', 'string', null, 'string', '1', '2022-11-14 13:41:17', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('4', 'string', 'string', null, 'string', '1', '2022-11-14 13:41:19', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('9', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-14 14:28:08', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('74', '20221101', '智能灌溉', '2', '基于基质草莓种植的水肥一体化系统试验', '1', '2022-11-21 09:46:59', null);
INSERT INTO `project` VALUES ('87', '001', '水肥机项目', '1', '水肥机项目是测试，在什么样的水肥比例下合适进行各种植物的生长，水肥比例对植物生长的影响。', '1', '2022-11-24 16:40:58', '2023-01-18 14:18:56');
INSERT INTO `project` VALUES ('88', '002', '鸡舍项目', '1', null, '1', '2022-11-26 13:28:35', null);
INSERT INTO `project` VALUES ('89', '008', '酸甜果项目', '1', null, '1', '2022-11-26 13:28:45', '2023-01-09 11:09:09');
INSERT INTO `project` VALUES ('91', '010', '草莓园项目', '1', '20.', '1', '2023-01-09 11:15:42', '2023-01-10 15:33:27');

-- ----------------------------
-- Table structure for sensor
-- ----------------------------
DROP TABLE IF EXISTS `sensor`;
CREATE TABLE `sensor` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sensor_id` int NOT NULL COMMENT '设备id',
  `sensor_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '传感器名称',
  `sensor_type` int unsigned DEFAULT NULL COMMENT '传感器类型，取值范围 1-8，1数值型，2开关型可操作，5开关型不可操作，3定位型，4图片型，6档位型，7视频，8字符串 必填参数',
  `unit` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位，传感器类型为1（值类型时必填，其它可选）',
  `ordernum` int DEFAULT '0' COMMENT '显示顺序',
  `decimal` int DEFAULT '2' COMMENT '小数位传感器类型为1（值类型时必填，其它可选）',
  `device_id` int NOT NULL COMMENT '设备id',
  `device_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备名称',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT '' COMMENT '状态（0.删除，1.正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='传感器';

-- ----------------------------
-- Records of sensor
-- ----------------------------

-- ----------------------------
-- Table structure for sensor_config
-- ----------------------------
DROP TABLE IF EXISTS `sensor_config`;
CREATE TABLE `sensor_config` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `Chinese_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '中文名称',
  `English_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '英文名称',
  `system_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '传感器节点',
  `unity` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  `collection_id` int NOT NULL COMMENT '采集器id',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.删除，1.正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='传感器';

-- ----------------------------
-- Records of sensor_config
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `school` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学校',
  `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '专业',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系方式',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `role` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT '角色（1.组长，2.组员，0.未参与项目）',
  `project_id` int DEFAULT '0' COMMENT '项目id',
  `group_id` int DEFAULT '0' COMMENT '项目组id',
  `teacher_id` int DEFAULT NULL COMMENT '教师id',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT '状态（0.待审核，1.审核通过，2.审核未通过）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_key` (`account`) USING BTREE COMMENT '账号唯一'
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('7', 'mq', '123456', 'QQQ', '1', '1', '13114715820', '1', '2022-11-09 14:34:09', '2023-01-10 14:09:00', '1', '88', '39', '1', '1');
INSERT INTO `student` VALUES ('10', 'jsnl', '123456', '李友', null, '5', '18269040432', '36160217', null, '2023-01-16 17:26:55', '2', '87', '33', '1', '1');
INSERT INTO `student` VALUES ('11', 'string', '123456', '王小胖', 'string', 'string', 'string', 'string', '2022-11-24 16:21:59', '2023-01-07 15:29:48', '1', '87', '36', '1', '1');
INSERT INTO `student` VALUES ('12', '账号1', '1', 'henry', '1', '1', '1', '1', '2022-11-10 11:10:27', '2023-01-10 15:01:42', '2', '87', '36', '1', '1');
INSERT INTO `student` VALUES ('13', 'huyong', '2', '胡勇', null, '1', '18269040432', '2', '2022-11-10 11:13:59', '2023-01-16 17:10:51', '2', '87', '33', '1', '1');
INSERT INTO `student` VALUES ('14', 'hello', '123456', '王铮', null, null, '6', '3', '2022-11-10 11:22:20', '2023-01-09 15:51:11', '2', '87', '40', '1', '1');
INSERT INTO `student` VALUES ('15', 'xinxin', '123456', '欣欣', null, null, '18269040432', '35555', '2022-11-10 11:22:52', '2023-01-17 10:05:00', '2', '87', '33', '1', '1');
INSERT INTO `student` VALUES ('19', 'qin', 'qxt', null, '南师大', '计科', '18269040432', '361602174@qq.com', '2022-11-21 09:27:44', '2022-11-24 16:40:39', '0', '0', '0', '1', '2');
INSERT INTO `student` VALUES ('20', 'xh', 'ting', '小红', '南师大', '计科', '1826904457', '361602174@qq.com', '2022-11-21 09:32:40', '2023-01-17 10:05:53', '0', '0', '0', '1', '1');
INSERT INTO `student` VALUES ('21', 'glb', 'admin', '小明', '山东大学', '计算机', '12345678901', 'admin@corewell.cn', '2022-11-21 09:42:17', '2023-01-16 17:21:15', '2', '87', '40', '1', '1');
INSERT INTO `student` VALUES ('22', 'msn', 'abc@122', '美少女', '南京大学', '农业', '123456789123', 'abc@corewell.cn', '2022-11-21 09:48:42', '2023-01-18 14:36:30', '2', '87', '33', '1', '1');
INSERT INTO `student` VALUES ('23', 'ceshi', '123456', '测试', null, null, '18269040432', '361602174@qq.com', '2022-11-28 10:58:38', '2023-01-17 10:05:37', '0', '0', '0', '1', '1');
INSERT INTO `student` VALUES ('24', 'wy', '123456', '汪洋', '南师大', '计算机科学与技术', '18269040432', '361602174@qq.com', '2022-12-23 11:59:21', '2023-01-17 10:05:39', '0', '0', '0', '1', '1');
INSERT INTO `student` VALUES ('25', 'acount', '123456', '覃晓婷', null, null, '18269040432', '361602174@qq.com', '2023-01-07 10:40:41', '2023-01-17 10:05:34', '0', '0', '0', '1', '1');
INSERT INTO `student` VALUES ('26', 'admin12', '123456', 'admin12', null, '智慧农业', '1245687555', '124566@qq.com', '2023-01-09 14:42:51', '2023-01-17 10:05:32', '0', '0', '0', '1', '1');
INSERT INTO `student` VALUES ('29', 'admin11', '123456', '1', null, '1', '1', '1', '2023-01-10 15:31:47', '2023-01-17 10:05:28', '0', '0', '0', '1', '1');

-- ----------------------------
-- Table structure for student_device
-- ----------------------------
DROP TABLE IF EXISTS `student_device`;
CREATE TABLE `student_device` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `student_id` int DEFAULT NULL COMMENT '学生id',
  `device_id` int DEFAULT NULL COMMENT '设备id',
  `project_id` int DEFAULT NULL COMMENT '项目id',
  `creator_id` int DEFAULT NULL COMMENT '项目创建者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生设备关联表';

-- ----------------------------
-- Records of student_device
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教师表';

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'admin', '123456', '王老师');
INSERT INTO `teacher` VALUES ('2', 'admin1', '123456', '李老师');
INSERT INTO `teacher` VALUES ('3', 'admin2', '123456', '严老师');
