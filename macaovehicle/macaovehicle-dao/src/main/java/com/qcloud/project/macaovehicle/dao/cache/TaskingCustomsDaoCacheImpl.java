package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.TaskingCustomsDao;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.query.TaskingCustomsQuery;

@Repository
public class TaskingCustomsDaoCacheImpl implements TaskingCustomsDao {

    @Autowired
    private TaskingCustomsDao taskingCustomsDaoMysqlImpl;

    @Autowired
    private TaskingCustomsDao taskingCustomsDaoRedisImpl;

    @Override
    public boolean add(TaskingCustoms taskingCustoms) {

        return taskingCustomsDaoMysqlImpl.add(taskingCustoms);
    }

    @Override
    public TaskingCustoms get(Long id) {

        return CacheLoader.get(taskingCustomsDaoRedisImpl, taskingCustomsDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return taskingCustomsDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(TaskingCustoms taskingCustoms) {

        return taskingCustomsDaoMysqlImpl.update(taskingCustoms);
    }

    @Override
    public List<TaskingCustoms> list(List<Long> idList) {

        return CacheLoader.list(taskingCustomsDaoRedisImpl, taskingCustomsDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, TaskingCustoms> map(Set<Long> idSet) {

        return CacheLoader.map(taskingCustomsDaoRedisImpl, taskingCustomsDaoMysqlImpl, idSet);
    }

    @Override
    public Page<TaskingCustoms> page(int start, int count) {

        return taskingCustomsDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<TaskingCustoms> page(TaskingCustomsQuery query, int start, int count) {

        return taskingCustomsDaoMysqlImpl.page(query, start, count);
    }

    public List<TaskingCustoms> listAll() {

        return taskingCustomsDaoMysqlImpl.listAll();
    }

    @Override
    public TaskingCustoms getByFormInstanceId(Long formInstanceId) {

        return taskingCustomsDaoMysqlImpl.getByFormInstanceId(formInstanceId);
    }

    @Override
    public List<TaskingCustoms> listAllByState(int status) {

        return taskingCustomsDaoMysqlImpl.listAllByState(status);
    }
}
