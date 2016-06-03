package com.qcloud.component.form.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.ElementFieldMappingDao;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.query.ElementFieldMappingQuery;

@Repository
public class ElementFieldMappingDaoRedisImpl implements ElementFieldMappingDao {

    // @Resource(name = "redis-form")
    // private Redis redis;
    @Override
    public boolean add(ElementFieldMapping elementFieldMapping) {

        throw new NotImplementedException();
    }

    @Override
    public ElementFieldMapping get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ElementFieldMapping elementFieldMapping) {

        throw new NotImplementedException();
    }

    @Override
    public List<ElementFieldMapping> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ElementFieldMapping> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ElementFieldMapping> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ElementFieldMapping> page(ElementFieldMappingQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ElementFieldMapping> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<ElementFieldMapping> listAll(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public ElementFieldMapping getByElement(long elementId) {

        throw new NotImplementedException();
    }

    @Override
    public List<ElementFieldMapping> listByForm(long formId) {

        throw new NotImplementedException();
    }
}
