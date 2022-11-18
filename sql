/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80031
Source Host           : localhost:3306
Source Database       : core_farming

Target Server Type    : MYSQL
Target Server Version : 80031
File Encoding         : 65001

Date: 2022-11-18 09:25:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `student_id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '学生Id',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `del_flag` char(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '标志位（1,正常，0.删除）',
  UNIQUE KEY `account_index` (`account`) USING BTREE COMMENT '账号索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('admin', '123456', '1', null, '1');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='协议';

-- ----------------------------
-- Records of agreement
-- ----------------------------

-- ----------------------------
-- Table structure for approve
-- ----------------------------
DROP TABLE IF EXISTS `approve`;
CREATE TABLE `approve` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `school` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学校',
  `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '专业',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系方式',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '审核状态（1.待审核，2.通过，3.不通过）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';

-- ----------------------------
-- Records of approve
-- ----------------------------

-- ----------------------------
-- Table structure for collector
-- ----------------------------
DROP TABLE IF EXISTS `collector`;
CREATE TABLE `collector` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `model` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备型号',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '采集器名称',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.未绑定，1.在线，2.离线）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `creator_id` int NOT NULL COMMENT '创建者id',
  `decoder_id` int NOT NULL COMMENT '解码器id',
  `agreement_id` int NOT NULL COMMENT '协议id',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.删除，1.正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='采集设备';

-- ----------------------------
-- Records of collector
-- ----------------------------

