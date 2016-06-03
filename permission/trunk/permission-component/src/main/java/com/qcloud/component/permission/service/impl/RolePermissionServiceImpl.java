package com.qcloud.component.permission.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.permission.dao.RolePermissionDao;
import com.qcloud.component.permission.model.RolePermission;
import com.qcloud.component.permission.service.RolePermissionService;
import com.qcloud.pirates.data.Page;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private AutoIdGenerator   autoIdGenerator;

    private String            key = "permission_role_permission";

    @Override
    public boolean add(RolePermission rolePermission) {

        long id = autoIdGenerator.get(key);
        rolePermission.setId(id);
        return rolePermissionDao.add(rolePermission);
    }

    @Override
    public RolePermission get(Long id) {

        return rolePermissionDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return rolePermissionDao.delete(id);
    }

    @Override
    public boolean update(RolePermission rolePermission) {

        return rolePermissionDao.update(rolePermission);
    }

    @Override
    public Page<RolePermission> page(int start, int count) {

        return rolePermissionDao.page(start, count);
    }

    @Override
    public List<RolePermission> list(Long... roleIds) {

        if (roleIds == null) {
            return new ArrayList<RolePermission>(0);
        }
        List<RolePermission> list = new ArrayList<RolePermission>();
        for (Long key : roleIds) {
            List<RolePermission> oneList = rolePermissionDao.list(key);
            if (CollectionUtils.isNotEmpty(oneList)) {
                list.addAll(oneList);
            }
        }
        return list;
    }
}
