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
import com.qcloud.component.processtask.dao.TaskingDao;
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.query.TaskingQuery;

@Repository
public class TaskingDaoMysqlImpl implements TaskingDao {

    @Resource(name = "sqlOperator-processtask")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Tasking tasking) {

        return sqlOperator.insert("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.insert", tasking) == 1;
    }

    @Override
    public Tasking get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Tasking tasking) {

        return sqlOperator.update("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.update", tasking) > 0;
    }

    @Override
    public List<Tasking> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Tasking> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Tasking> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Tasking> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.count4page", param);
        Page<Tasking> page = new Page<Tasking>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Tasking> page(TaskingQuery query, int myApply, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("myApply", myApply);
        param.put("clerkId", query.getClerkId());
        param.put("type", query.getType());
        param.put("creatorName", StringUtil.emptyToNull(query.getClerk()));
        param.put("departmantName", StringUtil.emptyToNull(query.getDepartment()));
        param.put("processName", StringUtil.emptyToNull(query.getProcess()));
        List<Tasking> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.count4query", param);
        Page<Tasking> page = new Page<Tasking>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Tasking> listAll() {

        List<Tasking> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.listAll");
        return list;
    }

    @Override
    public Tasking getByWorkitem(String workitemId) {

        return sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.getByWorkitem", workitemId);
    }

    @Override
    public List<Tasking> getNextExecutor(Long formInstanceId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("formInstanceId", formInstanceId);
        List<Tasking> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskingMapper.getNextExecutor", param);
        return list;
    }
}
