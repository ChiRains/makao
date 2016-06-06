package com.qcloud.component.form.dao.redis;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormDefDao;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.FormDefQuery;
@Repository
public class FormDefDaoRedisImpl implements FormDefDao {
    // @Resource(name = "redis-form")
    // private Redis redis;
    @Override
    public boolean add(FormDef formDef) {
        throw new NotImplementedException();
    }

    @Override
    public FormDef get(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(FormDef formDef) {
        throw new NotImplementedException();
    }

    @Override
    public List<FormDef> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, FormDef> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<FormDef> page(int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public Page<FormDef> page(FormDefQuery query, int start, int count) {
        throw new NotImplementedException();
    }

    @Override
    public List<FormDef> listAll() {
        throw new NotImplementedException();
    }

    @Override
    public List<FormDef> listAll(FormDefQuery query) {
        throw new NotImplementedException();
    }

    @Override
    public List<FormDef> listChildren(Long id) {
        throw new NotImplementedException();
    }
}
