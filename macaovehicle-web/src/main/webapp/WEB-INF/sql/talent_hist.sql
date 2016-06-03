DROP TABLE IF EXISTS `metadata_talent_hist`;
CREATE TABLE `metadata_talent_hist` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`company` varchar(255) DEFAULT NULL COMMENT 'company',
	`fixedLine` varchar(255) DEFAULT NULL COMMENT 'fixedLine',
	`address` varchar(255) DEFAULT NULL COMMENT 'address',
	`phone` varchar(255) DEFAULT NULL COMMENT 'phone',
	`consignee` varchar(255) DEFAULT NULL COMMENT 'consignee',
	`position` varchar(255) DEFAULT NULL COMMENT 'position',
	`workCertificate` varchar(255) DEFAULT NULL COMMENT 'workCertificate',
	`code` varchar(255) DEFAULT NULL COMMENT 'code',
	`time` varchar(255) DEFAULT NULL COMMENT 'time',
	`entryTime` varchar(255) DEFAULT NULL COMMENT 'entryTime',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`contractUrl` varchar(255) DEFAULT NULL COMMENT '劳务合同图片',
	`insuranceFeeUrl` varchar(255) DEFAULT NULL COMMENT '参保费用证明图片',
	`deptCertificateUrl` varchar(255) DEFAULT NULL COMMENT '管委会人事部证明图片',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人才表-备份表';
