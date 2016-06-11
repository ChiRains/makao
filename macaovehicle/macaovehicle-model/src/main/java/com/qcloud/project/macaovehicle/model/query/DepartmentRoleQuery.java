package com.qcloud.project.macaovehicle.model.query;

public class DepartmentRoleQuery {

    private long roleId;

    private long departmentId;

    public DepartmentRoleQuery() {

    }

    public long getRoleId() {

        return roleId;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setRoleId(long roleId) {

        this.roleId = roleId;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }
}
