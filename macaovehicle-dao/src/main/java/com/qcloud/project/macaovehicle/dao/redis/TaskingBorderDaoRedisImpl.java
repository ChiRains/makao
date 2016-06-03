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
import com.qcloud.project.macaovehicle.dao.TaskingBorderDao;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;

@Repository
public class TaskingBorderDaoRedisImpl implements TaskingBorderDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(TaskingBorder taskingBorder) {

        throw new NotImplementedException();
    }

    @Override
    public TaskingBorder get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(TaskingBorder taskingBorder) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingBorder> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, TaskingBorder> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingBorder> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingBorder> page(TaskingBorderQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingBorder> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public TaskingBorder getByFormInstanceId(Long formInstanceId) {

        throw new NotImplementedException();
    }

    @Override
    public List<TaskingBorder> listAllByState(int status) {

        throw new NotImplementedException();
    }
}
