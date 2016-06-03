package com.qcloud.component.mvprocesstask.dao.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.component.mvprocesstask.dao.TaskedDao;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.query.TaskedQuery;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;

@Repository
public class TaskedDaoCacheImpl implements TaskedDao {

    @Autowired
    private TaskedDao taskedDaoMysqlImpl;

    // @Autowired
    // private TaskedDao taskedDaoRedisImpl;
    @Override
    public boolean add(Tasked tasked) {

        return taskedDaoMysqlImpl.add(tasked);
    }

    @Override
    public Tasked get(Long id) {

        return taskedDaoMysqlImpl.get(id);
        // return CacheLoader.get(taskedDaoRedisImpl, taskedDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return taskedDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Tasked tasked) {

        return taskedDaoMysqlImpl.update(tasked);
    }

    @Override
    public List<Tasked> list(List<Long> idList) {

        return CacheLoader.list(taskedDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Tasked> map(Set<Long> idSet) {

        return CacheLoader.map(taskedDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Tasked> page(int start, int count) {

        return taskedDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Tasked> page(TaskedQuery query, int start, int count) {

        return taskedDaoMysqlImpl.page(query, start, count);
    }

    public List<Tasked> listAll() {

        return taskedDaoMysqlImpl.listAll();
    }

    @Override
    public Tasked getByWorkitem(String workitemId) {

        return taskedDaoMysqlImpl.getByWorkitem(workitemId);
    }

    @Override
    public List<Tasked> listTaskedByProcessInst(String processInstId) {

        return taskedDaoMysqlImpl.listTaskedByProcessInst(processInstId);
    }

    @Override
    public List<Tasked> listTaskedByFormInstanceId(Long formInstanceId) {

        return taskedDaoMysqlImpl.listTaskedByFormInstanceId(formInstanceId);
    }
}
