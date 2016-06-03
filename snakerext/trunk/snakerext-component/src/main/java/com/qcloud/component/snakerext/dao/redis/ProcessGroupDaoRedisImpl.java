package com.qcloud.component.snakerext.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.snakerext.dao.ProcessGroupDao;
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.model.query.ProcessGroupQuery;

@Repository
public class ProcessGroupDaoRedisImpl implements ProcessGroupDao {

    // @Resource(name = "redis-snaker_ext")
    // private Redis redis;
    @Override
    public boolean add(ProcessGroup processGroup) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessGroup get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ProcessGroup processGroup) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessGroup> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessGroup> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessGroup> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessGroup> page(ProcessGroupQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessGroup> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessGroup> listByName(String name) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessGroup getByName(String name) {

        throw new NotImplementedException();
    }
}
