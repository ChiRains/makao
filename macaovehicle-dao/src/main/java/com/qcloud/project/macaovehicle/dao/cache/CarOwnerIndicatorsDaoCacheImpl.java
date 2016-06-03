package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerIndicatorsDao;
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.model.query.CarOwnerIndicatorsQuery;

@Repository
public class CarOwnerIndicatorsDaoCacheImpl implements CarOwnerIndicatorsDao {

    @Autowired
    private CarOwnerIndicatorsDao carOwnerIndicatorsDaoMysqlImpl;

    @Autowired
    private CarOwnerIndicatorsDao carOwnerIndicatorsDaoRedisImpl;

    @Override
    public boolean add(CarOwnerIndicators carOwnerIndicators) {

        return carOwnerIndicatorsDaoMysqlImpl.add(carOwnerIndicators);
    }

    @Override
    public CarOwnerIndicators get(Long id) {

        return CacheLoader.get(carOwnerIndicatorsDaoRedisImpl, carOwnerIndicatorsDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerIndicatorsDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(CarOwnerIndicators carOwnerIndicators) {

        return carOwnerIndicatorsDaoMysqlImpl.update(carOwnerIndicators);
    }

    @Override
    public List<CarOwnerIndicators> list(List<Long> idList) {

        return CacheLoader.list(carOwnerIndicatorsDaoRedisImpl, carOwnerIndicatorsDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, CarOwnerIndicators> map(Set<Long> idSet) {

        return CacheLoader.map(carOwnerIndicatorsDaoRedisImpl, carOwnerIndicatorsDaoMysqlImpl, idSet);
    }

    @Override
    public Page<CarOwnerIndicators> page(int start, int count) {

        return carOwnerIndicatorsDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<CarOwnerIndicators> page(CarOwnerIndicatorsQuery query, int start, int count) {

        return carOwnerIndicatorsDaoMysqlImpl.page(query, start, count);
    }

    public List<CarOwnerIndicators> listAll() {

        return carOwnerIndicatorsDaoMysqlImpl.listAll();
    }

    @Override
    public CarOwnerIndicators getByVehicleId(Long vehicleId) {

        return carOwnerIndicatorsDaoMysqlImpl.getByVehicleId(vehicleId);
    }
}
