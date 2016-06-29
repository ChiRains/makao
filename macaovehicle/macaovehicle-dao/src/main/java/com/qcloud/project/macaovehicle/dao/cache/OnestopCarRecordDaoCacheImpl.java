package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.OnestopCarRecordDao;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;

@Repository
public class OnestopCarRecordDaoCacheImpl implements OnestopCarRecordDao {

    @Autowired
    private OnestopCarRecordDao onestopCarRecordDaoMysqlImpl;

    @Autowired
    private OnestopCarRecordDao onestopCarRecordDaoRedisImpl;

    @Override
    public boolean add(OnestopCarRecord onestopCarRecord) {

        return onestopCarRecordDaoMysqlImpl.add(onestopCarRecord);
    }

    @Override
    public OnestopCarRecord get(Long id) {

        return CacheLoader.get(onestopCarRecordDaoRedisImpl, onestopCarRecordDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return onestopCarRecordDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(OnestopCarRecord onestopCarRecord) {

        return onestopCarRecordDaoMysqlImpl.update(onestopCarRecord);
    }

    @Override
    public List<OnestopCarRecord> list(List<Long> idList) {

        return CacheLoader.list(onestopCarRecordDaoRedisImpl, onestopCarRecordDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, OnestopCarRecord> map(Set<Long> idSet) {

        return CacheLoader.map(onestopCarRecordDaoRedisImpl, onestopCarRecordDaoMysqlImpl, idSet);
    }

    @Override
    public Page<OnestopCarRecord> page(int start, int count) {

        return onestopCarRecordDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<OnestopCarRecord> page(OnestopCarRecordQuery query, int start, int count) {

        return onestopCarRecordDaoMysqlImpl.page(query, start, count);
    }

    public List<OnestopCarRecord> listAll() {

        return onestopCarRecordDaoMysqlImpl.listAll();
    }

    @Override
    public OnestopCarRecord getByMap(Map<String, Object> map) {

        return onestopCarRecordDaoMysqlImpl.getByMap(map);
    }

    @Override
    public int getCountByMap(OnestopCarRecordQuery query) {

        return onestopCarRecordDaoMysqlImpl.getCountByMap(query);
    }

    @Override
    public List<OnestopCarRecord> listByQuery(OnestopCarRecordQuery query) {

        return onestopCarRecordDaoMysqlImpl.listByQuery(query);
    }
}
