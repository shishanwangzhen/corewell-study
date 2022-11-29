/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80031
Source Host           : localhost:3306
Source Database       : core_farming

Target Server Type    : MYSQL
Target Server Version : 80031
File Encoding         : 65001

Date: 2022-11-29 14:29:21
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
  `prducer` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '生产商',
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='解码器';

-- ----------------------------
-- Records of decoder
-- ----------------------------
INSERT INTO `decoder` VALUES ('1', '1', '1', '1', null, '1', '1', '1', '1', '2022-11-25 11:46:32', '2022-11-25 11:46:35', '1', '1');
INSERT INTO `decoder` VALUES ('2', '2', '2', '2', null, '1', '2', '2', '2', '2022-11-25 11:46:58', '2022-11-25 11:47:04', '1', '1');

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `model` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备型号',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备名称',
  `agreement` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '协议类型',
  `manufacturer` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '厂商',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `binding` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '绑定状态（0.未绑定项目，1.已绑定项目）',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.未绑定，1.在线，2.离线）',
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备类型（1.采集设备，2.控制设备，3.被控设备，4.视频设备，5.虚拟设备）',
  `is_alarms` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.未报警，1.报警）',
  `binding_id` int DEFAULT NULL COMMENT '项目负责人id',
  `project_id` int DEFAULT NULL COMMENT '项目id',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  `decoder_id` int DEFAULT NULL COMMENT '解码器id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.删除，1.正常）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_key` (`number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='采集设备';

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', 'A701', '106031', '二氧化碳采集器', '1', null, '用于采集草莓的二氧化碳浓度', null, '1', null, null, null, '0', '1', '1', '2022-11-16 16:26:45', '2022-11-26 09:14:57', '1');
INSERT INTO `device` VALUES ('2', '2', '1', '1', '1', null, '采集二氧化碳浓度', null, '1', null, null, null, '0', '1', '1', '2022-11-16 16:27:02', '2022-11-26 15:21:24', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目组';

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
INSERT INTO `group` VALUES ('20', 'string', 'string', 'string', null, '1', '2022-11-23 09:27:45', '2022-11-23 09:27:42', null);
INSERT INTO `group` VALUES ('21', 'string', 'string', 'string', null, '1', '2022-11-23 10:16:00', '2022-11-23 10:15:55', null);
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
INSERT INTO `group` VALUES ('33', '001', '项目组1', '你好', '87', '1', '2022-11-24 16:41:21', '2022-11-25 17:24:08', '1');
INSERT INTO `group` VALUES ('34', '002', '项目组2', null, '87', '1', '2022-11-25 11:17:13', null, '1');
INSERT INTO `group` VALUES ('35', '003', '小组3', null, '87', '1', '2022-11-25 11:34:42', null, '1');
INSERT INTO `group` VALUES ('36', '004', '项目组4', null, '87', '1', '2022-11-26 09:04:40', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '0001', '项目1', '1', '第一个项目', '0', '2022-11-09 13:12:29', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('2', 'string', 'string', null, 'string', '1', '2022-11-14 09:36:52', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('3', 'string', 'string', null, 'string', '1', '2022-11-14 13:41:17', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('4', 'string', 'string', null, 'string', '1', '2022-11-14 13:41:19', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('5', '1', '1', '1', '1', '0', '2022-11-14 14:20:49', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('6', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-14 14:22:39', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('7', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-14 14:23:21', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('8', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-14 14:26:07', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('9', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-14 14:28:08', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('10', '管理员选择\nadmin', '1', '1', '选择协议类型1234', '0', '2022-11-14 14:44:58', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('11', '1', '管理员选择\nadmin', '1', '选择协议类型1234', '0', '2022-11-14 14:45:42', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('12', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-14 15:08:42', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('13', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-15 09:01:54', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('14', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-15 09:02:04', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('15', '3', '管理员选择\nadmin', '1', '选择协议类型1234', '0', '2022-11-15 09:02:25', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('16', '14545', '管理员选择\nadmin', '1', '选择协议类型1234', '0', '2022-11-15 09:02:33', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('17', '23', '管理员选择\nadmin', '1', '选择协议类型1234', '0', '2022-11-15 09:02:41', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('18', '2', '2', '1', '33656566', '0', '2022-11-15 09:02:52', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('19', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-15 16:00:47', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('20', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-15 16:09:23', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('21', '选择协议类型1234', '选择厂商1234', '1', '选择厂商1234', '0', '2022-11-16 13:58:41', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('22', '选择协议类型1234', '选择厂商1234', '1', '选择厂商1234', '0', '2022-11-17 14:29:06', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('23', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-17 17:05:00', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('24', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-17 17:05:02', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('25', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-17 17:05:03', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('26', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-17 17:05:04', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('27', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-17 17:05:04', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('28', '选择厂商1234', '管理员选择\nadmin', '1', '3', '0', '2022-11-17 17:05:05', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('29', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:41:30', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('30', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:41:31', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('31', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:41:33', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('32', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:41:39', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('33', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:41:40', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('34', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:41:48', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('35', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:42:29', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('36', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:42:30', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('37', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:42:31', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('38', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:42:31', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('39', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:42:54', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('40', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:42:55', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('41', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:46:04', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('42', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:46:06', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('43', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:46:39', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('44', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:46:40', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('45', null, '管理员选择\nadmin', '1', null, '0', '2022-11-18 09:47:43', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('46', null, null, '1', null, '0', '2022-11-18 09:50:56', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('47', null, '测试2', '1', null, '0', '2022-11-18 09:51:04', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('48', '3', '2', '1', '3', '0', '2022-11-18 09:51:40', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('49', '2', '2', '1', '3', '0', '2022-11-18 09:53:36', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('50', '1', '测试1', '1', null, '0', '2022-11-18 09:56:23', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('51', '002', '测试5', '1', '这是测试', '0', '2022-11-18 14:50:09', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('52', null, '3', '1', null, '0', '2022-11-18 16:09:39', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('53', '1', null, '1', null, '0', '2022-11-18 16:09:53', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('54', '1', null, '1', null, '0', '2022-11-18 16:10:20', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('55', '1', null, '1', null, '0', '2022-11-18 16:10:51', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('56', null, '1', '1', null, '0', '2022-11-18 16:12:22', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('57', null, '1', '1', null, '0', '2022-11-18 16:12:36', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('58', '1', null, '1', null, '0', '2022-11-18 16:13:01', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('59', '1', null, '1', null, '0', '2022-11-18 16:15:06', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('60', '1', null, '1', null, '0', '2022-11-18 16:15:36', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('61', '1', null, '1', null, '0', '2022-11-18 16:16:30', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('62', '1', null, '1', null, '0', '2022-11-18 16:17:45', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('63', '1', null, '1', null, '0', '2022-11-18 16:18:02', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('64', '1', null, '1', null, '0', '2022-11-18 16:18:46', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('65', '1', null, '1', null, '0', '2022-11-18 16:19:14', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('66', '1', null, '1', null, '0', '2022-11-18 16:20:57', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('67', '2', '采集器', '1', '1', '0', '2022-11-21 09:03:57', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('68', '2', '1', '1', '1', '0', '2022-11-21 09:04:13', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('69', '2', '1', '1', '1', '0', '2022-11-21 09:04:17', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('70', '1', '测试', '1', '2', '0', '2022-11-21 09:04:34', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('71', '2', '1', '1', '3', '0', '2022-11-21 09:06:42', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('72', '002', '测试3', '1', '1212', '0', '2022-11-21 09:07:11', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('73', '008', '水肥一体化项目', '1', '第一个项目', '0', '2022-11-21 09:38:24', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('74', '20221101', '智能灌溉', '2', '基于基质草莓种植的水肥一体化系统试验', '1', '2022-11-21 09:46:59', null);
INSERT INTO `project` VALUES ('75', '003', '项目1', '1', null, '0', '2022-11-22 11:40:49', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('76', '0002', '测试3', '1', null, '0', '2022-11-22 16:46:10', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('77', '1', '1', '1', null, '0', '2022-11-22 16:56:56', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('78', '1', '1', '1', null, '0', '2022-11-22 16:56:57', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('79', '1', '1', '1', null, '0', '2022-11-22 16:57:08', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('80', '001', '项目1', '1', null, '0', '2022-11-24 10:34:41', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('81', '002', '项目1', '1', null, '0', '2022-11-24 15:27:49', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('82', '001', '项目1', '1', null, '0', '2022-11-24 15:33:42', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('83', '001', '项目1', '1', null, '0', '2022-11-24 15:33:52', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('84', '001', '项目1', '1', null, '0', '2022-11-24 15:37:22', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('85', '002', '项目2', '1', null, '0', '2022-11-24 15:42:29', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('86', '001', '水肥机一体化测试', '1', null, '0', '2022-11-24 15:43:37', '2022-11-24 16:40:39');
INSERT INTO `project` VALUES ('87', '001', '水肥机项目', '1', null, '1', '2022-11-24 16:40:58', null);
INSERT INTO `project` VALUES ('88', '002', '鸡舍项目', '1', null, '1', '2022-11-26 13:28:35', null);
INSERT INTO `project` VALUES ('89', '003', '养殖场项目', '1', null, '1', '2022-11-26 13:28:45', null);

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
  `project_id` int DEFAULT NULL COMMENT '项目id',
  `group_id` int DEFAULT NULL COMMENT '项目组id',
  `teacher_id` int DEFAULT NULL COMMENT '教师id',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.待审核，1.审核通过，2.审核未通过）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_key` (`account`) USING BTREE COMMENT '账号唯一'
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'admin', '123456', null, null, null, '123234', null, null, '2022-11-24 16:40:39', '0', '0', '0', '1', '2');
INSERT INTO `student` VALUES ('2', 'admin11', '123456', null, null, null, null, null, '2022-11-04 14:09:49', '2022-11-24 16:40:39', '0', '0', '0', '1', '1');
INSERT INTO `student` VALUES ('3', '5', '8', null, '5', '5', '5', '5', '2022-11-09 11:03:53', null, '0', '67', '16', null, '0');
INSERT INTO `student` VALUES ('4', '5878', '455', null, null, null, '15455', null, '2022-11-09 11:04:58', null, '0', '67', '16', null, '0');
INSERT INTO `student` VALUES ('5', '5872', '45', null, null, null, '15455', null, '2022-11-09 11:05:48', null, '0', '67', '16', null, '0');
INSERT INTO `student` VALUES ('6', '85', '5', null, null, null, '8', null, '2022-11-09 11:07:09', null, '0', '67', '16', null, '0');
INSERT INTO `student` VALUES ('7', '1', '1', null, '1', '1', '1', '1', '2022-11-09 14:34:09', '2022-11-24 16:24:18', '2', '1', '16', null, '1');
INSERT INTO `student` VALUES ('8', '3', '1', null, '1', '1', '1', '1', '2022-11-09 14:38:19', null, '0', '67', '16', null, '0');
INSERT INTO `student` VALUES ('9', '45545', '2', null, '2', '2', '25', '5', '2022-11-09 14:40:10', null, '0', '67', '16', null, '0');
INSERT INTO `student` VALUES ('10', '98', '1', null, '1', '1', '1', '1', '2022-11-09 14:43:36', null, '0', '67', '16', '3', '0');
INSERT INTO `student` VALUES ('11', 'string', '123456', 'string', 'string', 'string', 'string', 'string', '2022-11-24 16:21:59', '2022-11-24 17:05:30', '0', '1', '1', '1', '0');
INSERT INTO `student` VALUES ('12', '测试1', '1', null, '1', '1', '1', '1', '2022-11-10 11:10:27', '2022-11-25 11:24:45', '2', '87', '33', '1', '1');
INSERT INTO `student` VALUES ('13', '测试3', '2', null, null, '1', '2', '2', '2022-11-10 11:13:59', '2022-11-25 11:33:07', '2', '87', '33', '1', '1');
INSERT INTO `student` VALUES ('14', '测试2', '2', null, null, null, '6', '3', '2022-11-10 11:22:20', '2022-11-26 16:44:56', '1', '87', '33', '1', '1');
INSERT INTO `student` VALUES ('15', '测试4', '2', null, null, null, '6', '3', '2022-11-10 11:22:52', '2022-11-25 11:34:54', '2', '87', '34', '1', '1');
INSERT INTO `student` VALUES ('16', '测试5', '2', null, null, null, '6', '3', '2022-11-10 11:22:58', '2022-11-24 16:40:39', '0', '0', '0', '1', '2');
INSERT INTO `student` VALUES ('17', '测试6', '2', null, null, null, '6', '3', '2022-11-10 11:23:03', '2022-11-24 16:40:39', '0', '0', '0', '1', '2');
INSERT INTO `student` VALUES ('18', '测试7', '2', null, null, null, '6', '3', '2022-11-10 11:23:07', '2022-11-24 16:40:39', '0', '0', '0', '1', '2');
INSERT INTO `student` VALUES ('19', 'qin', 'qxt', null, '南师大', '计科', '18269040432', '361602174@qq.com', '2022-11-21 09:27:44', '2022-11-24 16:40:39', '0', '0', '0', '1', '2');
INSERT INTO `student` VALUES ('20', '李友', 'ting', null, '南师大', '计科', '1826904457', '361602174@qq.com', '2022-11-21 09:32:40', '2022-11-24 16:40:39', '0', '0', '0', '1', '1');
INSERT INTO `student` VALUES ('21', '古老板', 'admin', null, '山东大学', '计算机', '12345678901', 'admin@corewell.cn', '2022-11-21 09:42:17', '2022-11-21 09:44:41', '0', '67', '16', '2', '1');
INSERT INTO `student` VALUES ('22', '小账户', 'abc@122', '445454', '南京大学', '农业', '123456789123', 'abc@corewell.cn', '2022-11-21 09:48:42', '2022-11-25 10:06:27', '1', '87', '16', '1', '1');
INSERT INTO `student` VALUES ('23', 'ceshi', 'ting361602174', null, null, null, '18269040432', '361602174@qq.com', '2022-11-28 10:58:38', '2022-11-28 10:58:56', '0', null, null, '1', '1');

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
INSERT INTO `teacher` VALUES ('1', 'admin', '123456', '王小二');
INSERT INTO `teacher` VALUES ('2', 'admin1', '123456', '王小三');
INSERT INTO `teacher` VALUES ('3', 'admin2', '123456', '王小四');
