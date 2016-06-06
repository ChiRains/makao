package com.qcloud.component.snakerext.dao.cache;
import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.ProcessExecutorInterfaceDao;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.model.query.ProcessExecutorInterfaceQuery;
@Repository
public class ProcessExecutorInterfaceDaoCacheImpl implements ProcessExecutorInterfaceDao {
    @Autowired
    private ProcessExecutorInterfaceDao processExecutorInterfaceDaoMysqlImpl;
    @Autowired
    private ProcessExecutorInterfaceDao processExecutorInterfaceDaoRedisImpl;

    @Override
    public boolean add(ProcessExecutorInterface processExecutorInterface) {
        return processExecutorInterfaceDaoMysqlImpl.add(processExecutorInterface);
    }

    @Override
    public ProcessExecutorInterface get(Long id) {
        return processExecutorInterfaceDaoMysqlImpl.get(id);
        // return CacheLoader.get(processExecutorInterfaceDaoRedisImpl, processExecutorInterfaceDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {
        return processExecutorInterfaceDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ProcessExecutorInterface processExecutorInterface) {
        return processExecutorInterfaceDaoMysqlImpl.update(processExecutorInterface);
    }

    @Override
    public List<ProcessExecutorInterface> list(List<Long> idList) {
        return CacheLoader.list(processExecutorInterfaceDaoRedisImpl, processExecutorInterfaceDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ProcessExecutorInterface> map(Set<Long> idSet) {
        return CacheLoader.map(processExecutorInterfaceDaoRedisImpl, processExecutorInterfaceDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ProcessExecutorInterface> page(int start, int count) {
        return processExecutorInterfaceDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ProcessExecutorInterface> page(ProcessExecutorInterfaceQuery query, int start, int count) {
        return processExecutorInterfaceDaoMysqlImpl.page(query, start, count);
    }

    public List<ProcessExecutorInterface> listAll() {
        return processExecutorInterfaceDaoMysqlImpl.listAll();
    }

    @Override
    public List<ProcessExecutorInterface> listAll(Map<String, Object> map) {
        return processExecutorInterfaceDaoMysqlImpl.listAll(map);
    }
}
