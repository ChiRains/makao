package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.web.vo.DepartmentVO;
import com.qcloud.component.organization.web.vo.admin.AdminDepartmentVO;

public interface DepartmentHandler {

	List<DepartmentVO> toVOList(List<Department> list);

	DepartmentVO toVO(Department department);

	List<AdminDepartmentVO> toVOList4Admin(List<Department> list);

	AdminDepartmentVO toVO4Admin(Department department);
}
