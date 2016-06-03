package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.IllegalCarRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;

@Repository
public class IllegalCarRecordDaoCacheImpl implements IllegalCarRecordDao {

    @Autowired
    private IllegalCarRecordDao illegalCarRecordDaoMysqlImpl;

    @Autowired
    private IllegalCarRecordDao illegalCarRecordDaoRedisImpl;

    @Override
    public boolean add(IllegalCarRecord illegalCarRecord) {

        return illegalCarRecordDaoMysqlImpl.add(illegalCarRecord);
    }

    @Override
    public IllegalCarRecord get(Long id) {

        return illegalCarRecordDaoMysqlImpl.get(id);
        // return CacheLoader.get(illegalCarRecordDaoRedisImpl, illegalCarRecordDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return illegalCarRecordDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(IllegalCarRecord illegalCarRecord) {

        return illegalCarRecordDaoMysqlImpl.update(illegalCarRecord);
    }

    @Override
    public List<IllegalCarRecord> list(List<Long> idList) {

        return CacheLoader.list(illegalCarRecordDaoRedisImpl, illegalCarRecordDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, IllegalCarRecord> map(Set<Long> idSet) {

        return CacheLoader.map(illegalCarRecordDaoRedisImpl, illegalCarRecordDaoMysqlImpl, idSet);
    }

    @Override
    public Page<IllegalCarRecord> page(int start, int count) {

        return illegalCarRecordDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<IllegalCarRecord> page(IllegalCarRecordQuery query, int start, int count) {

        return illegalCarRecordDaoMysqlImpl.page(query, start, count);
    }

    public List<IllegalCarRecord> listAll() {

        return illegalCarRecordDaoMysqlImpl.listAll();
    }
}
