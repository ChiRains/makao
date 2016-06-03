package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerAcquisitionDao;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.query.CarOwnerAcquisitionQuery;

@Repository
public class CarOwnerAcquisitionDaoCacheImpl implements CarOwnerAcquisitionDao {

    @Autowired
    private CarOwnerAcquisitionDao carOwnerAcquisitionDaoMysqlImpl;

    @Autowired
    private CarOwnerAcquisitionDao carOwnerAcquisitionDaoRedisImpl;

    @Override
    public boolean add(CarOwnerAcquisition carOwnerAcquisition) {

        return carOwnerAcquisitionDaoMysqlImpl.add(carOwnerAcquisition);
    }

    @Override
    public CarOwnerAcquisition get(Long id) {

        return CacheLoader.get(carOwnerAcquisitionDaoRedisImpl, carOwnerAcquisitionDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerAcquisitionDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(CarOwnerAcquisition carOwnerAcquisition) {

        return carOwnerAcquisitionDaoMysqlImpl.update(carOwnerAcquisition);
    }

    @Override
    public List<CarOwnerAcquisition> list(List<Long> idList) {

        return CacheLoader.list(carOwnerAcquisitionDaoRedisImpl, carOwnerAcquisitionDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, CarOwnerAcquisition> map(Set<Long> idSet) {

        return CacheLoader.map(carOwnerAcquisitionDaoRedisImpl, carOwnerAcquisitionDaoMysqlImpl, idSet);
    }

    @Override
    public Page<CarOwnerAcquisition> page(int start, int count) {

        return carOwnerAcquisitionDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<CarOwnerAcquisition> page(CarOwnerAcquisitionQuery query, int start, int count) {

        return carOwnerAcquisitionDaoMysqlImpl.page(query, start, count);
    }

    public List<CarOwnerAcquisition> listAll() {

        return carOwnerAcquisitionDaoMysqlImpl.listAll();
    }

    @Override
    public CarOwnerAcquisition getByCarOwner(Long carOwnerId) {

        return carOwnerAcquisitionDaoMysqlImpl.getByCarOwner(carOwnerId);
    }
}
