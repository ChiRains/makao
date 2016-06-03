DROP TABLE IF EXISTS `metadata_temporaryPlate`;
CREATE TABLE `metadata_temporaryPlate` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`platNumber` varchar(200) DEFAULT NULL COMMENT '临时车辆号牌',
	`validityDate` varchar(50) DEFAULT NULL COMMENT '号牌有效期',
	`effectDate` varchar(50) DEFAULT NULL COMMENT '号牌生效日期',
	`platedNumber` varchar(20) DEFAULT NULL COMMENT '曾用车辆号牌',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='临时号牌';
