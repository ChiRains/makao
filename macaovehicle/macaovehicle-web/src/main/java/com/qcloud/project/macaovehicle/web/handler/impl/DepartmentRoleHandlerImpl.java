package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.DepartmentRoleHandler;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.web.vo.DepartmentRoleVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDepartmentRoleVO;

@Component
public class DepartmentRoleHandlerImpl implements DepartmentRoleHandler {

	@Override
	public List<DepartmentRoleVO> toVOList(List<DepartmentRole> list){
		List<DepartmentRoleVO> voList = new ArrayList<DepartmentRoleVO>();
		for (DepartmentRole departmentRole : list) {
			voList.add(toVO(departmentRole));
		}
		return voList;
	}

	@Override
	public DepartmentRoleVO toVO(DepartmentRole departmentRole){
		String json = Json.toJson(departmentRole);
		return Json.toObject(json, DepartmentRoleVO.class, true);

	}

	@Override
	public List<AdminDepartmentRoleVO> toVOList4Admin(List<DepartmentRole> list){
		List<AdminDepartmentRoleVO> voList = new ArrayList<AdminDepartmentRoleVO>();
		for (DepartmentRole adminDepartmentRole : list) {
			voList.add(toVO4Admin(adminDepartmentRole));
		}
		return voList;
	}

	@Override
	public AdminDepartmentRoleVO toVO4Admin(DepartmentRole departmentRole){
		String json = Json.toJson(departmentRole);
		return Json.toObject(json, AdminDepartmentRoleVO.class, true);
	}
}
