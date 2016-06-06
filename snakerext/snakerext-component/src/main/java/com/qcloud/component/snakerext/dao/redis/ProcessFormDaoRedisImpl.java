package com.qcloud.component.snakerext.dao.redis;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.snakerext.dao.ProcessFormDao;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
import com.qcloud.pirates.data.Page;
@Repository
public class ProcessFormDaoRedisImpl implements ProcessFormDao {
    // @Resource(name = "redis-snakerext")
    // private Redis redis;
    @Override
    public boolean add(ProcessForm processForm) {
        throw new NotImplementedException();
    }

    @Override
    public ProcessForm get(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(ProcessForm processForm) {
        throw new NotImplementedException();
    }

    @Override
    public List<ProcessForm> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessForm> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessForm> page(int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessForm> page(ProcessFormQuery query, int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public List<ProcessForm> listAll() {
        throw new NotImplementedException();
    }

    @Override
    public List<ProcessForm> list(Map<String, Object> map) {
        throw new NotImplementedException();
    }
}
