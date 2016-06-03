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
import com.qcloud.project.macaovehicle.dao.CarOwnerWorkersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerWorkersQuery;

@Repository
public class CarOwnerWorkersDaoRedisImpl implements CarOwnerWorkersDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(CarOwnerWorkers carOwnerWorkers) {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerWorkers get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(CarOwnerWorkers carOwnerWorkers) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerWorkers> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerWorkers> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerWorkers> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerWorkers> page(CarOwnerWorkersQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerWorkers> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerWorkers getByCarOwner(Long carOwnerId) {

        throw new NotImplementedException();
    }
}
