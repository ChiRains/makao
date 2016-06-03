package com.qcloud.component.snakerext.dao.cache;
import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.TaskFormAccessDao;
import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;
@Repository
public class TaskFormAccessDaoCacheImpl implements TaskFormAccessDao {
    @Autowired
    private TaskFormAccessDao taskFormAccessDaoMysqlImpl;
    @Autowired
    private TaskFormAccessDao taskFormAccessDaoRedisImpl;

    @Override
    public boolean add(TaskFormAccess taskFormAccess) {
        return taskFormAccessDaoMysqlImpl.add(taskFormAccess);
    }

    @Override
    public TaskFormAccess get(Long id) {
        return CacheLoader.get(taskFormAccessDaoRedisImpl, taskFormAccessDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {
        return taskFormAccessDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(TaskFormAccess taskFormAccess) {
        return taskFormAccessDaoMysqlImpl.update(taskFormAccess);
    }

    @Override
    public List<TaskFormAccess> list(List<Long> idList) {
        return CacheLoader.list(taskFormAccessDaoRedisImpl, taskFormAccessDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, TaskFormAccess> map(Set<Long> idSet) {
        return CacheLoader.map(taskFormAccessDaoRedisImpl, taskFormAccessDaoMysqlImpl, idSet);
    }

    @Override
    public Page<TaskFormAccess> page(int start, int count) {
        return taskFormAccessDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<TaskFormAccess> page(TaskFormAccessQuery query, int start, int count) {
        return taskFormAccessDaoMysqlImpl.page(query, start, count);
    }

    public List<TaskFormAccess> listAll() {
        return taskFormAccessDaoMysqlImpl.listAll();
    }

    @Override
    public boolean delete(Map<String, Object> map) {
        return taskFormAccessDaoMysqlImpl.delete(map);
    }

    @Override
    public List<TaskFormAccess> listAll(Map<String, Object> map) {
        return taskFormAccessDaoMysqlImpl.listAll(map);
    }
}
