package com.qcloud.component.metadata.dao.redis;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.metadata.dao.FieldDao;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.query.FieldQuery;
@Repository
public class FieldDaoRedisImpl implements FieldDao {
    // @Resource(name = "redis-metadata")
    // private Redis redis;
    @Override
    public boolean add(Field field) {
        throw new NotImplementedException();
    }

    @Override
    public Field get(Long id) {
        throw new NotImplementedException();
    }

    // @Resource(name = "redis-metadata")
    // private Redis redis;
    @Override
    public List<Field> listAll(FieldQuery query) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(Field field) {
        throw new NotImplementedException();
    }

    @Override
    public List<Field> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Field> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<Field> page(int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public Page<Field> page(FieldQuery query, int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public List<Field> listAll() {
        throw new NotImplementedException();
    }

    @Override
    public List<Field> listByTable(Long tableId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Field> listByMap(Map<String, Object> map) {
        throw new NotImplementedException();
    }
}
