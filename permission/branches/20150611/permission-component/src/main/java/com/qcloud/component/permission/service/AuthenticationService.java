package com.qcloud.component.permission.service;

import java.util.List;

import com.qcloud.component.permission.model.Permission;

public interface AuthenticationService {

	List<Permission> listPermissions(String accountCode);

	boolean grant(Long accountId, Long roleId);
}
