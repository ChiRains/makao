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
import com.qcloud.project.macaovehicle.dao.OnestopCarRecordDao;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;

@Repository
public class OnestopCarRecordDaoRedisImpl implements OnestopCarRecordDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(OnestopCarRecord onestopCarRecord) {

        throw new NotImplementedException();
    }

    @Override
    public OnestopCarRecord get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(OnestopCarRecord onestopCarRecord) {

        throw new NotImplementedException();
    }

    @Override
    public List<OnestopCarRecord> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, OnestopCarRecord> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<OnestopCarRecord> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<OnestopCarRecord> page(OnestopCarRecordQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<OnestopCarRecord> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public OnestopCarRecord getByMap(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public int getCountByMap(OnestopCarRecordQuery query) {

        throw new NotImplementedException();
    }
}
