package com.qcloud.component.admin.core;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.admin.AdminClient;
import com.qcloud.component.admin.QAdmin;
import com.qcloud.component.admin.entity.AdminEntity;
import com.qcloud.component.admin.model.Admin;
import com.qcloud.component.admin.service.AdminService;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class AdminClientImpl implements AdminClient {

    @Autowired
    AdminService adminService;

    @Override
    public QAdmin getAdminById(Long id) {

        Admin admin = adminService.get(id);
        AssertUtil.assertNotNull(admin, "管理员记录不存在." + id);
        return new AdminEntity(admin);
    }

    @Override
    public QAdmin getAdminByAccount(String account) {

        Admin admin = adminService.getByAccount(account);
        AssertUtil.assertNotNull(admin, "管理员记录不存在." + account);
        return new AdminEntity(admin);
    }

    @Override
    public List<QAdmin> listAll() {

        Page<Admin> page = adminService.list(0, Integer.MAX_VALUE);
        List<QAdmin> list = new ArrayList<QAdmin>();
        for (Admin admin : page.getData()) {
            list.add(new AdminEntity(admin));
        }
        return list;
    }
}
