package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class DepartmentRoleVO {

    // ID
    private long   id;

    // 角色id
    private long   roleId;

    // 部门id
    private long   departmentId;

    // 描述
    private String desc;

    // 状态(1启用 2停用)
    private int    status;

    // 创建人
    private long   creator;

    // 创建时间
    private Date   createDate;

    // 角色名称
    private String roleName;

    // 部门名称
    private String departmentName;

    // 创建人
    private String creatorName;

    // 创建时间
    private String createDateStr;

    public DepartmentRoleVO() {

    }

    public DepartmentRoleVO(long id, long roleId, long departmentId, String desc, int status, long creator, Date createDate) {

        this.id = id;
        this.roleId = roleId;
        this.departmentId = departmentId;
        this.desc = desc;
        this.status = status;
        this.creator = creator;
        this.createDate = createDate;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setRoleId(long roleId) {

        this.roleId = roleId;
    }

    public long getRoleId() {

        return roleId;
    }

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

    public void setStatus(int status) {

        this.status = status;
    }

    public int getStatus() {

        return status;
    }

    public void setCreator(long creator) {

        this.creator = creator;
    }

    public long getCreator() {

        return creator;
    }

    public void setCreateDate(Date createDate) {

        this.createDate = createDate;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public String getRoleName() {

        return roleName;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public String getCreatorName() {

        return creatorName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }

    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }

    public void setCreatorName(String creatorName) {

        this.creatorName = creatorName;
    }

    public String getCreateDateStr() {

        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {

        this.createDateStr = createDateStr;
    }
}
