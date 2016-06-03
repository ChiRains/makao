package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverDao;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;

@Repository
public class DriverDaoCacheImpl implements DriverDao {

    @Autowired
    private DriverDao driverDaoMysqlImpl;

    @Autowired
    private DriverDao driverDaoRedisImpl;

    @Override
    public boolean add(Driver driver) {

        return driverDaoMysqlImpl.add(driver);
    }

    @Override
    public Driver get(Long id) {

        return driverDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return driverDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Driver driver) {

        return driverDaoMysqlImpl.update(driver);
    }

    @Override
    public List<Driver> list(List<Long> idList) {

        return CacheLoader.list(driverDaoRedisImpl, driverDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Driver> map(Set<Long> idSet) {

        return CacheLoader.map(driverDaoRedisImpl, driverDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Driver> page(int start, int count) {

        return driverDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Driver> page(DriverQuery query, int start, int count) {

        return driverDaoMysqlImpl.page(query, start, count);
    }

    public List<Driver> listAll() {

        return driverDaoMysqlImpl.listAll();
    }

    @Override
    public List<Driver> listByCarOwner(Long carOwnerId) {

        return driverDaoMysqlImpl.listByCarOwner(carOwnerId);
    }

    @Override
    public Driver getByName(String name, long carOwnerId) {

        return driverDaoMysqlImpl.getByName(name, carOwnerId);
    }

    @Override
    public List<Driver> listByCarOwner(Long carOwnerId, EnableType driverIcState) {

        return driverDaoMysqlImpl.listByCarOwner(carOwnerId, driverIcState);
    }
}
