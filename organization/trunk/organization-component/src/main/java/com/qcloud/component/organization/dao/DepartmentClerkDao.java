package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.query.DepartmentClerkQuery;

public interface DepartmentClerkDao extends ISimpleDao<DepartmentClerk, Long> {

    public boolean add(DepartmentClerk departmentClerk);

    public DepartmentClerk get(Long id);

    public boolean delete(Long id);

    public boolean update(DepartmentClerk departmentClerk);

    public List<DepartmentClerk> list(List<Long> idList);

    public Map<Long, DepartmentClerk> map(Set<Long> idSet);

    public Page<DepartmentClerk> page(DepartmentClerkQuery query, int start, int size);

    public List<DepartmentClerk> listAll();

    public List<DepartmentClerk> listByDepartment(Long departmentId);

    public boolean delete(Map<String, Object> map);
    
    DepartmentClerk getBelongsDepartment(Long clerkId);
}
