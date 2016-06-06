package com.qcloud.component.permission.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.model.RolePermission;
import com.qcloud.component.permission.service.RolePermissionService;
import com.qcloud.component.permission.web.handler.RolePermissionHandler;
import com.qcloud.component.permission.web.vo.RolePermissionVo;

@Component
public class RolePermissionHandlerImpl implements RolePermissionHandler {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<RolePermissionVo> toVOList(List<Role> list, Permission permission) {
        List<RolePermissionVo> vos=new ArrayList<RolePermissionVo>();
        for (Role role : list) {
            RolePermissionVo vo=new RolePermissionVo();
            vo.setRoleId(role.getId());
            vo.setRoleName(role.getName());
            vo.setPermissionId(permission.getId());
            vo.setPermissionType(permission.getType());
            List<RolePermission> rolePermissions = rolePermissionService.list(role.getId());
            for (RolePermission rolePer : rolePermissions) {
                if(rolePer.getPermissionId()==permission.getId()){
                    vo.setChecked("checked");
                    vo.setRolePermissionId(rolePer.getId());
                }
            }
            vos.add(vo);
        }
        return vos;
    }
}
