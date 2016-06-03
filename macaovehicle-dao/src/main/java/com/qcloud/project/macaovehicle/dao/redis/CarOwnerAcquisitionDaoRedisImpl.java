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
import com.qcloud.project.macaovehicle.dao.CarOwnerAcquisitionDao;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.query.CarOwnerAcquisitionQuery;

@Repository
public class CarOwnerAcquisitionDaoRedisImpl implements CarOwnerAcquisitionDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(CarOwnerAcquisition carOwnerAcquisition) {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerAcquisition get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(CarOwnerAcquisition carOwnerAcquisition) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerAcquisition> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerAcquisition> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerAcquisition> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerAcquisition> page(CarOwnerAcquisitionQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerAcquisition> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerAcquisition getByCarOwner(Long carOwnerId) {

        throw new NotImplementedException();
    }
}
