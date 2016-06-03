package com.qcloud.component.processtask.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.processtask.dao.TaskedDao;
import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.model.query.TaskedQuery;

@Repository
public class TaskedDaoRedisImpl implements TaskedDao {

    // @Resource(name = "redis-processtask")
    // private Redis redis;
    @Override
    public boolean add(Tasked tasked) {

        throw new NotImplementedException();
    }

    @Override
    public Tasked get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Tasked tasked) {

        throw new NotImplementedException();
    }

    @Override
    public List<Tasked> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Tasked> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Tasked> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Tasked> page(TaskedQuery query, int myApply, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Tasked> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<Tasked> listTaskedByProcessInst(String processInstId) {
        
        throw new NotImplementedException();
    }

    @Override
    public Tasked getByWorkitem(String workitemId) {
        
        throw new NotImplementedException();
    }
}
