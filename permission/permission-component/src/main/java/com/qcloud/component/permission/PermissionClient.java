package com.qcloud.component.permission;

import java.util.List;

public interface PermissionClient {

    public static final String NO_GRANT_ACCOUNT_CODES_KEY       = "permission-no-grant-codes-key";

    public static final String NO_GRANT_ACCOUNT_CODES_KEY_SPLIT = ";";

    boolean hasPermission(String account, String uri);

    List<QRole> listRoleByAccount(String account);

    boolean grant(Long accountId, Long roleId);

    boolean isRoleExist(Long roleId);

    List<QRole> listRole();

    QRole getRole(Long id);

    QPermission getPermission(int type, long targetId);

    QPermission getPermission(long id);
}