package com.qcloud.component.snakerext.dao.redis;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.snakerext.dao.ProcessExecutorInterfaceDao;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.model.query.ProcessExecutorInterfaceQuery;
import com.qcloud.pirates.data.Page;
@Repository
public class ProcessExecutorInterfaceDaoRedisImpl implements ProcessExecutorInterfaceDao {
    // @Resource(name = "redis-snakerext")
    // private Redis redis;
    @Override
    public boolean add(ProcessExecutorInterface processExecutorInterface) {
        throw new NotImplementedException();
    }

    @Override
    public ProcessExecutorInterface get(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(ProcessExecutorInterface processExecutorInterface) {
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessExecutorInterface> page(ProcessExecutorInterfaceQuery query, int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public List<ProcessExecutorInterface> listAll() {
        throw new NotImplementedException();
    }

    @Override
    public List<ProcessExecutorInterface> listAll(Map<String, Object> map) {
        throw new NotImplementedException();
    }
}
