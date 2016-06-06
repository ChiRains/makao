package com.qcloud.component.snakerext.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.ProcessExecutorDao;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.model.query.ProcessExecutorQuery;

@Repository
public class ProcessExecutorDaoCacheImpl implements ProcessExecutorDao {

    @Autowired
    private ProcessExecutorDao processExecutorDaoMysqlImpl;

//    @Autowired
//    private ProcessExecutorDao processExecutorDaoRedisImpl;

    @Override
    public boolean add(ProcessExecutor processExecutor) {

        return processExecutorDaoMysqlImpl.add(processExecutor);
    }

    @Override
    public ProcessExecutor get(Long id) {
        return processExecutorDaoMysqlImpl.get(id);
//        return CacheLoader.get(processExecutorDaoRedisImpl, processExecutorDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return processExecutorDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ProcessExecutor processExecutor) {

        return processExecutorDaoMysqlImpl.update(processExecutor);
    }

    @Override
    public List<ProcessExecutor> list(List<Long> idList) {

        return CacheLoader.list(processExecutorDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ProcessExecutor> map(Set<Long> idSet) {

        return CacheLoader.map(processExecutorDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ProcessExecutor> page(int start, int count) {

        return processExecutorDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ProcessExecutor> page(ProcessExecutorQuery query, int start, int count) {

        return processExecutorDaoMysqlImpl.page(query, start, count);
    }

    public List<ProcessExecutor> listAll() {

        return processExecutorDaoMysqlImpl.listAll();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return processExecutorDaoMysqlImpl.delete(map);
    }

    @Override
    public List<ProcessExecutor> listByProcessIdAndTaskName(String processId, String taskName) {

        return processExecutorDaoMysqlImpl.listByProcessIdAndTaskName(processId, taskName);
    }
}
