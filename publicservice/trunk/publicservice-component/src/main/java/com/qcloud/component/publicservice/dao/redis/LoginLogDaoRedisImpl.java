package com.qcloud.component.publicservice.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.publicservice.dao.LoginLogDao;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.model.query.LoginLogQuery;

@Repository
public class LoginLogDaoRedisImpl implements LoginLogDao {

    // @Resource(name = "redis-publicservice")
    // private Redis redis;
    @Override
    public boolean add(LoginLog loginLog) {

        throw new NotImplementedException();
    }

    @Override
    public LoginLog get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(LoginLog loginLog) {

        throw new NotImplementedException();
    }

    @Override
    public List<LoginLog> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, LoginLog> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<LoginLog> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<LoginLog> page(LoginLogQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<LoginLog> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<LoginLog> list(long consumerId, int consumerType, int operate) {

        throw new NotImplementedException();
    }
}
