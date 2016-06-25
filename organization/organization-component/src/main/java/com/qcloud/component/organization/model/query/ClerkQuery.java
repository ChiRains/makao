package com.qcloud.component.organization.model.query;

import java.util.ArrayList;
import java.util.List;

public class ClerkQuery {

    private String     name;

    private int        type;

    private String     laborNumber;

    private long       roleId;

    private long       departmentId;

    private List<Long> ids4Role       = new ArrayList<Long>();

    private List<Long> ids4Department = new ArrayList<Long>();

    public ClerkQuery() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public String getLaborNumber() {

        return laborNumber;
    }

    public void setLaborNumber(String laborNumber) {

        this.laborNumber = laborNumber;
    }

    public long getRoleId() {

        return roleId;
    }

    public void setRoleId(long roleId) {

        this.roleId = roleId;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }

    public List<Long> getIds4Role() {

        return ids4Role;
    }

    public void setIds4Role(List<Long> ids4Role) {

        this.ids4Role = ids4Role;
    }

    public List<Long> getIds4Department() {

        return ids4Department;
    }

    public void setIds4Department(List<Long> ids4Department) {

        this.ids4Department = ids4Department;
    }
}
