package com.qcloud.component.snakerext.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.snakerext.dao.ProcessExecutorDao;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.model.query.ProcessExecutorQuery;
import com.qcloud.pirates.data.Page;

@Repository
public class ProcessExecutorDaoRedisImpl implements ProcessExecutorDao {

    // @Resource(name = "redis-snakerext")
    // private Redis redis;
    @Override
    public boolean add(ProcessExecutor processExecutor) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessExecutor get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ProcessExecutor processExecutor) {

        throw new NotImplementedException();
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

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessExecutor> page(ProcessExecutorQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessExecutor> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessExecutor> listByProcessIdAndTaskName(String processId, String taskName) {

        throw new NotImplementedException();
    }
}
