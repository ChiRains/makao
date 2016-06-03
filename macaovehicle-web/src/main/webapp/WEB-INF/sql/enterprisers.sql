DROP TABLE IF EXISTS `metadata_enterprisers`;
CREATE TABLE `metadata_enterprisers` (
	`id` bigint(11) DEFAULT NULL COMMENT 'id',
	`masterId` bigint(11) DEFAULT NULL COMMENT 'masterId',
	`company` varchar(255) DEFAULT NULL COMMENT '公司名称',
	`code` varchar(100) DEFAULT NULL COMMENT '公司代码',
	`operate` varchar(255) DEFAULT NULL COMMENT '经营范围',
	`scale` varchar(255) DEFAULT NULL COMMENT '企业规模',
	`represent` varchar(255) DEFAULT NULL COMMENT '法人',
	`phone` varchar(100) DEFAULT NULL COMMENT '联系电话',
	`address` varchar(255) DEFAULT NULL COMMENT '公司地址',
	`time` varchar(255) DEFAULT NULL COMMENT '成立时间',
	`license` varchar(255) DEFAULT NULL COMMENT '营业执照',
	`operatingPeriod` datetime DEFAULT NULL COMMENT '经营期限',
	`organs` varchar(50) DEFAULT NULL COMMENT '登记机关',
	`contacts` varchar(50) DEFAULT NULL COMMENT '企业联系人',
	`paymentUrl` varchar(255) DEFAULT NULL COMMENT '缴费证明图片',
	`commitmentUrl` varchar(255) DEFAULT NULL COMMENT '缴费承诺书图片',
	`representID` varchar(255) DEFAULT NULL COMMENT '法人代表身份证号码',
	`positiveUrl` varchar(255) DEFAULT NULL COMMENT '身份证正面',
	`oppositeUrl` varchar(255) DEFAULT NULL COMMENT '身份证反面',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资公司';
