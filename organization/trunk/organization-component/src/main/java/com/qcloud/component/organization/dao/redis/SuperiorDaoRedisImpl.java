package com.qcloud.component.organization.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.organization.dao.SuperiorDao;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.model.query.SuperiorQuery;

@Repository
public class SuperiorDaoRedisImpl implements SuperiorDao {

    // @Resource(name = "redis-organization")
    // private Redis redis;
    @Override
    public boolean add(Superior superior) {

        throw new NotImplementedException();
    }

    @Override
    public Superior get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Superior superior) {

        throw new NotImplementedException();
    }

    @Override
    public List<Superior> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Superior> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Superior> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Superior> page(SuperiorQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Superior> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public Superior getByClerk(Long clerkId) {

        throw new NotImplementedException();
    }
}
