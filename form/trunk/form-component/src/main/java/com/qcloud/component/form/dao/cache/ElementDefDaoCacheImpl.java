package com.qcloud.component.form.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.ElementDefDao;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.query.ElementDefQuery;

@Repository
public class ElementDefDaoCacheImpl implements ElementDefDao {

    @Autowired
    private ElementDefDao elementDefDaoMysqlImpl;

    @Autowired
    private ElementDefDao elementDefDaoRedisImpl;

    @Override
    public boolean add(ElementDef elementDef) {

        return elementDefDaoMysqlImpl.add(elementDef);
    }

    @Override
    public ElementDef get(Long id) {

        return elementDefDaoMysqlImpl.get(id);
        // return CacheLoader.get(elementDefDaoRedisImpl, elementDefDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return elementDefDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ElementDef elementDef) {

        return elementDefDaoMysqlImpl.update(elementDef);
    }

    @Override
    public List<ElementDef> list(List<Long> idList) {

        return CacheLoader.list(elementDefDaoRedisImpl, elementDefDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ElementDef> map(Set<Long> idSet) {

        return CacheLoader.map(elementDefDaoRedisImpl, elementDefDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ElementDef> page(int start, int count) {

        return elementDefDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ElementDef> page(ElementDefQuery query, int start, int count) {

        return elementDefDaoMysqlImpl.page(query, start, count);
    }

    public List<ElementDef> listAll() {

        return elementDefDaoMysqlImpl.listAll();
    }

    @Override
    public List<ElementDef> listAll(Map<String, Object> map) {

        return elementDefDaoMysqlImpl.listAll(map);
    }

    @Override
    public List<ElementDef> listByForm(Long formId) {

        return elementDefDaoMysqlImpl.listByForm(formId);
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return elementDefDaoMysqlImpl.delete(map);
    }
}
