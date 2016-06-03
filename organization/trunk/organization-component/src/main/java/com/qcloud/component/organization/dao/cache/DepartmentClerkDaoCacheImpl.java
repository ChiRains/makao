package com.qcloud.component.organization.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.DepartmentClerkDao;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.query.DepartmentClerkQuery;

@Repository
public class DepartmentClerkDaoCacheImpl implements DepartmentClerkDao {

    @Autowired
    private DepartmentClerkDao departmentClerkDaoMysqlImpl;

    // @Autowired
    // private DepartmentClerkDao departmentClerkDaoRedisImpl;
    @Override
    public boolean add(DepartmentClerk departmentClerk) {

        return departmentClerkDaoMysqlImpl.add(departmentClerk);
    }

    @Override
    public DepartmentClerk get(Long id) {

        return departmentClerkDaoMysqlImpl.get(id);
        // return CacheLoader.get(departmentClerkDaoRedisImpl, departmentClerkDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return departmentClerkDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(DepartmentClerk departmentClerk) {

        return departmentClerkDaoMysqlImpl.update(departmentClerk);
    }

    @Override
    public List<DepartmentClerk> list(List<Long> idList) {

        return CacheLoader.list(departmentClerkDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, DepartmentClerk> map(Set<Long> idSet) {

        return CacheLoader.map(departmentClerkDaoMysqlImpl, idSet);
    }

    @Override
    public Page<DepartmentClerk> page(int start, int count) {

        return departmentClerkDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<DepartmentClerk> page(DepartmentClerkQuery query, int start, int count) {

        return departmentClerkDaoMysqlImpl.page(query, start, count);
    }

    public List<DepartmentClerk> listAll() {

        return departmentClerkDaoMysqlImpl.listAll();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return departmentClerkDaoMysqlImpl.delete(map);
    }

    @Override
    public List<DepartmentClerk> listByDepartment(Long departmentId) {

        return departmentClerkDaoMysqlImpl.listByDepartment(departmentId);
    }

    @Override
    public DepartmentClerk getBelongsDepartment(Long clerkId) {

        return departmentClerkDaoMysqlImpl.getBelongsDepartment(clerkId);
    }
}
