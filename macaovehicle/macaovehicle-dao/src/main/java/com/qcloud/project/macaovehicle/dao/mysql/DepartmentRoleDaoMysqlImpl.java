package com.qcloud.project.macaovehicle.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.project.macaovehicle.dao.DepartmentRoleDao;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.model.query.DepartmentRoleQuery;

@Repository
public class DepartmentRoleDaoMysqlImpl implements DepartmentRoleDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(DepartmentRole departmentRole) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.insert", departmentRole) == 1;
    }

    @Override
    public DepartmentRole get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.delete", id) > 0;
    }

    @Override
    public boolean update(DepartmentRole departmentRole) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.update", departmentRole) > 0;
    }

    @Override
    public List<DepartmentRole> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DepartmentRole> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DepartmentRole> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DepartmentRole> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.count4page", param);
        Page<DepartmentRole> page = new Page<DepartmentRole>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<DepartmentRole> page(DepartmentRoleQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DepartmentRole> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.count4query", param);
        Page<DepartmentRole> page = new Page<DepartmentRole>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<DepartmentRole> listAll() {

        List<DepartmentRole> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.listAll");
        return list;
    }

    @Override
    public List<DepartmentRole> listByDepartmentId(Long departmentId) {

        List<DepartmentRole> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DepartmentRoleMapper.listByDepartmentId", departmentId);
        return list;
    }
}
