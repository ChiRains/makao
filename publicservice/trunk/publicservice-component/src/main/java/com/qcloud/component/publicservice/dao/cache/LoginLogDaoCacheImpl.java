package com.qcloud.component.publicservice.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.dao.LoginLogDao;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.model.query.LoginLogQuery;

@Repository
public class LoginLogDaoCacheImpl implements LoginLogDao {

    @Autowired
    private LoginLogDao loginLogDaoMysqlImpl;

    @Autowired
    private LoginLogDao loginLogDaoRedisImpl;

    @Override
    public boolean add(LoginLog loginLog) {

        return loginLogDaoMysqlImpl.add(loginLog);
    }

    @Override
    public LoginLog get(Long id) {

        return loginLogDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return loginLogDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(LoginLog loginLog) {

        return loginLogDaoMysqlImpl.update(loginLog);
    }

    @Override
    public List<LoginLog> list(List<Long> idList) {

        return CacheLoader.list(loginLogDaoRedisImpl, loginLogDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, LoginLog> map(Set<Long> idSet) {

        return CacheLoader.map(loginLogDaoRedisImpl, loginLogDaoMysqlImpl, idSet);
    }

    @Override
    public Page<LoginLog> page(int start, int count) {

        return loginLogDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<LoginLog> page(LoginLogQuery query, int start, int count) {

        return loginLogDaoMysqlImpl.page(query, start, count);
    }

    public List<LoginLog> listAll() {

        return loginLogDaoMysqlImpl.listAll();
    }

    @Override
    public List<LoginLog> list(long consumerId, int consumerType, int operate) {

        return loginLogDaoMysqlImpl.list(consumerId, consumerType, operate);
    }
}
