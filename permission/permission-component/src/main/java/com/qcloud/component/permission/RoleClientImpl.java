package com.qcloud.component.permission;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.permission.entity.RoleEntity;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.model.RolePermission;
import com.qcloud.component.permission.model.key.TypeEnum.RoleEnableType;
import com.qcloud.component.permission.service.RolePermissionService;
import com.qcloud.component.permission.service.RoleService;
import com.qcloud.pirates.util.AssertUtil;

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
            re.setEnable(role.getEnable());
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
        role.setEnable(RoleEnableType.ENABLE.getKey());
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

    @Override
    public boolean setEnable(long id, RoleEnableType enable) {

        Role role = roleService.get(id);
        AssertUtil.assertNotNull(role, "角色不存在." + id);
        role.setEnable(enable.getKey());
        return roleService.update(role);
    }
}
