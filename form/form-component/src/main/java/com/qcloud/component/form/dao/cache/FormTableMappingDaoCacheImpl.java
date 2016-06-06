package com.qcloud.component.form.dao.cache;
import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormTableMappingDao;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.query.FormTableMappingQuery;
@Repository
public class FormTableMappingDaoCacheImpl implements FormTableMappingDao {
    @Autowired
    private FormTableMappingDao formTableMappingDaoMysqlImpl;
    @Autowired
    private FormTableMappingDao formTableMappingDaoRedisImpl;

    @Override
    public boolean add(FormTableMapping formTableMapping) {
        return formTableMappingDaoMysqlImpl.add(formTableMapping);
    }

    @Override
    public FormTableMapping get(Long id) {
        return formTableMappingDaoMysqlImpl.get(id);
        // return CacheLoader.get(formTableMappingDaoRedisImpl, formTableMappingDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {
        return formTableMappingDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(FormTableMapping formTableMapping) {
        return formTableMappingDaoMysqlImpl.update(formTableMapping);
    }

    @Override
    public List<FormTableMapping> list(List<Long> idList) {
        return CacheLoader.list(formTableMappingDaoRedisImpl, formTableMappingDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, FormTableMapping> map(Set<Long> idSet) {
        return CacheLoader.map(formTableMappingDaoRedisImpl, formTableMappingDaoMysqlImpl, idSet);
    }

    @Override
    public Page<FormTableMapping> page(int start, int count) {
        return formTableMappingDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<FormTableMapping> page(FormTableMappingQuery query, int start, int count) {
        return formTableMappingDaoMysqlImpl.page(query, start, count);
    }

    public List<FormTableMapping> listAll() {
        return formTableMappingDaoMysqlImpl.listAll();
    }

    @Override
    public List<FormTableMapping> listAll(Map<String, Object> map) {
        return formTableMappingDaoMysqlImpl.listAll(map);
    }

    @Override
    public boolean delete(Map<String, Object> map) {
        return formTableMappingDaoMysqlImpl.delete(map);
    }

    @Override
    public FormTableMapping getByForm(Long formId) {
        return formTableMappingDaoMysqlImpl.getByForm(formId);
    }
}
