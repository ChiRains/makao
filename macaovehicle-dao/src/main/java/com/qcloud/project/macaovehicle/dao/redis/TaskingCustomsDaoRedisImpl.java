package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.TaskingCustomsDao;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.query.TaskingCustomsQuery;

@Repository
public class TaskingCustomsDaoRedisImpl implements TaskingCustomsDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(TaskingCustoms taskingCustoms) {

        throw new NotImplementedException();
    }

    @Override
    public TaskingCustoms get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(TaskingCustoms taskingCustoms) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingCustoms> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, TaskingCustoms> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingCustoms> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingCustoms> page(TaskingCustomsQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingCustoms> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public TaskingCustoms getByFormInstanceId(Long formInstanceId) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingCustoms> listAllByState(int status) {

        throw new NotImplementedException();
    }
}
