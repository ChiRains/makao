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
import com.qcloud.component.snakerext.dao.ProcessExecutorDao;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.model.query.ProcessExecutorQuery;

@Repository
public class ProcessExecutorDaoMysqlImpl implements ProcessExecutorDao {

    @Resource(name = "sqlOperator-snakerext")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ProcessExecutor processExecutor) {

        return sqlOperator.insert("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.insert", processExecutor) == 1;
    }

    @Override
    public ProcessExecutor get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ProcessExecutor processExecutor) {

        return sqlOperator.update("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.update", processExecutor) > 0;
    }

    @Override
    public List<ProcessExecutor> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessExecutor> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessExecutor> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessExecutor> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.count4page", param);
        Page<ProcessExecutor> page = new Page<ProcessExecutor>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ProcessExecutor> page(ProcessExecutorQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessExecutor> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.count4query", param);
        Page<ProcessExecutor> page = new Page<ProcessExecutor>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ProcessExecutor> listAll() {

        List<ProcessExecutor> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.listAll");
        return list;
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.deleteByMap", map) > 0;
    }

    @Override
    public List<ProcessExecutor> listByProcessIdAndTaskName(String processId, String taskName) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("processId", processId);
        param.put("taskName", taskName);
        List<ProcessExecutor> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorMapper.listByProcessIdAndTaskName", param);
        return list;
    }
}
