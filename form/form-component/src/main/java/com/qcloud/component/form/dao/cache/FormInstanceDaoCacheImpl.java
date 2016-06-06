package com.qcloud.component.form.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormInstanceDao;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.query.FormInstanceQuery;

@Repository
public class FormInstanceDaoCacheImpl implements FormInstanceDao {

    @Autowired
    private FormInstanceDao formInstanceDaoMysqlImpl;

    // @Autowired
    // private FormInstanceDao formInstanceDaoRedisImpl;
    @Override
    public boolean add(FormInstance formInstance) {

        return formInstanceDaoMysqlImpl.add(formInstance);
    }

    @Override
    public FormInstance get(Long id) {

        return formInstanceDaoMysqlImpl.get(id);
        // return CacheLoader.get(formInstanceDaoRedisImpl, formInstanceDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return formInstanceDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(FormInstance formInstance) {

        return formInstanceDaoMysqlImpl.update(formInstance);
    }

    @Override
    public List<FormInstance> list(List<Long> idList) {

        return CacheLoader.list(formInstanceDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, FormInstance> map(Set<Long> idSet) {

        return CacheLoader.map(formInstanceDaoMysqlImpl, idSet);
    }

    @Override
    public Page<FormInstance> page(int start, int count) {

        return formInstanceDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<FormInstance> page(FormInstanceQuery query, int start, int count) {

        return formInstanceDaoMysqlImpl.page(query, start, count);
    }

    public List<FormInstance> listAll() {

        return formInstanceDaoMysqlImpl.listAll();
    }

    @Override
    public FormInstance getByCode(String code) {

        return formInstanceDaoMysqlImpl.getByCode(code);
    }
}
