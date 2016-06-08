package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.permission.PermissionClient;
import com.qcloud.component.permission.RoleClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.DepartmentRoleHandler;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.web.vo.DepartmentRoleVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDepartmentRoleVO;

@Component
public class DepartmentRoleHandlerImpl implements DepartmentRoleHandler {

    @Autowired
    OrganizationClient organizationClient;

    @Autowired
    PermissionClient   permissionClient;

    @Override
    public List<DepartmentRoleVO> toVOList(List<DepartmentRole> list) {

        List<DepartmentRoleVO> voList = new ArrayList<DepartmentRoleVO>();
        for (DepartmentRole departmentRole : list) {
            voList.add(toVO(departmentRole));
        }
        return voList;
    }

    @Override
    public DepartmentRoleVO toVO(DepartmentRole departmentRole) {

        String json = Json.toJson(departmentRole);
        DepartmentRoleVO vo = Json.toObject(json, DepartmentRoleVO.class, true);
        vo.setRoleName(permissionClient.getRole(departmentRole.getRoleId()).getName());
        vo.setDepartmentName(organizationClient.getDepartment(departmentRole.getDepartmentId()).getName());
        vo.setCreatorName(organizationClient.getClerk(departmentRole.getCreator()).getName());
        vo.setCreateDateStr(DateUtil.date2String(departmentRole.getCreateDate()));
        return vo;
    }

    @Override
    public List<AdminDepartmentRoleVO> toVOList4Admin(List<DepartmentRole> list) {

        List<AdminDepartmentRoleVO> voList = new ArrayList<AdminDepartmentRoleVO>();
        for (DepartmentRole adminDepartmentRole : list) {
            voList.add(toVO4Admin(adminDepartmentRole));
        }
        return voList;
    }

    @Override
    public AdminDepartmentRoleVO toVO4Admin(DepartmentRole departmentRole) {

        String json = Json.toJson(departmentRole);
        return Json.toObject(json, AdminDepartmentRoleVO.class, true);
    }
}
