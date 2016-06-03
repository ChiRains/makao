package com.qcloud.component.form.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.form.dao.ElementDefDao;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.query.ElementDefQuery;

@Repository
public class ElementDefDaoRedisImpl implements ElementDefDao {

    // @Resource(name = "redis-form")
    // private Redis redis;
    @Override
    public boolean add(ElementDef elementDef) {

        throw new NotImplementedException();
    }

    @Override
    public ElementDef get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ElementDef elementDef) {

        throw new NotImplementedException();
    }

    @Override
    public List<ElementDef> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ElementDef> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ElementDef> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ElementDef> page(ElementDefQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ElementDef> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<ElementDef> listAll(Map<String, Object> map) {

        throw new NotImplementedException();
    }

    @Override
    public List<ElementDef> listByForm(Long formId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        throw new NotImplementedException();
    }
}
