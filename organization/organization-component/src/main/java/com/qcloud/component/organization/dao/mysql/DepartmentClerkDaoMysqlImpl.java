package com.qcloud.component.organization.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.organization.dao.DepartmentClerkDao;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.query.DepartmentClerkQuery;

@Repository
public class DepartmentClerkDaoMysqlImpl implements DepartmentClerkDao {

    @Resource(name = "sqlOperator-organization")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(DepartmentClerk departmentClerk) {

        return sqlOperator.insert("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.insert", departmentClerk) == 1;
    }

    @Override
    public DepartmentClerk get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.delete", id) > 0;
    }

    @Override
    public boolean update(DepartmentClerk departmentClerk) {

        return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.update", departmentClerk) > 0;
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

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DepartmentClerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.count4page", param);
        Page<DepartmentClerk> page = new Page<DepartmentClerk>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<DepartmentClerk> page(DepartmentClerkQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("departmentId", query.getDepartmentId());
        List<DepartmentClerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.count4query", param);
        Page<DepartmentClerk> page = new Page<DepartmentClerk>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<DepartmentClerk> listAll() {

        List<DepartmentClerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.listAll");
        return list;
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.deleteByMap", map) > 0;
    }

    @Override
    public List<DepartmentClerk> listByDepartment(Long departmentId) {

        List<DepartmentClerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.listByDepartment", departmentId);
        return list;
    }

    @Override
    public DepartmentClerk getBelongsDepartment(Long clerkId) {
        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.DepartmentClerkMapper.getBelongsDepartment", clerkId);        
    }
}
