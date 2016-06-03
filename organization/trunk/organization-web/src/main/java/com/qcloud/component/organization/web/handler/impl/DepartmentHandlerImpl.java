package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.web.handler.DepartmentHandler;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.web.vo.DepartmentVO;
import com.qcloud.component.organization.web.vo.admin.AdminDepartmentVO;

@Component
public class DepartmentHandlerImpl implements DepartmentHandler {

    @Autowired
    private ClerkService clerkService;

    @Override
    public List<DepartmentVO> toVOList(List<Department> list) {

        List<DepartmentVO> voList = new ArrayList<DepartmentVO>();
        for (Department department : list) {
            voList.add(toVO(department));
        }
        return voList;
    }

    @Override
    public DepartmentVO toVO(Department department) {

        String json = Json.toJson(department);
        return Json.toObject(json, DepartmentVO.class, true);
    }

    @Override
    public List<AdminDepartmentVO> toVOList4Admin(List<Department> list) {

        List<AdminDepartmentVO> voList = new ArrayList<AdminDepartmentVO>();
        for (Department adminDepartment : list) {
            AdminDepartmentVO vo = toVO4Admin(adminDepartment);
            Clerk clerk = clerkService.get(adminDepartment.getManager());
            if (clerk != null) {
                vo.setManagerName(clerk.getName());
            }
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public AdminDepartmentVO toVO4Admin(Department department) {

        String json = Json.toJson(department);
        return Json.toObject(json, AdminDepartmentVO.class, true);
    }
}
