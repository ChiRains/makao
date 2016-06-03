DROP TABLE IF EXISTS `metadata_renewal`;
CREATE TABLE `metadata_renewal` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`carOwnerId` bigint(11) DEFAULT NULL COMMENT '车主',
	`type` int(2) DEFAULT NULL COMMENT '类别',
	`clerkType` int(2) DEFAULT NULL COMMENT '类型',
	`applyTime` varchar(20) DEFAULT NULL COMMENT '申请时间',
	`progressState` tinyint(4) DEFAULT NULL COMMENT '流程状态',
	`vehicle` varchar(200) DEFAULT NULL COMMENT 'vehicle',
	`drivers` varchar(200) DEFAULT NULL COMMENT 'drivers',
	`progressType` int(2) DEFAULT NULL COMMENT '流程类型',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='续期申请';
