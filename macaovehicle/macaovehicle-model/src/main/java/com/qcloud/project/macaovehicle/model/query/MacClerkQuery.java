package com.qcloud.project.macaovehicle.model.query;

public class MacClerkQuery {

    private String name;

    private String laborNumber;

    private long   roleId;

    private long   departmentId;

    public String getName() {

        return name;
    }

    public String getLaborNumber() {

        return laborNumber;
    }

    public long getRoleId() {

        return roleId;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLaborNumber(String laborNumber) {

        this.laborNumber = laborNumber;
    }

    public void setRoleId(long roleId) {

        this.roleId = roleId;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }
}
