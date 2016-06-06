package com.qcloud.project.macaovehicle.web.form;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRoleForm {

    // 角色名称
    private String     roleName;

    // 部门id
    private long       departmentId;

    // 描述
    private String     desc;

    // 分类id
    private List<Long> classifyIds = new ArrayList<Long>();

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public String getDesc() {

        return desc;
    }

    public String getRoleName() {

        return roleName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }

    public List<Long> getClassifyIds() {

        return classifyIds;
    }

    public void setClassifyIds(List<Long> classifyIds) {

        this.classifyIds = classifyIds;
    }
}
