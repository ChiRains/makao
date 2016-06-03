package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.web.vo.DepartmentClerkVO;
import com.qcloud.component.organization.web.vo.admin.AdminDepartmentClerkVO;

public interface DepartmentClerkHandler {

	List<DepartmentClerkVO> toVOList(List<DepartmentClerk> list);

	DepartmentClerkVO toVO(DepartmentClerk departmentClerk);

	List<AdminDepartmentClerkVO> toVOList4Admin(List<DepartmentClerk> list);

	AdminDepartmentClerkVO toVO4Admin(DepartmentClerk departmentClerk);
}