-- ----------------------------
-- Table structure for decoder
-- ----------------------------
DROP TABLE IF EXISTS `decoder`;
CREATE TABLE `decoder` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器名称',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器编号',
  `model` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器型号',
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器路径',
  `port` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '解码器端口',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `creator_id` int DEFAULT NULL COMMENT '创建者id',
  `agreement_id` int NOT NULL COMMENT '协议id',
  `delete_flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '状态（0.删除，1.正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='解码器';

-- ----------------------------
-- Records of decoder
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目组';

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('1', '022', '22', '2222222', '1', '0', '2022-11-09 17:10:47', '2022-11-09 17:12:29', '1');
INSERT INTO `group` VALUES ('2', '10086', '项目2', '5', null, '1', '2022-11-14 13:43:01', null, '1');
INSERT INTO `group` VALUES ('3', '10086', '项目2', '测试1', null, '1', '2022-11-14 13:44:48', null, '1');
INSERT INTO `group` VALUES ('4', '1', '项目2', '测试1', null, '1', '2022-11-14 13:47:34', null, '1');
INSERT INTO `group` VALUES ('5', '10086', '项目2', '11', null, '1', '2022-11-14 13:48:24', null, '1');
INSERT INTO `group` VALUES ('6', '1', '1', '1', null, '1', '2022-11-14 14:01:39', null, '1');
INSERT INTO `group` VALUES ('7', '2', '1', '3', null, '1', '2022-11-14 14:02:04', null, '1');
INSERT INTO `group` VALUES ('8', '1', '1', '1', null, '1', '2022-11-14 14:16:58', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '0001', '项目1', '1', '第一个项目', '1', '2022-11-09 13:12:29', '2022-11-09 13:19:35');
INSERT INTO `project` VALUES ('2', 'string', 'string', null, 'string', '1', '2022-11-14 09:36:52', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('3', 'string', 'string', null, 'string', '1', '2022-11-14 13:41:17', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('4', 'string', 'string', null, 'string', '1', '2022-11-14 13:41:19', '2022-11-14 09:36:59');
INSERT INTO `project` VALUES ('5', '1', '1', '1', '1', '1', '2022-11-14 14:20:49', null);
INSERT INTO `project` VALUES ('6', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-14 14:22:39', null);
INSERT INTO `project` VALUES ('7', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-14 14:23:21', null);
INSERT INTO `project` VALUES ('8', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-14 14:26:07', null);
INSERT INTO `project` VALUES ('9', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-14 14:28:08', null);
INSERT INTO `project` VALUES ('10', '管理员选择\nadmin', '1', '1', '选择协议类型1234', '1', '2022-11-14 14:44:58', null);
INSERT INTO `project` VALUES ('11', '1', '管理员选择\nadmin', '1', '选择协议类型1234', '1', '2022-11-14 14:45:42', null);
INSERT INTO `project` VALUES ('12', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-14 15:08:42', null);
INSERT INTO `project` VALUES ('13', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-15 09:01:54', null);
INSERT INTO `project` VALUES ('14', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-15 09:02:04', null);
INSERT INTO `project` VALUES ('15', '3', '管理员选择\nadmin', '1', '选择协议类型1234', '1', '2022-11-15 09:02:25', null);
INSERT INTO `project` VALUES ('16', '14545', '管理员选择\nadmin', '1', '选择协议类型1234', '1', '2022-11-15 09:02:33', null);
INSERT INTO `project` VALUES ('17', '23', '管理员选择\nadmin', '1', '选择协议类型1234', '1', '2022-11-15 09:02:41', null);
INSERT INTO `project` VALUES ('18', '2', '2', '1', '33656566', '1', '2022-11-15 09:02:52', null);
INSERT INTO `project` VALUES ('19', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-15 16:00:47', null);
INSERT INTO `project` VALUES ('20', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-15 16:09:23', null);
INSERT INTO `project` VALUES ('21', '选择协议类型1234', '选择厂商1234', '1', '选择厂商1234', '1', '2022-11-16 13:58:41', null);
INSERT INTO `project` VALUES ('22', '选择协议类型1234', '选择厂商1234', '1', '选择厂商1234', '1', '2022-11-17 14:29:06', null);
INSERT INTO `project` VALUES ('23', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-17 17:05:00', null);
INSERT INTO `project` VALUES ('24', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-17 17:05:02', null);
INSERT INTO `project` VALUES ('25', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-17 17:05:03', null);
INSERT INTO `project` VALUES ('26', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-17 17:05:04', null);
INSERT INTO `project` VALUES ('27', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-17 17:05:04', null);
INSERT INTO `project` VALUES ('28', '选择厂商1234', '管理员选择\nadmin', '1', '3', '1', '2022-11-17 17:05:05', null);

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'admin', '123456', null, null, null, '123234', null, null, '2022-11-10 10:45:07', '0', null, null, '1', '2');
INSERT INTO `student` VALUES ('2', 'admin11', '123456', null, null, null, null, null, '2022-11-04 14:09:49', '2022-11-10 11:12:00', '0', '1', '1', '1', '1');
INSERT INTO `student` VALUES ('3', '5', '8', null, '5', '5', '5', '5', '2022-11-09 11:03:53', null, '0', null, null, null, '0');
INSERT INTO `student` VALUES ('4', '5878', '455', null, null, null, '15455', null, '2022-11-09 11:04:58', null, '0', null, null, null, '0');
INSERT INTO `student` VALUES ('5', '5872', '45', null, null, null, '15455', null, '2022-11-09 11:05:48', null, '0', null, null, null, '0');
INSERT INTO `student` VALUES ('6', '85', '5', null, null, null, '8', null, '2022-11-09 11:07:09', null, '0', null, null, null, '0');
INSERT INTO `student` VALUES ('7', '1', '1', null, '1', '1', '1', '1', '2022-11-09 14:34:09', '2022-11-10 10:03:39', '0', null, null, null, '1');
INSERT INTO `student` VALUES ('8', '3', '1', null, '1', '1', '1', '1', '2022-11-09 14:38:19', null, '0', null, null, null, '0');
INSERT INTO `student` VALUES ('9', '45545', '2', null, '2', '2', '25', '5', '2022-11-09 14:40:10', null, '0', null, null, null, '0');
INSERT INTO `student` VALUES ('10', '98', '1', null, '1', '1', '1', '1', '2022-11-09 14:43:36', null, '0', null, null, '3', '0');
INSERT INTO `student` VALUES ('11', '12', '1', null, '1', '1', '1', '1', '2022-11-09 14:45:36', null, '0', null, null, '2', '0');
INSERT INTO `student` VALUES ('12', '测试1', '1', null, '1', '1', '1', '1', '2022-11-10 11:10:27', '2022-11-10 11:11:15', '0', null, null, '1', '1');
INSERT INTO `student` VALUES ('13', '测试3', '2', null, null, '1', '2', '2', '2022-11-10 11:13:59', '2022-11-10 11:14:37', '0', null, null, '1', '1');
INSERT INTO `student` VALUES ('14', '测试2', '2', null, null, null, '6', '3', '2022-11-10 11:22:20', null, '0', null, null, '1', '0');
INSERT INTO `student` VALUES ('15', '测试4', '2', null, null, null, '6', '3', '2022-11-10 11:22:52', null, '0', null, null, '1', '0');
INSERT INTO `student` VALUES ('16', '测试5', '2', null, null, null, '6', '3', '2022-11-10 11:22:58', '2022-11-14 09:06:11', '0', null, null, '1', '2');
INSERT INTO `student` VALUES ('17', '测试6', '2', null, null, null, '6', '3', '2022-11-10 11:23:03', '2022-11-10 11:23:31', '0', null, null, '1', '2');
INSERT INTO `student` VALUES ('18', '测试7', '2', null, null, null, '6', '3', '2022-11-10 11:23:07', '2022-11-10 11:23:27', '0', null, null, '1', '2');

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
