package com.qcloud.component.permission.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.permission.exception.PermissionException;
import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.model.RolePermission;
import com.qcloud.component.permission.service.AccountRoleService;
import com.qcloud.component.permission.service.AccountService;
import com.qcloud.component.permission.service.AuthenticationService;
import com.qcloud.component.permission.service.PermissionService;
import com.qcloud.component.permission.service.RolePermissionService;
import com.qcloud.component.permission.service.RoleService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	AccountService accountService;
	@Autowired
	AccountRoleService accountRoleService;
	@Autowired
	RoleService roleService;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	PermissionService permissionService;

	@Override
	public List<Permission> listPermissions(String code) {
		Account account = accountService.getByCode(code);
		if (account == null) {
			return new ArrayList<Permission>(0);
		}
		List<AccountRole> arList = accountRoleService.list(account.getId());
		List<Long> roleKeyList = new ArrayList<Long>();
		for (AccountRole accountRole : arList) {
			roleKeyList.add(accountRole.getRoleId());
		}
		List<RolePermission> rpList = rolePermissionService.list(roleKeyList
				.toArray(new Long[roleKeyList.size()]));
		List<Long> permissionKeyList = new ArrayList<Long>();
		for (RolePermission rolePermission : rpList) {
			permissionKeyList.add(rolePermission.getPermissionId());
		}
		List<Permission> permissionList = permissionService
				.list(permissionKeyList);
		return permissionList;
	}

	@Override
	public boolean grant(Long accountId, Long roleId) {
		Account account = accountService.get(accountId);
		if (account == null) {
			throw new PermissionException("账号不存在." + accountId);
		}
		Role role = roleService.get(roleId);
		if (role == null) {
			throw new PermissionException("角色不存在." + roleId);
		}
		AccountRole accountRole = new AccountRole();
		accountRole.setAccountId(accountId);
		accountRole.setRoleId(roleId);
		return accountRoleService.add(accountRole);
	}
}
