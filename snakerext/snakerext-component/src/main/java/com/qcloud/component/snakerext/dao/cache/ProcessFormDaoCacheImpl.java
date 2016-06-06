package com.qcloud.component.snakerext.dao.cache;
import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.ProcessFormDao;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
@Repository
public class ProcessFormDaoCacheImpl implements ProcessFormDao {
    @Autowired
    private ProcessFormDao processFormDaoMysqlImpl;
    @Autowired
    private ProcessFormDao processFormDaoRedisImpl;

    @Override
    public boolean add(ProcessForm processForm) {
        return processFormDaoMysqlImpl.add(processForm);
    }

    @Override
    public ProcessForm get(Long id) {
        return processFormDaoMysqlImpl.get(id);
        // return CacheLoader.get(processFormDaoRedisImpl, processFormDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {
        return processFormDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ProcessForm processForm) {
        return processFormDaoMysqlImpl.update(processForm);
    }

    @Override
    public List<ProcessForm> list(List<Long> idList) {
        return CacheLoader.list(processFormDaoRedisImpl, processFormDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ProcessForm> map(Set<Long> idSet) {
        return CacheLoader.map(processFormDaoRedisImpl, processFormDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ProcessForm> page(int start, int count) {
        return processFormDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ProcessForm> page(ProcessFormQuery query, int start, int count) {
        return processFormDaoMysqlImpl.page(query, start, count);
    }

    public List<ProcessForm> listAll() {
        return processFormDaoMysqlImpl.listAll();
    }

    @Override
    public List<ProcessForm> list(Map<String, Object> map) {
        return processFormDaoMysqlImpl.list(map);
    }
}
