package com.qcloud.component.organization.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.DepartmentDao;
import com.qcloud.component.organization.exception.OrganizationException;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.service.DepartmentService;
import com.qcloud.component.organization.model.query.DepartmentQuery;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao       departmentDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "organization_department";

    @Override
    public boolean add(Department department) {

        long id = autoIdGenerator.get(ID_KEY);
        String idStr = String.valueOf(id);
        String bsid = String.valueOf(id).substring(idStr.length() - 5, idStr.length());
        if (department.getParentId() != -1) {
            Department d = departmentDao.get(department.getParentId());
            if (d == null) {
                throw new OrganizationException("非法操作!");
            }
            department.setDisplayName(d.getDisplayName() + "-" + department.getName());
            department.setBsid(d.getBsid() + bsid);
        } else {
            department.setBsid(bsid);
            department.setDisplayName(department.getName());
        }
        department.setId(id);
        return departmentDao.add(department);
    }

    @Override
    public Department get(Long id) {

        return departmentDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return departmentDao.delete(id);
    }

    @Override
    public boolean update(Department department) {

        if (department.getParentId() != -1) {
            Department d = departmentDao.get(department.getParentId());
            if (d == null) {
                throw new OrganizationException("非法操作!");
            }
            department.setDisplayName(d.getDisplayName() + "-" + department.getName());
        }
        return departmentDao.update(department);
    }

    @Override
    public Page<Department> page(DepartmentQuery query, int start, int count) {

        return departmentDao.page(query, start, count);
    }

    public List<Department> listAll() {

        return departmentDao.listAll();
    }
}
