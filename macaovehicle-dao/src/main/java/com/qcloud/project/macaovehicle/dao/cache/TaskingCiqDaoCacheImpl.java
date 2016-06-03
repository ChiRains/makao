package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.TaskingCiqDao;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.query.TaskingCiqQuery;

@Repository
public class TaskingCiqDaoCacheImpl implements TaskingCiqDao {

    @Autowired
    private TaskingCiqDao taskingCiqDaoMysqlImpl;

    @Autowired
    private TaskingCiqDao taskingCiqDaoRedisImpl;

    @Override
    public boolean add(TaskingCiq taskingCiq) {

        return taskingCiqDaoMysqlImpl.add(taskingCiq);
    }

    @Override
    public TaskingCiq get(Long id) {

        return CacheLoader.get(taskingCiqDaoRedisImpl, taskingCiqDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return taskingCiqDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(TaskingCiq taskingCiq) {

        return taskingCiqDaoMysqlImpl.update(taskingCiq);
    }

    @Override
    public List<TaskingCiq> list(List<Long> idList) {

        return CacheLoader.list(taskingCiqDaoRedisImpl, taskingCiqDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, TaskingCiq> map(Set<Long> idSet) {

        return CacheLoader.map(taskingCiqDaoRedisImpl, taskingCiqDaoMysqlImpl, idSet);
    }

    @Override
    public Page<TaskingCiq> page(int start, int count) {

        return taskingCiqDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<TaskingCiq> page(TaskingCiqQuery query, int start, int count) {

        return taskingCiqDaoMysqlImpl.page(query, start, count);
    }

    public List<TaskingCiq> listAll() {

        return taskingCiqDaoMysqlImpl.listAll();
    }

    @Override
    public TaskingCiq getByFormInstanceId(Long formInstanceId) {

        return taskingCiqDaoMysqlImpl.getByFormInstanceId(formInstanceId);
    }

    @Override
    public List<TaskingCiq> listAllByState(int status) {

        return taskingCiqDaoMysqlImpl.listAllByState(status);
    }
}
