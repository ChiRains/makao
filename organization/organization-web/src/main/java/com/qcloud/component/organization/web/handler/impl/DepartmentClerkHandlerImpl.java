package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.organization.web.handler.DepartmentClerkHandler;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.web.vo.DepartmentClerkVO;
import com.qcloud.component.organization.web.vo.admin.AdminDepartmentClerkVO;

@Component
public class DepartmentClerkHandlerImpl implements DepartmentClerkHandler {

	@Override
	public List<DepartmentClerkVO> toVOList(List<DepartmentClerk> list){
		List<DepartmentClerkVO> voList = new ArrayList<DepartmentClerkVO>();
		for (DepartmentClerk departmentClerk : list) {
			voList.add(toVO(departmentClerk));
		}
		return voList;
	}

	@Override
	public DepartmentClerkVO toVO(DepartmentClerk departmentClerk){
		String json = Json.toJson(departmentClerk);
		return Json.toObject(json, DepartmentClerkVO.class, true);

	}

	@Override
	public List<AdminDepartmentClerkVO> toVOList4Admin(List<DepartmentClerk> list){
		List<AdminDepartmentClerkVO> voList = new ArrayList<AdminDepartmentClerkVO>();
		for (DepartmentClerk adminDepartmentClerk : list) {
			voList.add(toVO4Admin(adminDepartmentClerk));
		}
		return voList;
	}

	@Override
	public AdminDepartmentClerkVO toVO4Admin(DepartmentClerk departmentClerk){
		String json = Json.toJson(departmentClerk);
		return Json.toObject(json, AdminDepartmentClerkVO.class, true);
	}
}
