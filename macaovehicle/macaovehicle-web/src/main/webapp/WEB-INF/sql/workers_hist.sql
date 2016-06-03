DROP TABLE IF EXISTS `metadata_workers_hist`;
CREATE TABLE `metadata_workers_hist` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`company` varchar(255) DEFAULT NULL COMMENT '单位',
	`fixedLine` varchar(100) DEFAULT NULL COMMENT '单位电话',
	`phone` varchar(100) DEFAULT NULL COMMENT '联系电话',
	`consignee` varchar(100) DEFAULT NULL COMMENT '联系人',
	`position` varchar(100) DEFAULT NULL COMMENT '职务',
	`workCertificate` varchar(255) DEFAULT NULL COMMENT '工作证明',
	`address` varchar(255) DEFAULT NULL COMMENT '单位地址',
	`code` varchar(100) DEFAULT NULL COMMENT '公司代码',
	`time` varchar(255) DEFAULT NULL COMMENT '成立时间',
	`entryTime` varchar(255) DEFAULT NULL COMMENT '加入时间',
	`contractUrl` varchar(255) DEFAULT NULL COMMENT '劳务合同图片',
	`insuranceFeeUrl` varchar(255) DEFAULT NULL COMMENT '参保费用证明图片',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='务工单位-备份表';
