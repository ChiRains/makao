package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.TaskingBorderDao;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;

@Repository
public class TaskingBorderDaoCacheImpl implements TaskingBorderDao {

    @Autowired
    private TaskingBorderDao taskingBorderDaoMysqlImpl;

    @Autowired
    private TaskingBorderDao taskingBorderDaoRedisImpl;

    @Override
    public boolean add(TaskingBorder taskingBorder) {

        return taskingBorderDaoMysqlImpl.add(taskingBorder);
    }

    @Override
    public TaskingBorder get(Long id) {

        return CacheLoader.get(taskingBorderDaoRedisImpl, taskingBorderDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return taskingBorderDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(TaskingBorder taskingBorder) {

        return taskingBorderDaoMysqlImpl.update(taskingBorder);
    }

    @Override
    public List<TaskingBorder> list(List<Long> idList) {

        return CacheLoader.list(taskingBorderDaoRedisImpl, taskingBorderDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, TaskingBorder> map(Set<Long> idSet) {

        return CacheLoader.map(taskingBorderDaoRedisImpl, taskingBorderDaoMysqlImpl, idSet);
    }

    @Override
    public Page<TaskingBorder> page(int start, int count) {

        return taskingBorderDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<TaskingBorder> page(TaskingBorderQuery query, int start, int count) {

        return taskingBorderDaoMysqlImpl.page(query, start, count);
    }

    public List<TaskingBorder> listAll() {

        return taskingBorderDaoMysqlImpl.listAll();
    }

    @Override
    public TaskingBorder getByFormInstanceId(Long formInstanceId) {

        return taskingBorderDaoMysqlImpl.getByFormInstanceId(formInstanceId);
    }

    @Override
    public List<TaskingBorder> listAllByState(int status) {

        return taskingBorderDaoMysqlImpl.listAllByState(status);
    }
}
