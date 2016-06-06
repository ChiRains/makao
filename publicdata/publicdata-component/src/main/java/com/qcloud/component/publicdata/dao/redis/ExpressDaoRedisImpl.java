package com.qcloud.component.publicdata.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.publicdata.dao.ExpressDao;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.query.ExpressQuery;

@Repository
public class ExpressDaoRedisImpl implements ExpressDao {

    // @Resource(name = "redis-publicdata")
    // private Redis redis;
    @Autowired
    private ExpressDao expressDao;

    @Override
    public boolean add(Express express) {

        throw new NotImplementedException();
    }

    @Override
    public Express get(Long id) {

        // return expressDao.get(id);
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Express express) {

        throw new NotImplementedException();
    }

    @Override
    public List<Express> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Express> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Express> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Express> page(ExpressQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Express> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public Express getByCode(String code) {

        throw new NotImplementedException();
    }
}
