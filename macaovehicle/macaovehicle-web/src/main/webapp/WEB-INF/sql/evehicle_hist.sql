DROP TABLE IF EXISTS `metadata_evehicle_hist`;
CREATE TABLE `metadata_evehicle_hist` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`faceImage` varchar(200) DEFAULT NULL COMMENT '车辆正面',
	`bottomImage` varchar(200) DEFAULT NULL COMMENT '车辆底部',
	`leftfaceImage` varchar(200) DEFAULT NULL COMMENT '车辆左侧45度（前）',
	`rightfaceImage` varchar(200) DEFAULT NULL COMMENT '车辆右侧45度（前）',
	`leftbackImage` varchar(200) DEFAULT NULL COMMENT '车辆左侧45度（后）',
	`rightbackImage` varchar(200) DEFAULT NULL COMMENT '车辆右侧45度（后）',
	`safetyImage` varchar(200) DEFAULT NULL COMMENT '安全技术证明报告',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='验车信息-备份表';
