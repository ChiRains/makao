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
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.component.organization.dao.ClerkDao;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.query.ClerkQuery;

@Repository
public class ClerkDaoMysqlImpl implements ClerkDao {

    @Resource(name = "sqlOperator-organization")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Clerk clerk) {

        return sqlOperator.insert("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.insert", clerk) == 1;
    }

    @Override
    public Clerk get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Clerk clerk) {

        return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.update", clerk) > 0;
    }

    @Override
    public List<Clerk> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Clerk> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Clerk> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Clerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.count4page", param);
        Page<Clerk> page = new Page<Clerk>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Clerk> page(ClerkQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("name", StringUtil.nullToEmpty(query.getName()));
        param.put("type", query.getType());
        List<Clerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.count4query", param);
        Page<Clerk> page = new Page<Clerk>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Clerk> listAll() {

        List<Clerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.listAll");
        return list;
    }

    @Override
    public List<Clerk> listAll(Map<String, Object> map) {

        List<Clerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.listAllByMap", map);
        return list;
    }

    @Override
    public List<Clerk> listByName(String name) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        List<Clerk> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.listByName", map);
        return list;
    }

    @Override
    public boolean editEnable(Long id) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.editEnable", map) > 0;
    }

    @Override
    public Clerk getByMobile(String mobile) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("mobile", mobile);
        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.getByMobile", param);
    }

    @Override
    public Clerk getByIdCard(String idCard) {

        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.getByIdCard", idCard);
    }

    @Override
    public Clerk getByJobEmail(String jobEmail) {

        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkMapper.getByJobEmail", jobEmail);
    }
}
