package com.qcloud.component.publicdata.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.publicdata.dao.DataDictionaryDao;
import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.model.query.DataDictionaryQuery;

@Repository
public class DataDictionaryDaoRedisImpl implements DataDictionaryDao {

    // @Resource(name = "redis-publicdata")
    // private Redis redis;
    @Override
    public boolean add(DataDictionary dataDictionary) {

        throw new NotImplementedException();
    }

    @Override
    public DataDictionary get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(DataDictionary dataDictionary) {

        throw new NotImplementedException();
    }

    @Override
    public List<DataDictionary> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DataDictionary> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DataDictionary> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DataDictionary> page(DataDictionaryQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<DataDictionary> listAll(String type) {

        throw new NotImplementedException();
    }

    @Override
    public DataDictionary getDataDictionaryByKey(String type, Long key) {

        throw new NotImplementedException();
    }
}
