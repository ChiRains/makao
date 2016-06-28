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
import com.qcloud.project.macaovehicle.dao.DriverLossDao;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;

@Repository
public class DriverLossDaoRedisImpl implements DriverLossDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(DriverLoss driverLoss) {

        throw new NotImplementedException();
    }

    @Override
    public DriverLoss get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(DriverLoss driverLoss) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverLoss> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DriverLoss> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverLoss> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverLoss> page(DriverLossQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverLoss> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverLoss> listByDriver(Long driverId) {

        throw new NotImplementedException();
    }

    @Override
    public DriverLoss getByFormInstCode(String formInstCode) {

        throw new NotImplementedException();
    }
}
