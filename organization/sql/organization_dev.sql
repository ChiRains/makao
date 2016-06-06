/*
Navicat MySQL Data Transfer

Source Server         : 10.10.11.60
Source Server Version : 50616
Source Host           : 10.10.11.60:3306
Source Database       : organization_dev

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-12-06 05:43:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `organization_clerk`
-- ----------------------------
DROP TABLE IF EXISTS `organization_clerk`;
CREATE TABLE `organization_clerk` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `jobEmail` varchar(200) DEFAULT NULL COMMENT '工作邮箱',
  `idCard` varchar(50) DEFAULT NULL COMMENT '身份证',
  `sex` int(2) DEFAULT NULL,
  `headImage` varchar(200) DEFAULT NULL COMMENT '头像',
  `enable` int(2) DEFAULT NULL COMMENT '是否启用,在职(0否，1是)',
  `accountGroup` varchar(100) DEFAULT NULL COMMENT '账号组别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职员';

-- ----------------------------
-- Records of organization_clerk
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_clerk_post`
-- ----------------------------
DROP TABLE IF EXISTS `organization_clerk_post`;
CREATE TABLE `organization_clerk_post` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `clerkId` bigint(11) NOT NULL COMMENT '职员id',
  `postId` bigint(11) NOT NULL COMMENT '岗位id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职员岗位';

-- ----------------------------
-- Records of organization_clerk_post
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_department`
-- ----------------------------
DROP TABLE IF EXISTS `organization_department`;
CREATE TABLE `organization_department` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `parentId` bigint(11) DEFAULT NULL,
  `bsid` varchar(200) DEFAULT NULL COMMENT '树编码',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `manager` bigint(11) DEFAULT NULL COMMENT '经理',
  `displayName` varchar(200) DEFAULT NULL COMMENT '显示级层名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

-- ----------------------------
-- Records of organization_department
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_department_clerk`
-- ----------------------------
DROP TABLE IF EXISTS `organization_department_clerk`;
CREATE TABLE `organization_department_clerk` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `departmentId` bigint(11) NOT NULL COMMENT '部门id',
  `clerkId` bigint(11) NOT NULL COMMENT '职员id',
  `type` tinyint(2) DEFAULT NULL COMMENT '类型: 1.所属部门  2.解调部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门职员关系';

-- ----------------------------
-- Records of organization_department_clerk
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_post`
-- ----------------------------
DROP TABLE IF EXISTS `organization_post`;
CREATE TABLE `organization_post` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位';

-- ----------------------------
-- Records of organization_post
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_post_role`
-- ----------------------------
DROP TABLE IF EXISTS `organization_post_role`;
CREATE TABLE `organization_post_role` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `roleId` bigint(11) NOT NULL COMMENT '角色id',
  `postId` bigint(11) NOT NULL COMMENT '岗位id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位角色';

-- ----------------------------
-- Records of organization_post_role
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_superior`
-- ----------------------------
DROP TABLE IF EXISTS `organization_superior`;
CREATE TABLE `organization_superior` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `clerkId` bigint(11) NOT NULL COMMENT '职员id',
  `leaderId` bigint(11) NOT NULL COMMENT '上级领导id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职员上下级关系';

-- ----------------------------
-- Records of organization_superior
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_usergroup`
-- ----------------------------
DROP TABLE IF EXISTS `organization_usergroup`;
CREATE TABLE `organization_usergroup` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization_usergroup
-- ----------------------------

-- ----------------------------
-- Table structure for `organization_usergroup_user`
-- ----------------------------
DROP TABLE IF EXISTS `organization_usergroup_user`;
CREATE TABLE `organization_usergroup_user` (
  `id` bigint(20) NOT NULL,
  `groupId` bigint(20) DEFAULT NULL COMMENT '用户组ID',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization_usergroup_user
-- ----------------------------
