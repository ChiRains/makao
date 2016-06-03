package com.qcloud.component.snakerext.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.snakerext.dao.ProcessGroupClerkDao;
import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.model.query.ProcessGroupClerkQuery;

@Repository
public class ProcessGroupClerkDaoMysqlImpl implements ProcessGroupClerkDao {

    @Resource(name = "sqlOperator-snakerext")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ProcessGroupClerk processGroupClerk) {

        return sqlOperator.insert("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.insert", processGroupClerk) == 1;
    }

    @Override
    public ProcessGroupClerk get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ProcessGroupClerk processGroupClerk) {

        return sqlOperator.update("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.update", processGroupClerk) > 0;
    }

    @Override
    public List<ProcessGroupClerk> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessGroupClerk> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessGroupClerk> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessGroupClerk> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.count4page", param);
        Page<ProcessGroupClerk> page = new Page<ProcessGroupClerk>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ProcessGroupClerk> page(ProcessGroupClerkQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessGroupClerk> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.count4query", param);
        Page<ProcessGroupClerk> page = new Page<ProcessGroupClerk>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ProcessGroupClerk> listAll() {

        List<ProcessGroupClerk> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.listAll");
        return list;
    }

    @Override
    public List<ProcessGroupClerk> listByGroup(Long groupId) {

        List<ProcessGroupClerk> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.listByGroup", groupId);
        return list;
    }

    @Override
    public boolean deleteByGroupId(Long groupId) {

        return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupClerkMapper.deleteByGroupId",groupId)>0;
    }
}
