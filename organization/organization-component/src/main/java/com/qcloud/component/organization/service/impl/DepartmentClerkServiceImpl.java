package com.qcloud.component.organization.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.organization.dao.DepartmentClerkDao;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.key.TypeEnum.EnableType;
import com.qcloud.component.organization.model.query.DepartmentClerkQuery;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.service.DepartmentClerkService;
import com.qcloud.pirates.data.Page;

@Service
public class DepartmentClerkServiceImpl implements DepartmentClerkService {

    @Autowired
    private DepartmentClerkDao  departmentClerkDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "organization_department_clerk";

    @Autowired
    private ClerkService        clerkService;

    @Override
    public boolean add(DepartmentClerk departmentClerk) {

        long id = autoIdGenerator.get(ID_KEY);
        departmentClerk.setId(id);
        return departmentClerkDao.add(departmentClerk);
    }

    @Override
    public DepartmentClerk get(Long id) {

        return departmentClerkDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return departmentClerkDao.delete(id);
    }

    @Override
    public boolean update(DepartmentClerk departmentClerk) {

        return departmentClerkDao.update(departmentClerk);
    }

    @Override
    public Page<DepartmentClerk> page(DepartmentClerkQuery query, int start, int count) {

        return departmentClerkDao.page(query, start, count);
    }

    public List<DepartmentClerk> listAll() {

        return departmentClerkDao.listAll();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return departmentClerkDao.delete(map);
    }

    @Override
    public List<DepartmentClerk> listByDepartment(Long departmentId) {

        List<DepartmentClerk> list = departmentClerkDao.listByDepartment(departmentId);
        for (int i = 0; i < list.size(); i++) {
            Clerk clerk = clerkService.get(list.get(i).getClerkId());
            if (clerk.getEnable() == EnableType.DISABLE.getKey()) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    @Override
    public DepartmentClerk getBelongsDepartment(Long clerkId) {

        return departmentClerkDao.getBelongsDepartment(clerkId);
    }
}
