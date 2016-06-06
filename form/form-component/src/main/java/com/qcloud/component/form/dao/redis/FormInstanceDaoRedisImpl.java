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
import com.qcloud.component.form.dao.FormInstanceDao;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.query.FormInstanceQuery;

@Repository
public class FormInstanceDaoRedisImpl implements FormInstanceDao {

    // @Resource(name = "redis-form")
    // private Redis redis;
    @Override
    public boolean add(FormInstance formInstance) {

        throw new NotImplementedException();
    }

    @Override
    public FormInstance get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(FormInstance formInstance) {

        throw new NotImplementedException();
    }

    @Override
    public List<FormInstance> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, FormInstance> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<FormInstance> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<FormInstance> page(FormInstanceQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<FormInstance> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public FormInstance getByCode(String code) {

        throw new NotImplementedException();
    }
}
