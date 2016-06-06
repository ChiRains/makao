/*
Navicat MySQL Data Transfer

Source Server         : 120.24.83.179
Source Server Version : 50173
Source Host           : 120.24.83.179:3306
Source Database       : monitor_dev

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-03-29 12:31:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pirates_admin`
-- ----------------------------
DROP TABLE IF EXISTS `pirates_admin`;
CREATE TABLE `pirates_admin` (
  `id` bigint(11) NOT NULL,
  `account` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pirates_admin
-- ----------------------------
