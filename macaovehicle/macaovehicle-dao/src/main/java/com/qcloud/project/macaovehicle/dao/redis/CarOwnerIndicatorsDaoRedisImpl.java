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
import com.qcloud.project.macaovehicle.dao.CarOwnerIndicatorsDao;
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.model.query.CarOwnerIndicatorsQuery;

@Repository
public class CarOwnerIndicatorsDaoRedisImpl implements CarOwnerIndicatorsDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(CarOwnerIndicators carOwnerIndicators) {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerIndicators get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(CarOwnerIndicators carOwnerIndicators) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerIndicators> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerIndicators> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerIndicators> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerIndicators> page(CarOwnerIndicatorsQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerIndicators> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerIndicators getByVehicleId(Long vehicleId) {

        throw new NotImplementedException();
    }
}
