package com.qcloud.component.permission;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.permission.entity.RoleEntity;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.model.RolePermission;
import com.qcloud.component.permission.service.RolePermissionService;
import com.qcloud.component.permission.service.RoleService;

@Service
public class RoleClientImpl implements RoleClient {

    @Autowired
    private RoleService           roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<QRole> listRoles() {

        List<QRole> list = new ArrayList<QRole>();
        List<Role> roles = roleService.list();
        for (Role role : roles) {
            RoleEntity re = new RoleEntity();
            re.setId(role.getId());
            re.setName(role.getName());
            re.setDesc(role.getDesc());
            re.setRolePermissions(rolePermissionService.list(role.getId()));
            list.add(re);
        }
        return list;
    }

    @Override
    public Long registerRole(String name, String desc, long parentGrantRoleId) {

        Role role = new Role();
        role.setName(name);
        role.setDesc(desc);
        role.setParentGrantRoleId(parentGrantRoleId);
        roleService.add(role);
        return role.getId();
    }

    @Override
    public Long grantRolePermission(long permissionId, long roleId) {

        RolePermission rolePermission = new RolePermission();
        rolePermission.setPermissionId(permissionId);
        rolePermission.setRoleId(roleId);
        rolePermissionService.add(rolePermission);
        return rolePermission.getId();
    }

    @Override
    public boolean unbindRolePermission(long permissionId, long roleId) {

        return rolePermissionService.delete(permissionId, roleId);
    }
}
