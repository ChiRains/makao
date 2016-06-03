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
import com.qcloud.project.macaovehicle.dao.TaskingCiqDao;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.query.TaskingCiqQuery;

@Repository
public class TaskingCiqDaoRedisImpl implements TaskingCiqDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(TaskingCiq taskingCiq) {

        throw new NotImplementedException();
    }

    @Override
    public TaskingCiq get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(TaskingCiq taskingCiq) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingCiq> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, TaskingCiq> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingCiq> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingCiq> page(TaskingCiqQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingCiq> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public TaskingCiq getByFormInstanceId(Long formInstanceId) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingCiq> listAllByState(int status) {

        throw new NotImplementedException();
    }
}
