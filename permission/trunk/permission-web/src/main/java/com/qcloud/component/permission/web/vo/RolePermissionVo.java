package com.qcloud.component.permission.web.vo;

public class RolePermissionVo {

    private long   rolePermissionId;

    private long   roleId;

    private String roleName;

    private long   permissionId;

    private String checked;

    private int    permissionType;

    public long getRoleId() {

        return roleId;
    }

    public void setRoleId(long roleId) {

        this.roleId = roleId;
    }

    public long getPermissionId() {

        return permissionId;
    }

    public void setPermissionId(long permissionId) {

        this.permissionId = permissionId;
    }

    public String getChecked() {

        return checked;
    }

    public void setChecked(String checked) {

        this.checked = checked;
    }

    public String getRoleName() {

        return roleName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }


    public int getPermissionType() {

        return permissionType;
    }

    public void setPermissionType(int permissionType) {

        this.permissionType = permissionType;
    }

    
    public long getRolePermissionId() {
    
        return rolePermissionId;
    }

    
    public void setRolePermissionId(long rolePermissionId) {
    
        this.rolePermissionId = rolePermissionId;
    }
}
