package com.qcloud.component.form.dao.cache;
import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.ElementFieldMappingDao;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.query.ElementFieldMappingQuery;
@Repository
public class ElementFieldMappingDaoCacheImpl implements ElementFieldMappingDao {
    @Autowired
    private ElementFieldMappingDao elementFieldMappingDaoMysqlImpl;
    @Autowired
    private ElementFieldMappingDao elementFieldMappingDaoRedisImpl;

    @Override
    public boolean add(ElementFieldMapping elementFieldMapping) {
        return elementFieldMappingDaoMysqlImpl.add(elementFieldMapping);
    }

    @Override
    public ElementFieldMapping get(Long id) {
        return CacheLoader.get(elementFieldMappingDaoRedisImpl, elementFieldMappingDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {
        return elementFieldMappingDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ElementFieldMapping elementFieldMapping) {
        return elementFieldMappingDaoMysqlImpl.update(elementFieldMapping);
    }

    @Override
    public List<ElementFieldMapping> list(List<Long> idList) {
        return CacheLoader.list(elementFieldMappingDaoRedisImpl, elementFieldMappingDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ElementFieldMapping> map(Set<Long> idSet) {
        return CacheLoader.map(elementFieldMappingDaoRedisImpl, elementFieldMappingDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ElementFieldMapping> page(int start, int count) {
        return elementFieldMappingDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ElementFieldMapping> page(ElementFieldMappingQuery query, int start, int count) {
        return elementFieldMappingDaoMysqlImpl.page(query, start, count);
    }

    public List<ElementFieldMapping> listAll() {
        return elementFieldMappingDaoMysqlImpl.listAll();
    }

    @Override
    public List<ElementFieldMapping> listAll(Map<String, Object> map) {
        return elementFieldMappingDaoMysqlImpl.listAll(map);
    }

    @Override
    public boolean delete(Map<String, Object> map) {
        return elementFieldMappingDaoMysqlImpl.delete(map);
    }

    @Override
    public ElementFieldMapping getByElement(long elementId) {

        return elementFieldMappingDaoMysqlImpl.getByElement(elementId);
    }

    @Override
    public List<ElementFieldMapping> listByForm(long formId) {

        return elementFieldMappingDaoMysqlImpl.listByForm(formId);
    }
}
