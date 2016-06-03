package com.qcloud.component.permission;

public interface PermissionClient {

	public static final String NO_GRANT_ACCOUNT_CODES_KEY = "permission-no-grant-codes-key";

	public static final String NO_GRANT_ACCOUNT_CODES_KEY_SPLIT = ";";

	boolean hasPermission(String account, String uri);

	boolean grant(Long accountId, Long roleId);

	boolean isRoleExist(Long roleId);
}