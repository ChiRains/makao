package com.qcloud.component.metadata.dao.cache;
import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.metadata.dao.FieldDao;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.query.FieldQuery;
@Repository
public class FieldDaoCacheImpl implements FieldDao {
    @Autowired
    private FieldDao fieldDaoMysqlImpl;
    @Autowired
    private FieldDao fieldDaoRedisImpl;

    @Override
    public boolean add(Field field) {
        return fieldDaoMysqlImpl.add(field);
    }

    @Override
    public Field get(Long id) {
        return fieldDaoMysqlImpl.get(id);
        // return CacheLoader.get(fieldDaoRedisImpl, fieldDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {
        return fieldDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Field field) {
        return fieldDaoMysqlImpl.update(field);
    }

    @Override
    public List<Field> list(List<Long> idList) {
        return CacheLoader.list(fieldDaoRedisImpl, fieldDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Field> map(Set<Long> idSet) {
        return CacheLoader.map(fieldDaoRedisImpl, fieldDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Field> page(int start, int count) {
        return fieldDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Field> page(FieldQuery query, int start, int count) {
        return fieldDaoMysqlImpl.page(query, start, count);
    }

    public List<Field> listAll() {
        return fieldDaoMysqlImpl.listAll();
    }

    @Override
    public List<Field> listAll(FieldQuery query) {
        return fieldDaoMysqlImpl.listAll(query);
    }

    @Override
    public List<Field> listByTable(Long tableId) {
        return fieldDaoMysqlImpl.listByTable(tableId);
    }

    @Override
    public List<Field> listByMap(Map<String, Object> map) {
        return fieldDaoMysqlImpl.listByMap(map);
    }
}
