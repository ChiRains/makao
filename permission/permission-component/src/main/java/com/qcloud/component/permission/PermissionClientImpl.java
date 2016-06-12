package com.qcloud.component.permission;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.permission.entity.PermissionEntity;
import com.qcloud.component.permission.entity.RoleEntity;
import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.model.Resources;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.model.key.TypeEnum.PermissionType;
import com.qcloud.component.permission.service.AccountRoleService;
import com.qcloud.component.permission.service.AccountService;
import com.qcloud.component.permission.service.AuthenticationService;
import com.qcloud.component.permission.service.MenuService;
import com.qcloud.component.permission.service.PermissionService;
import com.qcloud.component.permission.service.ResourcesService;
import com.qcloud.component.permission.service.RolePermissionService;
import com.qcloud.component.permission.service.RoleService;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class PermissionClientImpl implements PermissionClient {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    MenuService           menuService;

    @Autowired
    ResourcesService      resourcesService;

    @Autowired
    RoleService           roleService;

    @Autowired
    AccountService        accountService;

    @Autowired
    AccountRoleService    accountRoleService;

    @Autowired
    PermissionService     permissionService;

    @Autowired
    RolePermissionService rolePermissionService;

    @Override
    public boolean hasPermission(String account, String uri) {

        List<Permission> permissionList = authenticationService.listPermissions(account);
        if (CollectionUtils.isNotEmpty(permissionList)) {
            List<Long> menuKeyList = new ArrayList<Long>();
            List<Long> resourcesKeyList = new ArrayList<Long>();
            for (Permission permission : permissionList) {
                if (PermissionType.P1.getKey() == permission.getType()) {
                    menuKeyList.add(permission.getTargetId());
                } else if (PermissionType.P2.getKey() == permission.getType()) {
                    resourcesKeyList.add(permission.getTargetId());
                }
            }
            List<Menu> menuList = menuService.list(menuKeyList);
            for (Menu menu : menuList) {
                if (menu != null && uri.equals(menu.getUrl())) {
                    return true;
                }
            }
            List<Resources> resourcesList = resourcesService.list(resourcesKeyList);
            for (Resources resources : resourcesList) {
                if (resources != null && uri.equals(resources.getUri())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<QRole> listRoleByAccount(String code) {

        Account account = accountService.getByCode(code);
        if (account == null) {
            return new ArrayList<QRole>(0);
        }
        List<AccountRole> arList = accountRoleService.list(account.getId());
        List<Long> roleKeyList = new ArrayList<Long>();
        for (AccountRole accountRole : arList) {
            roleKeyList.add(accountRole.getRoleId());
        }
        List<QRole> list = new ArrayList<QRole>();
        for (Long key : roleKeyList) {
            list.add(getRole(key));
        }
        return list;
    }

    @Override
    public boolean grant(Long accountId, Long roleId) {

        return authenticationService.grant(accountId, roleId);
    }

    @Override
    public boolean isRoleExist(Long roleId) {

        return roleService.get(roleId) != null;
    }

    @Override
    public List<QRole> listRole() {

        List<QRole> list = new ArrayList<QRole>();
        List<Role> roleList = roleService.list();
        for (Role role : roleList) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setDesc(role.getDesc());
            roleEntity.setId(role.getId());
            roleEntity.setName(role.getName());
            roleEntity.setEnable(role.getEnable());
            roleEntity.setRolePermissions(rolePermissionService.list(role.getId()));
            list.add(roleEntity);
        }
        return list;
    }

    @Override
    public QRole getRole(Long id) {

        Role role = roleService.get(id);
        AssertUtil.assertNotNull(role, "角色不存在.");
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setDesc(role.getDesc());
        roleEntity.setId(role.getId());
        roleEntity.setName(role.getName());
        roleEntity.setEnable(role.getEnable());
        roleEntity.setRolePermissions(rolePermissionService.list(role.getId()));
        return roleEntity;
    }

    @Override
    public QPermission getPermission(int type, long targetId) {

        Permission permission = permissionService.getByTargetId(type, targetId);
        AssertUtil.assertNotNull(permission, "资源对应的权限不存在." + targetId);
        PermissionEntity entity = new PermissionEntity();
        entity.setId(permission.getId());
        entity.setType(permission.getType());
        entity.setName(permission.getName());
        entity.setTargetId(permission.getTargetId());
        return entity;
    }

    @Override
    public QPermission getPermission(long id) {

        Permission permission = permissionService.get(id);
        AssertUtil.assertNotNull(permission, "permission权限不存在." + id);
        PermissionEntity entity = new PermissionEntity();
        entity.setId(permission.getId());
        entity.setType(permission.getType());
        entity.setName(permission.getName());
        entity.setTargetId(permission.getTargetId());
        return entity;
    }

    @Override
    public boolean unbindAccountGrant(long accountId) {

        return accountRoleService.unbindAccountGrant(accountId);
    }
}