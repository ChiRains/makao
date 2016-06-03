package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.ProcessProgressDao;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.ProcessProgressQuery;

@Repository
public class ProcessProgressDaoCacheImpl implements ProcessProgressDao {

    @Autowired
    private ProcessProgressDao processProgressDaoMysqlImpl;

    // @Autowired
    // private ProcessProgressDao processProgressDaoRedisImpl;
    @Override
    public boolean add(ProcessProgress processProgress) {

        return processProgressDaoMysqlImpl.add(processProgress);
    }

    @Override
    public ProcessProgress get(Long id) {

        return processProgressDaoMysqlImpl.get(id);
        // return CacheLoader.get(processProgressDaoRedisImpl, processProgressDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return processProgressDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ProcessProgress processProgress) {

        return processProgressDaoMysqlImpl.update(processProgress);
    }

    @Override
    public List<ProcessProgress> list(List<Long> idList) {

        return CacheLoader.list(processProgressDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ProcessProgress> map(Set<Long> idSet) {

        return CacheLoader.map(processProgressDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ProcessProgress> page(int start, int count) {

        return processProgressDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ProcessProgress> page(ProcessProgressQuery query, int start, int count) {

        return processProgressDaoMysqlImpl.page(query, start, count);
    }

    public List<ProcessProgress> listAll() {

        return processProgressDaoMysqlImpl.listAll();
    }

    @Override
    public List<ProcessProgress> listByCarOwnerId(Long clerkId, int start, int count) {

        return processProgressDaoMysqlImpl.listByCarOwnerId(clerkId, start, count);
    }

    @Override
    public ProcessProgress getMaxByFormInstCode(String formInstCode) {

        return processProgressDaoMysqlImpl.getMaxByFormInstCode(formInstCode);
    }

    @Override
    public ProcessProgress get(Long carOwnerId, Long formInstanceId, ProgressType progressType) {

        return processProgressDaoMysqlImpl.get(carOwnerId, formInstanceId, progressType);
    }

    @Override
    public List<ProcessProgress> listByQuery(ProcessProgressQuery query) {

        return processProgressDaoMysqlImpl.listByQuery(query);
    }

    @Override
    public ProcessProgress getByFormInstanceId(Long formInstanceId) {

        return processProgressDaoMysqlImpl.getByFormInstanceId(formInstanceId);
    }

    @Override
    public ProcessProgress get(Long carOwnerId, Long formInstanceId) {

        return processProgressDaoMysqlImpl.get(carOwnerId, formInstanceId);
    }
}
