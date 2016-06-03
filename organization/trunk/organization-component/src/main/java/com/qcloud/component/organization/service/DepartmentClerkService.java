package com.qcloud.component.organization.service;

import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.query.DepartmentClerkQuery;

public interface DepartmentClerkService {

    public boolean add(DepartmentClerk departmentClerk);

    public DepartmentClerk get(Long id);

    public boolean delete(Long id);

    public boolean update(DepartmentClerk departmentClerk);

    public Page<DepartmentClerk> page(DepartmentClerkQuery query, int start, int count);

    public List<DepartmentClerk> listAll();

    public boolean delete(Map<String, Object> map);

    List<DepartmentClerk> listByDepartment(Long departmentId);

    DepartmentClerk getBelongsDepartment(Long clerkId);
}
