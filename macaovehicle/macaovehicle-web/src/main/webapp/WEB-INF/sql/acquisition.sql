DROP TABLE IF EXISTS `metadata_acquisition`;
CREATE TABLE `metadata_acquisition` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`application` varchar(50) DEFAULT NULL COMMENT '购地用途',
	`deadline` int(11) DEFAULT NULL COMMENT '购地用地年限',
	`buyTime` datetime DEFAULT NULL COMMENT '购买日期',
	`contractUrl` varchar(255) DEFAULT NULL COMMENT '用地出让权使用合同图片',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购地表';
