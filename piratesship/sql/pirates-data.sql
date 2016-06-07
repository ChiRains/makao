INSERT INTO `permission_catalog` VALUES ('1010012000000001', '系统设置', '10',1);

INSERT INTO `permission_menu` VALUES ('1010012000000001', '管理员管理', 'admin', '10', 'admin/list', '1010012000000001');
INSERT INTO `permission_menu` VALUES ('1010012000000002', '授权管理', 'grant', '20', 'grant/list', '1010012000000001');
INSERT INTO `permission_menu` VALUES ('1010012000000003', '参数管理', 'parameter', '30', 'admin/param/list', '1010012000000001');
INSERT INTO `permission_menu` VALUES ('1010012000000005', '个人档案', 'adminPersonalInfo', '50', 'admin/toAdminPersonalInfo', '1010012000000001');

INSERT INTO `permission_permission` VALUES ('1010012000000001', '管理员管理', '1', '1010012000000001');
INSERT INTO `permission_permission` VALUES ('1010012000000002', '授权管理', '1', '1010012000000002');
INSERT INTO `permission_permission` VALUES ('1010012000000003', '参数管理', '1', '1010012000000003');
INSERT INTO `permission_permission` VALUES ('1010012000000005', '个人档案', '1', '1010012000000005');

INSERT INTO `permission_role` VALUES ('1010012000000001', '超级管理员', '超级管理员', '-1');
INSERT INTO `permission_role` VALUES ('1010012000000002', '管理员', '管理员', '1010012000000001');

INSERT INTO `permission_role_permission` VALUES ('1010012000000001', '1010012000000001', '1010012000000001');
INSERT INTO `permission_role_permission` VALUES ('1010012000000002', '1010012000000002', '1010012000000001');
INSERT INTO `permission_role_permission` VALUES ('1010012000000003', '1010012000000003', '1010012000000001');
INSERT INTO `permission_role_permission` VALUES ('1010012000000006', '1010012000000002', '1010012000000002');
INSERT INTO `permission_role_permission` VALUES ('1010012000000008', '1010012000000005', '1010012000000002');

INSERT INTO `pirates_autoid` VALUES ('1', 'pirates_autoId', '10000', '1');
