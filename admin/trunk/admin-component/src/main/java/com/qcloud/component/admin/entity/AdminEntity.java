package com.qcloud.component.admin.entity;

import com.qcloud.component.admin.QAdmin;
import com.qcloud.component.admin.model.Admin;

public class AdminEntity implements QAdmin {

    private Admin admin;

    public AdminEntity(Admin admin) {

        super();
        this.admin = admin;
    }

    @Override
    public long getId() {

        return admin.getId();
    }

    @Override
    public String getAccount() {

        return admin.getAccount();
    }

    @Override
    public String getName() {

        return admin.getName();
    }
}
