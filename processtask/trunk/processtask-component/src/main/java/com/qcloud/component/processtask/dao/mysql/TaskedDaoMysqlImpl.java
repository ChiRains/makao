package com.qcloud.component.processtask.dao.mysql;

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
import com.qcloud.component.processtask.dao.TaskedDao;
import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.model.query.TaskedQuery;

@Repository
public class TaskedDaoMysqlImpl implements TaskedDao {

    @Resource(name = "sqlOperator-processtask")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Tasked tasked) {

        return sqlOperator.insert("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.insert", tasked) == 1;
    }

    @Override
    public Tasked get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Tasked tasked) {

        return sqlOperator.update("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.update", tasked) > 0;
    }

    @Override
    public List<Tasked> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Tasked> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Tasked> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.count4page", param);
        Page<Tasked> page = new Page<Tasked>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Tasked> page(TaskedQuery query, int myApply, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("clerkId", query.getClerkId());
        param.put("myApply", myApply);
        param.put("type", query.getType());
        param.put("creatorName", StringUtil.emptyToNull(query.getClerk()));
        param.put("departmantName", StringUtil.emptyToNull(query.getDepartment()));
        param.put("processName", StringUtil.emptyToNull(query.getProcess()));
        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.count4query", param);
        Page<Tasked> page = new Page<Tasked>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Tasked> listAll() {

        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.listAll");
        return list;
    }

    @Override
    public List<Tasked> listTaskedByProcessInst(String processInstId) {

        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.listTaskedByProcessInst", processInstId);
        return list;
    }

    @Override
    public Tasked getByWorkitem(String workitemId) {
        return sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.getByWorkitem", workitemId);
    }
}
