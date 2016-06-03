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
import com.qcloud.component.snakerext.dao.ProcessExecutorInterfaceDao;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.model.query.ProcessExecutorInterfaceQuery;
@Repository
public class ProcessExecutorInterfaceDaoMysqlImpl implements ProcessExecutorInterfaceDao {
    @Resource(name = "sqlOperator-snakerext")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ProcessExecutorInterface processExecutorInterface) {
        return sqlOperator.insert("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.insert", processExecutorInterface) == 1;
    }

    @Override
    public ProcessExecutorInterface get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ProcessExecutorInterface processExecutorInterface) {
        return sqlOperator.update("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.update", processExecutorInterface) > 0;
    }

    @Override
    public List<ProcessExecutorInterface> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessExecutorInterface> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessExecutorInterface> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessExecutorInterface> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.count4page", param);
        Page<ProcessExecutorInterface> page = new Page<ProcessExecutorInterface>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ProcessExecutorInterface> page(ProcessExecutorInterfaceQuery query, int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessExecutorInterface> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.count4query", param);
        Page<ProcessExecutorInterface> page = new Page<ProcessExecutorInterface>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ProcessExecutorInterface> listAll() {
        List<ProcessExecutorInterface> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.listAll");
        return list;
    }

    @Override
    public List<ProcessExecutorInterface> listAll(Map<String, Object> map) {
        List<ProcessExecutorInterface> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessExecutorInterfaceMapper.listAllByMap", map);
        return list;
    }
}
