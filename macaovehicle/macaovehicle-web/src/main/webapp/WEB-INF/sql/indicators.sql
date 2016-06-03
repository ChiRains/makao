DROP TABLE IF EXISTS `metadata_indicators`;
CREATE TABLE `metadata_indicators` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`indicatorsNo` varchar(255) DEFAULT NULL COMMENT '指标号',
	`userName` varchar(20) DEFAULT NULL COMMENT '指标所有人',
	`validityPeriod` varchar(50) DEFAULT NULL COMMENT '有效期',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='指标信息';
