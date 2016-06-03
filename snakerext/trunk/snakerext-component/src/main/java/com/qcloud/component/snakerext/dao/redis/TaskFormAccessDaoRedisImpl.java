package com.qcloud.component.snakerext.dao.redis;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.snakerext.dao.TaskFormAccessDao;
import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;
import com.qcloud.pirates.data.Page;
@Repository
public class TaskFormAccessDaoRedisImpl implements TaskFormAccessDao {
    // @Resource(name = "redis-snakerext")
    // private Redis redis;
    @Override
    public boolean add(TaskFormAccess taskFormAccess) {
        throw new NotImplementedException();
    }

    @Override
    public TaskFormAccess get(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(TaskFormAccess taskFormAccess) {
        throw new NotImplementedException();
    }

    @Override
    public List<TaskFormAccess> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, TaskFormAccess> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<TaskFormAccess> page(int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public Page<TaskFormAccess> page(TaskFormAccessQuery query, int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public List<TaskFormAccess> listAll() {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Map<String, Object> map) {
        throw new NotImplementedException();
    }

    @Override
    public List<TaskFormAccess> listAll(Map<String, Object> map) {
        throw new NotImplementedException();
    }
}
