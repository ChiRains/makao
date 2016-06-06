package com.qcloud.component.form.dao.redis;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormTableMappingDao;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.query.FormTableMappingQuery;
@Repository
public class FormTableMappingDaoRedisImpl implements FormTableMappingDao {
    // @Resource(name = "redis-form")
    // private Redis redis;
    @Override
    public boolean add(FormTableMapping formTableMapping) {
        throw new NotImplementedException();
    }

    @Override
    public FormTableMapping get(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(FormTableMapping formTableMapping) {
        throw new NotImplementedException();
    }

    @Override
    public List<FormTableMapping> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, FormTableMapping> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<FormTableMapping> page(int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public Page<FormTableMapping> page(FormTableMappingQuery query, int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public List<FormTableMapping> listAll() {
        throw new NotImplementedException();
    }

    @Override
    public List<FormTableMapping> listAll(Map<String, Object> map) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Map<String, Object> map) {
        throw new NotImplementedException();
    }

    @Override
    public FormTableMapping getByForm(Long formId) {
        throw new NotImplementedException();
    }
}
