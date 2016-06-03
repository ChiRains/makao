DROP TABLE IF EXISTS `metadata_gwhyjb_notion_hist`;
CREATE TABLE `metadata_gwhyjb_notion_hist` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`clerk` bigint(11) DEFAULT NULL COMMENT '审批人',
	`clerkName` varchar(100) DEFAULT NULL COMMENT '审批人姓名',
	`department` bigint(11) DEFAULT NULL COMMENT '审批人部门',
	`departmentName` varchar(100) DEFAULT NULL COMMENT '审批人部门名称',
	`post` bigint(11) DEFAULT NULL COMMENT '审批人岗位',
	`postName` varchar(100) DEFAULT NULL COMMENT '审批人岗位名称',
	`workitem` varchar(100) DEFAULT NULL COMMENT '流程任务',
	`workitemName` varchar(100) DEFAULT NULL COMMENT '流程任务名称',
	`content` varchar(250) DEFAULT NULL COMMENT '审批内容',
	`result` integer(3) DEFAULT NULL COMMENT '审批结果',
	`time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '审批时间',
	`task` bigint(11) DEFAULT NULL COMMENT '任务',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管委会意见表-意见子表备份表';
