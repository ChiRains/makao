package com.qcloud.component.organization.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.DepartmentClerkDao;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.query.DepartmentClerkQuery;

@Repository
public class DepartmentClerkDaoRedisImpl implements DepartmentClerkDao {

    // @Resource(name = "redis-organization")
    // private Redis redis;
    @Override
    public boolean add(DepartmentClerk departmentClerk) {

        throw new NotImplementedException();
    }

    @Override
    public DepartmentClerk get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(DepartmentClerk departmentClerk) {

        throw new NotImplementedException();
    }

    @Override
    public List<DepartmentClerk> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DepartmentClerk> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DepartmentClerk> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DepartmentClerk> page(DepartmentClerkQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<DepartmentClerk> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public List<DepartmentClerk> listByDepartment(Long departmentId) {

        throw new NotImplementedException();
    }

    @Override
    public DepartmentClerk getBelongsDepartment(Long clerkId) {

        throw new NotImplementedException();
    }
}
