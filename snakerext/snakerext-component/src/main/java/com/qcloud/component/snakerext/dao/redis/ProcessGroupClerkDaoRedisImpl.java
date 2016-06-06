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
import com.qcloud.component.snakerext.dao.ProcessGroupClerkDao;
import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.model.query.ProcessGroupClerkQuery;

@Repository
public class ProcessGroupClerkDaoRedisImpl implements ProcessGroupClerkDao {

    // @Resource(name = "redis-snaker_ext")
    // private Redis redis;
    @Override
    public boolean add(ProcessGroupClerk processGroupClerk) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessGroupClerk get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ProcessGroupClerk processGroupClerk) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessGroupClerk> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessGroupClerk> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessGroupClerk> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessGroupClerk> page(ProcessGroupClerkQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessGroupClerk> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessGroupClerk> listByGroup(Long groupId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean deleteByGroupId(Long groupId) {

        throw new NotImplementedException();
    }
}
