/*
Navicat MySQL Data Transfer

Source Server         : 10.10.11.60
Source Server Version : 50616
Source Host           : 10.10.11.60:3306
Source Database       : publicdata_dev

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-10-14 19:33:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `publicdata_city`
-- ----------------------------
DROP TABLE IF EXISTS `publicdata_city`;
CREATE TABLE `publicdata_city` (
  `id` bigint(11) NOT NULL,
  `provinceId` bigint(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '市',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='市';

-- ----------------------------
-- Records of publicdata_city
-- ----------------------------

-- ----------------------------
-- Table structure for `publicdata_classify`
-- ----------------------------
DROP TABLE IF EXISTS `publicdata_classify`;
CREATE TABLE `publicdata_classify` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `parentId` bigint(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `bsid` varchar(200) DEFAULT NULL COMMENT '树编码',
  `type` bigint(11) DEFAULT NULL COMMENT '分类类型',
  `image` varchar(200) DEFAULT NULL COMMENT '图片',
  `remark` varchar(200) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL COMMENT '是否启用0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类';

-- ----------------------------
-- Records of publicdata_classify
-- ----------------------------

-- ----------------------------
-- Table structure for `publicdata_data_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `publicdata_data_dictionary`;
CREATE TABLE `publicdata_data_dictionary` (
  `id` bigint(11) NOT NULL,
  `type` varchar(100) DEFAULT NULL COMMENT '类型',
  `key` bigint(11) DEFAULT NULL COMMENT '存储键值',
  `value` varchar(100) DEFAULT NULL COMMENT '显示名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of publicdata_data_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `publicdata_district`
-- ----------------------------
DROP TABLE IF EXISTS `publicdata_district`;
CREATE TABLE `publicdata_district` (
  `id` bigint(11) NOT NULL,
  `provinceId` bigint(11) DEFAULT NULL,
  `cityId` bigint(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '区/县',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区/县';

-- ----------------------------
-- Records of publicdata_district
-- ----------------------------

-- ----------------------------
-- Table structure for `publicdata_express`
-- ----------------------------
DROP TABLE IF EXISTS `publicdata_express`;
CREATE TABLE `publicdata_express` (
  `id` bigint(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '快递公司名称',
  `code` varchar(255) DEFAULT NULL COMMENT '快递公司编码',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `logo` varchar(255) DEFAULT NULL COMMENT '快递公司图片',
  `sort` bigint(11) DEFAULT NULL COMMENT '排序',
  `firstWeight` double(11,2) DEFAULT NULL COMMENT '首重重量',
  `firstPrice` double(11,2) DEFAULT NULL COMMENT '首重费用',
  `continuedWeight` double(11,2) DEFAULT NULL COMMENT '续重重量',
  `continuedPrice` double(11,2) DEFAULT NULL COMMENT '续重费用',
  `enable` bigint(11) DEFAULT NULL COMMENT '是否启用 0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicdata_express
-- ----------------------------

-- ----------------------------
-- Table structure for `publicdata_express_district`
-- ----------------------------
DROP TABLE IF EXISTS `publicdata_express_district`;
CREATE TABLE `publicdata_express_district` (
  `id` bigint(11) NOT NULL,
  `expressId` bigint(11) DEFAULT NULL COMMENT '快递公司id',
  `firstPrice` double(11,2) DEFAULT NULL COMMENT '首重重量',
  `continuedPrice` double(11,2) DEFAULT NULL COMMENT '续重重量',
  `province` varchar(11) DEFAULT NULL COMMENT '省份',
  `city` varchar(11) DEFAULT NULL COMMENT '城市',
  `district` varchar(11) DEFAULT NULL COMMENT '地区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicdata_express_district
-- ----------------------------

-- ----------------------------
-- Table structure for `publicdata_neighbourhood`
-- ----------------------------
DROP TABLE IF EXISTS `publicdata_neighbourhood`;
CREATE TABLE `publicdata_neighbourhood` (
  `id` bigint(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `province` varchar(100) DEFAULT NULL COMMENT '省',
  `city` varchar(100) DEFAULT NULL COMMENT '城市',
  `district` varchar(100) DEFAULT NULL COMMENT '地区',
  `longitude` varchar(100) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(100) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicdata_neighbourhood
-- ----------------------------

-- ----------------------------
-- Table structure for `publicdata_province`
-- ----------------------------
DROP TABLE IF EXISTS `publicdata_province`;
CREATE TABLE `publicdata_province` (
  `id` bigint(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '省',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省';

-- ----------------------------
-- Records of publicdata_province
-- ----------------------------

-- ----------------------------
-- Table structure for `publicdata_image_information`
-- ----------------------------

DROP TABLE IF EXISTS `publicdata_image_information`;
CREATE TABLE `publicdata_image_information` (
  `id` bigint(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `publicdata_province`
-- ----------------------------
