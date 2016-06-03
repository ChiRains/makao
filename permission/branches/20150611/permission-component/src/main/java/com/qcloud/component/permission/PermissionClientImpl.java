package com.qcloud.component.permission;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.model.Resources;
import com.qcloud.component.permission.model.key.TypeEnum.PermissionType;
import com.qcloud.component.permission.service.AuthenticationService;
import com.qcloud.component.permission.service.MenuService;
import com.qcloud.component.permission.service.ResourcesService;
import com.qcloud.component.permission.service.RoleService;

@Service
public class PermissionClientImpl implements PermissionClient {
	@Autowired
	AuthenticationService authenticationService;
	@Autowired
	MenuService menuService;
	@Autowired
	ResourcesService resourcesService;
	@Autowired
	RoleService roleService;

	@Override
	public boolean hasPermission(String account, String uri) {
		List<Permission> permissionList = authenticationService
				.listPermissions(account);
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
			List<Resources> resourcesList = resourcesService
					.list(resourcesKeyList);
			for (Resources resources : resourcesList) {
				if (resources != null && uri.equals(resources.getUri())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean grant(Long accountId, Long roleId) {
		return authenticationService.grant(accountId, roleId);
	}

	@Override
	public boolean isRoleExist(Long roleId) {
		return roleService.get(roleId) != null;
	}
}