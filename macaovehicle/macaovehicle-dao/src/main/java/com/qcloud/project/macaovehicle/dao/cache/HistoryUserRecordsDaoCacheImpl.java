package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.HistoryUserRecordsDao;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;

@Repository
public class HistoryUserRecordsDaoCacheImpl implements HistoryUserRecordsDao {

    @Autowired
    private HistoryUserRecordsDao historyUserRecordsDaoMysqlImpl;

    @Autowired
    private HistoryUserRecordsDao historyUserRecordsDaoRedisImpl;

    @Override
    public boolean add(HistoryUserRecords historyUserRecords) {

        return historyUserRecordsDaoMysqlImpl.add(historyUserRecords);
    }

    @Override
    public HistoryUserRecords get(Long id) {

        return historyUserRecordsDaoMysqlImpl.get(id);
        // return CacheLoader.get(historyUserRecordsDaoRedisImpl, historyUserRecordsDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return historyUserRecordsDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(HistoryUserRecords historyUserRecords) {

        return historyUserRecordsDaoMysqlImpl.update(historyUserRecords);
    }

    @Override
    public List<HistoryUserRecords> list(List<Long> idList) {

        return CacheLoader.list(historyUserRecordsDaoRedisImpl, historyUserRecordsDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, HistoryUserRecords> map(Set<Long> idSet) {

        return CacheLoader.map(historyUserRecordsDaoRedisImpl, historyUserRecordsDaoMysqlImpl, idSet);
    }

    public List<HistoryUserRecords> listByVehicleId(Long vehicleId) {

        return historyUserRecordsDaoMysqlImpl.listByVehicleId(vehicleId);
    }

    @Override
    public Page<HistoryUserRecords> page(int start, int count) {

        return historyUserRecordsDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<HistoryUserRecords> page(HistoryUserRecordsQuery query, int start, int count) {

        return historyUserRecordsDaoMysqlImpl.page(query, start, count);
    }

    public List<HistoryUserRecords> listAll() {

        return historyUserRecordsDaoMysqlImpl.listAll();
    }

    @Override
    public HistoryUserRecords getByFormInstCode(String formInstCode) {

        return historyUserRecordsDaoMysqlImpl.getByFormInstCode(formInstCode);
    }
}
