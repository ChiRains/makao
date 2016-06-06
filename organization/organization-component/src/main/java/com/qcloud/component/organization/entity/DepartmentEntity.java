package com.qcloud.component.organization.entity;

import com.qcloud.component.organization.QDepartment;

public class DepartmentEntity implements QDepartment {

    private Long   id;

    private String name;

    private Long   manager;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getManager() {

        return manager;
    }

    public void setManager(Long manager) {

        this.manager = manager;
    }
}
