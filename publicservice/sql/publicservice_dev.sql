/*
Navicat MySQL Data Transfer

Source Server         : 10.10.11.60
Source Server Version : 50616
Source Host           : 10.10.11.60:3306
Source Database       : publicservice_dev

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-11-12 00:43:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `publicservice_message_type`
-- ----------------------------
DROP TABLE IF EXISTS `publicservice_message_type`;
CREATE TABLE `publicservice_message_type` (
  `id` bigint(11) NOT NULL,
  `code` varchar(200) DEFAULT NULL COMMENT '消息标题',
  `name` varchar(1000) DEFAULT NULL COMMENT '消息内容',
  `tableNumber` int(3) DEFAULT NULL COMMENT '存储表数量,1 10 100',
  `storageTime` int(2) DEFAULT NULL COMMENT '多少个月',
  `classify` varchar(255) DEFAULT NULL COMMENT '消息类型,数据定义-1:类型名称;2类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息类型';

-- ----------------------------
-- Records of publicservice_message_type
-- ----------------------------
