package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.DriverDao;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;

@Repository
public class DriverDaoRedisImpl implements DriverDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(Driver driver) {

        throw new NotImplementedException();
    }

    @Override
    public Driver get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Driver driver) {

        throw new NotImplementedException();
    }

    @Override
    public List<Driver> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Driver> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Driver> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Driver> page(DriverQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Driver> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<Driver> listByCarOwner(Long carOwnerId) {

        throw new NotImplementedException();
    }

    @Override
    public Driver getByName(String name, long carOwnerId) {

        throw new NotImplementedException();
    }

    @Override
    public List<Driver> listByCarOwner(Long carOwnerId, EnableType driverIcState) {

        throw new NotImplementedException();
    }
}
