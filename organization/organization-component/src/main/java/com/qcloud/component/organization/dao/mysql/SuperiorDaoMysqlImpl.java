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
import com.qcloud.component.organization.dao.SuperiorDao;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.model.query.SuperiorQuery;

@Repository
public class SuperiorDaoMysqlImpl implements SuperiorDao {

    @Resource(name = "sqlOperator-organization")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Superior superior) {

        return sqlOperator.insert("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.insert", superior) == 1;
    }

    @Override
    public Superior get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Superior superior) {

        return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.update", superior) > 0;
    }

    @Override
    public List<Superior> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Superior> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Superior> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Superior> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.count4page", param);
        Page<Superior> page = new Page<Superior>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Superior> page(SuperiorQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Superior> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.count4query", param);
        Page<Superior> page = new Page<Superior>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Superior> listAll() {

        List<Superior> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.listAll");
        return list;
    }

    @Override
    public Superior getByClerk(Long clerkId) {

        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.SuperiorMapper.getByClerk", clerkId);
    }
}
