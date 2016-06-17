package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.HistoryUserRecordsDao;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;

@Repository
public class HistoryUserRecordsDaoRedisImpl implements HistoryUserRecordsDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(HistoryUserRecords historyUserRecords) {

        throw new NotImplementedException();
    }

    @Override
    public HistoryUserRecords get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(HistoryUserRecords historyUserRecords) {

        throw new NotImplementedException();
    }

    @Override
    public List<HistoryUserRecords> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, HistoryUserRecords> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    public List<HistoryUserRecords> listByVehicleId(Long vehicleId) {

        throw new NotImplementedException();
    }

    @Override
    public Page<HistoryUserRecords> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<HistoryUserRecords> page(HistoryUserRecordsQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<HistoryUserRecords> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public HistoryUserRecords getByFormInstCode(String formInstCode) {

        throw new NotImplementedException();
    }
}
