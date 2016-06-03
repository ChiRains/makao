DROP TABLE IF EXISTS `metadata_supplement`;
CREATE TABLE `metadata_supplement` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`carOwnerId` bigint(11) DEFAULT NULL COMMENT '车主',
	`type` int(2) DEFAULT NULL COMMENT '类别',
	`clerkType` int(2) DEFAULT NULL COMMENT '类型',
	`applyTime` varchar(20) DEFAULT NULL COMMENT '申请时间',
	`progressState` tinyint(4) DEFAULT NULL COMMENT '流程状态',
	`vehicle` varchar(200) DEFAULT NULL COMMENT 'vehicle',
	`drivers` varchar(200) DEFAULT NULL COMMENT 'drivers',
	`progressType` int(2) DEFAULT NULL COMMENT '流程类型',
	`platNumber` varchar(50) DEFAULT NULL COMMENT '临时号牌',
	`validityDate` varchar(50) DEFAULT NULL COMMENT '入境有效期',
	`effectDate` varchar(50) DEFAULT NULL COMMENT '挂失时间',
	`platedNumber` varchar(500) DEFAULT NULL COMMENT '曾用临时号牌',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='补办临时号牌';
