package com.qcloud.component.permission;

import java.util.List;

public interface RoleClient {

    List<QRole> listRoles();

    Long registerRole(String name, String desc, long parentGrantRoleId);

    Long grantRolePermission(long permissionId, long roleId);

    boolean unbindRolePermission(long permissionId, long roleId);
}
