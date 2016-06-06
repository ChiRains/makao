package com.qcloud.component.permission;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.permission.entity.RoleEntity;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.service.RoleService;

@Service
public class RoleClientImpl implements RoleClient {

    @Autowired
    private RoleService roleService;

    @Override
    public List<QRole> listRoles() {

        List<QRole> list = new ArrayList<QRole>();
        List<Role> roles = roleService.list();
        for (Role role : roles) {
            RoleEntity re = new RoleEntity();
            re.setId(role.getId());
            re.setName(role.getName());
            re.setDesc(role.getDesc());
            list.add(re);
        }
        return list;
    }
}
