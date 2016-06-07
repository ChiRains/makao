DROP TABLE IF EXISTS `parameter_param`;
CREATE TABLE `parameter_param` (
  `id` bigint(11) NOT NULL,
  `name` varchar(200) NOT NULL COMMENT '参数名称',
  `code` varchar(50) NOT NULL COMMENT '参数编码',
  `type` int(2) DEFAULT NULL COMMENT '参数类型',
  `enable` int(2) DEFAULT NULL COMMENT '是否启用',
  `value` varchar(2000) DEFAULT NULL COMMENT '参数值',
  `desc` varchar(200) DEFAULT NULL COMMENT '参数描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `permission_account`
-- ----------------------------
DROP TABLE IF EXISTS `permission_account`;
CREATE TABLE `permission_account` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '账号名称',
  `code` varchar(50) DEFAULT NULL COMMENT '账号代码 最好使用手机号',
  `enable` int(2) DEFAULT NULL COMMENT '账号是否启用',
  `orgId` bigint(11) DEFAULT NULL COMMENT '组织',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_account
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_account_role`
-- ----------------------------
DROP TABLE IF EXISTS `permission_account_role`;
CREATE TABLE `permission_account_role` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `accountId` bigint(11) DEFAULT NULL COMMENT '帐号Id',
  `roleId` bigint(11) DEFAULT NULL COMMENT '角色Id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色帐号关联';

-- ----------------------------
-- Records of permission_account_role
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `permission_catalog`;
CREATE TABLE `permission_catalog` (
  `id` bigint(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `order` int(3) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_menu`
-- ----------------------------
DROP TABLE IF EXISTS `permission_menu`;
CREATE TABLE `permission_menu` (
  `id` bigint(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `order` int(3) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `catalogId` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_organization`
-- ----------------------------
DROP TABLE IF EXISTS `permission_organization`;
CREATE TABLE `permission_organization` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '组织名称',
  `parentId` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_organization
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission_permission`;
CREATE TABLE `permission_permission` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '权限点名称',
  `type` int(2) DEFAULT NULL COMMENT '权限点类型',
  `targetId` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='权限点';

-- ----------------------------
-- Records of permission_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_resources`
-- ----------------------------
DROP TABLE IF EXISTS `permission_resources`;
CREATE TABLE `permission_resources` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '资源名称',
  `code` varchar(50) DEFAULT NULL COMMENT '资源代号',
  `uri` varchar(200) DEFAULT NULL COMMENT '请求地址',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='资源';

-- ----------------------------
-- Records of permission_resources
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_role`
-- ----------------------------
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `desc` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `parentGrantRoleId` bigint(11) DEFAULT NULL COMMENT '可给当前角色授权的父角色ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of permission_role
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission_role_permission`;
CREATE TABLE `permission_role_permission` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `permissionId` bigint(11) DEFAULT NULL COMMENT '权限点Id',
  `roleId` bigint(11) DEFAULT NULL COMMENT '角色Id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色帐号关联';

-- ----------------------------
-- Records of permission_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `pirates_admin`
-- ----------------------------
DROP TABLE IF EXISTS `pirates_admin`;
CREATE TABLE `pirates_admin` (
  `id` bigint(11) NOT NULL,
  `account` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `enable` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of pirates_admin
-- ----------------------------

-- ----------------------------
--  Table structure for `pirates_autoId`
-- ----------------------------
DROP TABLE IF EXISTS `pirates_autoId`;
CREATE TABLE `pirates_autoId` (
  `id` bigint(11) NOT NULL,
  `key` varchar(100) DEFAULT NULL,
  `value` bigint(11) DEFAULT NULL,
  `version` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `pirates_autoId`
-- ----------------------------

-- ----------------------------
-- Table structure for `pirates_unique_code`
-- ----------------------------
DROP TABLE IF EXISTS `pirates_unique_code`;
CREATE TABLE `pirates_unique_code` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `key` varchar(255) DEFAULT NULL COMMENT 'key',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='统一编码';

-- ----------------------------
-- Records of pirates_unique_code
-- ----------------------------

-- ----------------------------
-- Table structure for `pirates_unique_code_max_number`
-- ----------------------------
DROP TABLE IF EXISTS `pirates_unique_code_max_number`;
CREATE TABLE `pirates_unique_code_max_number` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `number` bigint(11) NOT NULL COMMENT '最大数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='统一编码最大数';

-- ----------------------------
-- Records of pirates_unique_code_max_number
-- ----------------------------