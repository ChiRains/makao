package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.web.vo.DepartmentRoleVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDepartmentRoleVO;

public interface DepartmentRoleHandler {

	List<DepartmentRoleVO> toVOList(List<DepartmentRole> list);

	DepartmentRoleVO toVO(DepartmentRole departmentRole);

	List<AdminDepartmentRoleVO> toVOList4Admin(List<DepartmentRole> list);

	AdminDepartmentRoleVO toVO4Admin(DepartmentRole departmentRole);
}
