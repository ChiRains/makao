/*
Navicat MySQL Data Transfer

Source Server         : 10.10.11.60
Source Server Version : 50616
Source Host           : 10.10.11.60:3306
Source Database       : metadata_dev

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-09-01 15:23:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `metadata_field`
-- ----------------------------
DROP TABLE IF EXISTS `metadata_field`;
CREATE TABLE `metadata_field` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `tableId` bigint(11) DEFAULT NULL COMMENT '表',
  `label` varchar(200) DEFAULT NULL COMMENT '名称',
  `name` varchar(100) DEFAULT NULL COMMENT '字段名',
  `type` int(2) DEFAULT NULL COMMENT '类型',
  `length` int(2) DEFAULT NULL COMMENT '长度',
  `precision` int(2) DEFAULT NULL COMMENT '精度',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性定义';

-- ----------------------------
-- Records of metadata_field
-- ----------------------------

-- ----------------------------
-- Table structure for `metadata_table`
-- ----------------------------
DROP TABLE IF EXISTS `metadata_table`;
CREATE TABLE `metadata_table` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `label` varchar(200) DEFAULT NULL COMMENT '名称',
  `name` varchar(100) DEFAULT NULL COMMENT '表名',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表定义';

-- ----------------------------
-- Records of metadata_table
-- ----------------------------
