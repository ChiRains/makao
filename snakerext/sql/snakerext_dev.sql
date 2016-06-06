/*
Navicat MySQL Data Transfer

Source Server         : 10.10.11.60
Source Server Version : 50616
Source Host           : 10.10.11.60:3306
Source Database       : snakerext_dev

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-09-01 20:45:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `snakerext_process_executor`
-- ----------------------------
DROP TABLE IF EXISTS `snakerext_process_executor`;
CREATE TABLE `snakerext_process_executor` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `processId` varchar(32) NOT NULL COMMENT '流程标识',
  `taskName` varchar(20) NOT NULL COMMENT '活动名称',
  `type` tinyint(4) NOT NULL COMMENT '1:用户 2:角色 3:自定义接口',
  `memberId` bigint(11) NOT NULL COMMENT '目标执行人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程活动执行人';

-- ----------------------------
-- Records of snakerext_process_executor
-- ----------------------------

-- ----------------------------
-- Table structure for `snakerext_process_executor_interface`
-- ----------------------------
DROP TABLE IF EXISTS `snakerext_process_executor_interface`;
CREATE TABLE `snakerext_process_executor_interface` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '流程标识',
  `method` varchar(50) NOT NULL COMMENT '接口方法',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同部门获取执行人接口';

-- ----------------------------
-- Records of snakerext_process_executor_interface
-- ----------------------------

-- ----------------------------
-- Table structure for `snakerext_process_form`
-- ----------------------------
DROP TABLE IF EXISTS `snakerext_process_form`;
CREATE TABLE `snakerext_process_form` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `processId` varchar(32) NOT NULL COMMENT '流程标识',
  `mainFormId` bigint(11) NOT NULL COMMENT '主表单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程与主表单的映射';

-- ----------------------------
-- Records of snakerext_process_form
-- ----------------------------

-- ----------------------------
-- Table structure for `snakerext_task_form_access`
-- ----------------------------
DROP TABLE IF EXISTS `snakerext_task_form_access`;
CREATE TABLE `snakerext_task_form_access` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `processId` varchar(32) NOT NULL COMMENT '流程标识id',
  `taskName` varchar(20) NOT NULL COMMENT '任务活动名称',
  `formId` bigint(11) NOT NULL COMMENT '表单id',
  `elementId` bigint(11) NOT NULL COMMENT '表单元素id',
  `formType` tinyint(4) NOT NULL COMMENT '表单类型(0:主表单 1:子表单)',
  `status` tinyint(4) NOT NULL COMMENT '是否可写(0:不可写 1:可写)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程活动与表单元素的权限映射';

-- ----------------------------
-- Records of snakerext_task_form_access
-- ----------------------------
