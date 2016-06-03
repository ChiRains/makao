/*
Navicat MySQL Data Transfer

Source Server         : 10.10.11.60
Source Server Version : 50616
Source Host           : 10.10.11.60:3306
Source Database       : form_dev

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-12-06 05:41:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `form_element_def`
-- ----------------------------
DROP TABLE IF EXISTS `form_element_def`;
CREATE TABLE `form_element_def` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `formId` bigint(11) DEFAULT NULL COMMENT '表单id',
  `name` varchar(100) DEFAULT NULL COMMENT '表单名',
  `code` varchar(100) DEFAULT NULL COMMENT '编码',
  `type` int(2) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表单元素定义';

-- ----------------------------
-- Records of form_element_def
-- ----------------------------

-- ----------------------------
-- Table structure for `form_element_field_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `form_element_field_mapping`;
CREATE TABLE `form_element_field_mapping` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `elementId` bigint(11) NOT NULL COMMENT '元素id',
  `fieldId` bigint(11) NOT NULL COMMENT '属性id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表单与数据库表的映射';

-- ----------------------------
-- Records of form_element_field_mapping
-- ----------------------------

-- ----------------------------
-- Table structure for `form_form_def`
-- ----------------------------
DROP TABLE IF EXISTS `form_form_def`;
CREATE TABLE `form_form_def` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `mainFormId` bigint(11) DEFAULT NULL COMMENT '主表ID',
  `name` varchar(100) DEFAULT NULL COMMENT '表单名',
  `code` varchar(100) DEFAULT NULL COMMENT '编码',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `pcPageUrl` varchar(200) DEFAULT NULL COMMENT 'PC页面',
  `mobilePageUrl` varchar(200) DEFAULT NULL COMMENT '移动端入口',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表单定义';

-- ----------------------------
-- Records of form_form_def
-- ----------------------------

-- ----------------------------
-- Table structure for `form_form_instance`
-- ----------------------------
DROP TABLE IF EXISTS `form_form_instance`;
CREATE TABLE `form_form_instance` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `formId` bigint(11) NOT NULL COMMENT '表单id',
  `dataId` bigint(11) NOT NULL COMMENT '数据id',
  `code` varchar(255) DEFAULT NULL COMMENT '表单编码',
  `editTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表单实例';

-- ----------------------------
-- Records of form_form_instance
-- ----------------------------

-- ----------------------------
-- Table structure for `form_form_instance_code_number`
-- ----------------------------
DROP TABLE IF EXISTS `form_form_instance_code_number`;
CREATE TABLE `form_form_instance_code_number` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `number` bigint(11) NOT NULL COMMENT '数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表单编码';

-- ----------------------------
-- Records of form_form_instance_code_number
-- ----------------------------

-- ----------------------------
-- Table structure for `form_form_instance_hist`
-- ----------------------------
DROP TABLE IF EXISTS `form_form_instance_hist`;
CREATE TABLE `form_form_instance_hist` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `formId` bigint(11) NOT NULL COMMENT '表单id',
  `formInstanceId` bigint(11) NOT NULL COMMENT '表单实例id',
  `code` varchar(255) DEFAULT NULL COMMENT '表单编码',
  `dataId` bigint(11) NOT NULL COMMENT '数据id',
  `editTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  `backTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '备份时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表单实例备份';

-- ----------------------------
-- Records of form_form_instance_hist
-- ----------------------------

-- ----------------------------
-- Table structure for `form_form_table_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `form_form_table_mapping`;
CREATE TABLE `form_form_table_mapping` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `mainFormId` bigint(11) NOT NULL COMMENT '表单id',
  `tableId` bigint(11) NOT NULL COMMENT '数据库表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表单与数据库表的映射';

-- ----------------------------
-- Records of form_form_table_mapping
-- ----------------------------
