package com.qcloud.component.form.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormDefDao;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.FormDefQuery;

@Repository
public class FormDefDaoCacheImpl implements FormDefDao {

    @Autowired
    private FormDefDao formDefDaoMysqlImpl;

    @Autowired
    private FormDefDao formDefDaoRedisImpl;

    @Override
    public boolean add(FormDef formDef) {

        return formDefDaoMysqlImpl.add(formDef);
    }

    @Override
    public FormDef get(Long id) {

        return formDefDaoMysqlImpl.get(id);
        // return CacheLoader.get(formDefDaoRedisImpl, formDefDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return formDefDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(FormDef formDef) {

        return formDefDaoMysqlImpl.update(formDef);
    }

    @Override
    public List<FormDef> list(List<Long> idList) {

        return CacheLoader.list(formDefDaoRedisImpl, formDefDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, FormDef> map(Set<Long> idSet) {

        return CacheLoader.map(formDefDaoRedisImpl, formDefDaoMysqlImpl, idSet);
    }

    @Override
    public Page<FormDef> page(int start, int count) {

        return formDefDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<FormDef> page(FormDefQuery query, int start, int count) {

        return formDefDaoMysqlImpl.page(query, start, count);
    }

    public List<FormDef> listAll() {

        return formDefDaoMysqlImpl.listAll();
    }

    @Override
    public List<FormDef> listAll(FormDefQuery query) {

        return formDefDaoMysqlImpl.listAll(query);
    }

    @Override
    public List<FormDef> listChildren(Long id) {

        return formDefDaoMysqlImpl.listChildren(id);
    }
}
