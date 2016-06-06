/*
Navicat MySQL Data Transfer

Source Server         : 10.10.11.60
Source Server Version : 50616
Source Host           : 10.10.11.60:3306
Source Database       : account_dev

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-11-21 10:27:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account_certificate_type`
-- ----------------------------
DROP TABLE IF EXISTS `account_certificate_type`;
CREATE TABLE `account_certificate_type` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `code` varchar(100) DEFAULT NULL COMMENT '编码',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户类型';

-- ----------------------------
-- Records of account_certificate_type
-- ----------------------------

-- ----------------------------
-- Table structure for `account_entry_certificate`
-- ----------------------------
DROP TABLE IF EXISTS `account_entry_certificate`;
CREATE TABLE `account_entry_certificate` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `account` varchar(255) DEFAULT NULL COMMENT '账号',
  `group` varchar(255) NOT NULL COMMENT '组',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL COMMENT '账号名称',
  `registTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登记时间',
  `state` int(2) DEFAULT NULL COMMENT '状态 1启用 2禁用 3冻结',
  `frozenTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '冻结开始时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号表';

-- ----------------------------
-- Records of account_entry_certificate
-- ----------------------------
