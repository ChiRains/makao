package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.IllegalPoliceRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;

@Repository
public class IllegalPoliceRecordDaoCacheImpl implements IllegalPoliceRecordDao {

    @Autowired
    private IllegalPoliceRecordDao illegalPoliceRecordDaoMysqlImpl;

    @Autowired
    private IllegalPoliceRecordDao illegalPoliceRecordDaoRedisImpl;

    @Override
    public boolean add(IllegalPoliceRecord illegalPoliceRecord) {

        return illegalPoliceRecordDaoMysqlImpl.add(illegalPoliceRecord);
    }

    @Override
    public IllegalPoliceRecord get(Long id) {

        return illegalPoliceRecordDaoMysqlImpl.get(id);
        // return CacheLoader.get(illegalPoliceRecordDaoRedisImpl, illegalPoliceRecordDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return illegalPoliceRecordDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(IllegalPoliceRecord illegalPoliceRecord) {

        return illegalPoliceRecordDaoMysqlImpl.update(illegalPoliceRecord);
    }

    @Override
    public List<IllegalPoliceRecord> list(List<Long> idList) {

        return CacheLoader.list(illegalPoliceRecordDaoRedisImpl, illegalPoliceRecordDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, IllegalPoliceRecord> map(Set<Long> idSet) {

        return CacheLoader.map(illegalPoliceRecordDaoRedisImpl, illegalPoliceRecordDaoMysqlImpl, idSet);
    }

    @Override
    public Page<IllegalPoliceRecord> page(int start, int count) {

        return illegalPoliceRecordDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<IllegalPoliceRecord> page(IllegalPoliceRecordQuery query, int start, int count) {

        return illegalPoliceRecordDaoMysqlImpl.page(query, start, count);
    }

    public List<IllegalPoliceRecord> listAll() {

        return illegalPoliceRecordDaoMysqlImpl.listAll();
    }
}
