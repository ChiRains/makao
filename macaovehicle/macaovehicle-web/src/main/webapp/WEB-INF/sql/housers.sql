DROP TABLE IF EXISTS `metadata_housers`;
CREATE TABLE `metadata_housers` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`property` varchar(255) DEFAULT NULL COMMENT '房产',
	`application` varchar(255) DEFAULT NULL COMMENT '房产用途',
	`ways` varchar(255) DEFAULT NULL COMMENT '取得方式',
	`situation` varchar(100) DEFAULT NULL COMMENT '共有情况',
	`code` varchar(100) DEFAULT NULL COMMENT '房屋编号',
	`time` varchar(255) DEFAULT NULL COMMENT '登记日期',
	`located` varchar(255) DEFAULT NULL COMMENT '地址',
	`structure` varchar(100) DEFAULT NULL COMMENT '结构',
	`floor` int(3) DEFAULT NULL COMMENT '层数',
	`buildArea` double(20,2) DEFAULT NULL COMMENT '建筑面积',
	`totalArea` double(20,2) DEFAULT NULL COMMENT '套内面积',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`licenseNo` varchar(255) DEFAULT NULL COMMENT '房产证编号',
	`licenseUrl` varchar(255) DEFAULT NULL COMMENT '房产证图片',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房产';
