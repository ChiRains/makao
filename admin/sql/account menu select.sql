select m.*,c.name from permission_menu m,permission_catalog c where m.catalogId = c.id AND
m.id in (select p.targetId from permission_permission p,permission_role_permission rp,permission_account_role ar,permission_account ac 
where p.type = 1 and p.id = rp.permissionId and rp.roleId = ar.roleId and ar.accountId = ac.id and ac.code = 'super-13427775936');
