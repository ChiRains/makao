package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.DataDictionaryDao;
import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.model.query.DataDictionaryQuery;

@Repository
public class DataDictionaryDaoCacheImpl implements DataDictionaryDao {

    @Autowired
    private DataDictionaryDao dataDictionaryDaoMysqlImpl;

    @Autowired
    private DataDictionaryDao dataDictionaryDaoRedisImpl;

    @Override
    public boolean add(DataDictionary dataDictionary) {

        return dataDictionaryDaoMysqlImpl.add(dataDictionary);
    }

    @Override
    public DataDictionary get(Long id) {

        // return CacheLoader.get(dataDictionaryDaoRedisImpl, dataDictionaryDaoMysqlImpl, id);
        return dataDictionaryDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return dataDictionaryDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(DataDictionary dataDictionary) {

        return dataDictionaryDaoMysqlImpl.update(dataDictionary);
    }

    @Override
    public List<DataDictionary> list(List<Long> idList) {

        return CacheLoader.list(dataDictionaryDaoRedisImpl, dataDictionaryDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, DataDictionary> map(Set<Long> idSet) {

        return CacheLoader.map(dataDictionaryDaoRedisImpl, dataDictionaryDaoMysqlImpl, idSet);
    }

    @Override
    public Page<DataDictionary> page(int start, int count) {

        return dataDictionaryDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<DataDictionary> page(DataDictionaryQuery query, int start, int count) {

        return dataDictionaryDaoMysqlImpl.page(query, start, count);
    }

    @Override
    public List<DataDictionary> listAll(String type) {

        return dataDictionaryDaoMysqlImpl.listAll(type);
    }

    @Override
    public DataDictionary getDataDictionaryByKey(String type, Long key) {

        return dataDictionaryDaoMysqlImpl.getDataDictionaryByKey(type, key);
    }
}
