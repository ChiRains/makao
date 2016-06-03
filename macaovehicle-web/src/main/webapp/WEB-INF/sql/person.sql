DROP TABLE IF EXISTS `metadata_person`;
CREATE TABLE `metadata_person` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`name` varchar(255) DEFAULT NULL COMMENT '姓名',
	`idcardNumber` varchar(255) DEFAULT NULL COMMENT '身份证号',
	`sex` int(2) DEFAULT NULL COMMENT '性别',
	`birthDay` varchar(255) DEFAULT NULL COMMENT '出生日期',
	`phone` varchar(100) DEFAULT NULL COMMENT '联系电话',
	`address` varchar(255) DEFAULT NULL COMMENT '住址',
	`idcardFace` varchar(255) DEFAULT NULL COMMENT '身份证正面',
	`idCardBack` varchar(255) DEFAULT NULL COMMENT '身份证背面',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`certificateType` tinyint(4) DEFAULT NULL COMMENT '证件类型（1护照  2：回乡证）',
	`certificateNo` varchar(50) DEFAULT NULL COMMENT '证件号码',
	`certificateDate` varchar(50) DEFAULT NULL COMMENT '其他证件有效期',
	`certificateUrl` varchar(255) DEFAULT NULL COMMENT '证件图片',
	`idCardValidTime` varchar(200) DEFAULT NULL COMMENT '身份证有效期',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人信息';
