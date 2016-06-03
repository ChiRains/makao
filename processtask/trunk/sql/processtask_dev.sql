/*
Navicat MySQL Data Transfer

Source Server         : 10.10.11.60
Source Server Version : 50616
Source Host           : 10.10.11.60:3306
Source Database       : processtask_dev

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-09-06 11:42:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `processtask_tasked`
-- ----------------------------
DROP TABLE IF EXISTS `processtask_tasked`;
CREATE TABLE `processtask_tasked` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `taskingId` bigint(11) NOT NULL COMMENT '原待办任务ID',
  `clerkId` bigint(11) NOT NULL COMMENT '处理人ID',
  `creator` bigint(11) NOT NULL COMMENT '流程申请ID',
  `name` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `type` varchar(100) DEFAULT NULL COMMENT '流程类型',
  `applyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `receiveTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '接收时间',
  `dealTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '接收时间',
  `formId` bigint(11) NOT NULL COMMENT '表单ID',
  `formInstanceId` bigint(11) NOT NULL COMMENT '表单实例ID',
  `formInstanceHistId` bigint(11) NOT NULL COMMENT '表单实例历史ID',
  `processId` varchar(100) NOT NULL COMMENT '流程ID',
  `processInstId` varchar(100) NOT NULL COMMENT '流程实例ID',
  `workitemId` varchar(100) NOT NULL COMMENT '流程任务ID',
  `pcPageUrl` varchar(200) DEFAULT NULL COMMENT 'PC页面',
  `mobilePageUrl` varchar(200) DEFAULT NULL COMMENT '移动端入口',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='已办任务';

-- ----------------------------
-- Records of processtask_tasked
-- ----------------------------

-- ----------------------------
-- Table structure for `processtask_tasking`
-- ----------------------------
DROP TABLE IF EXISTS `processtask_tasking`;
CREATE TABLE `processtask_tasking` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `clerkId` bigint(11) NOT NULL COMMENT '处理人ID',
  `creator` bigint(11) NOT NULL COMMENT '流程申请ID',
  `name` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `type` varchar(100) DEFAULT NULL COMMENT '流程类型',
  `applyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `receiveTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '接收时间',
  `formId` bigint(11) NOT NULL COMMENT '表单实例ID',
  `formInstanceId` bigint(11) NOT NULL COMMENT '表单实例ID',
  `processId` varchar(100) NOT NULL COMMENT '流程实例ID',
  `processInstId` varchar(100) NOT NULL COMMENT '流程实例ID',
  `workitemId` varchar(100) NOT NULL COMMENT '流程任务ID',
  `pcPageUrl` varchar(200) DEFAULT NULL COMMENT 'PC页面',
  `mobilePageUrl` varchar(200) DEFAULT NULL COMMENT '移动端入口',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='待办任务';

-- ----------------------------
-- Records of processtask_tasking
-- ----------------------------
