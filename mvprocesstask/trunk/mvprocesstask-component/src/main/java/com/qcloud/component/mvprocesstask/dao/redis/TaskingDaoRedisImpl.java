package com.qcloud.component.mvprocesstask.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.mvprocesstask.dao.TaskingDao;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.model.query.TaskingQuery;
import com.qcloud.pirates.data.Page;

@Repository
public class TaskingDaoRedisImpl implements TaskingDao {

    // @Resource(name = "redis-processtask")
    // private Redis redis;
    @Override
    public boolean add(Tasking tasking) {

        throw new NotImplementedException();
    }

    @Override
    public Tasking get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Tasking tasking) {

        throw new NotImplementedException();
    }

    @Override
    public List<Tasking> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Tasking> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Tasking> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Tasking> page(TaskingQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Tasking> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public Tasking getByWorkitem(String workitemId) {

        throw new NotImplementedException();
    }

    @Override
    public Tasking getByFormInstanceId(Long formInstanceId) {

        throw new NotImplementedException();
    }
}
