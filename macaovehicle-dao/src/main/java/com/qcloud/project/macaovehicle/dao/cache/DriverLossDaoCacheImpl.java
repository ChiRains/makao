package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverLossDao;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;

@Repository
public class DriverLossDaoCacheImpl implements DriverLossDao {

    @Autowired
    private DriverLossDao driverLossDaoMysqlImpl;

    @Autowired
    private DriverLossDao driverLossDaoRedisImpl;

    @Override
    public boolean add(DriverLoss driverLoss) {

        return driverLossDaoMysqlImpl.add(driverLoss);
    }

    @Override
    public DriverLoss get(Long id) {

        return driverLossDaoMysqlImpl.get(id);
        // return CacheLoader.get(driverLossDaoRedisImpl, driverLossDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return driverLossDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(DriverLoss driverLoss) {

        return driverLossDaoMysqlImpl.update(driverLoss);
    }

    @Override
    public List<DriverLoss> list(List<Long> idList) {

        return CacheLoader.list(driverLossDaoRedisImpl, driverLossDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, DriverLoss> map(Set<Long> idSet) {

        return CacheLoader.map(driverLossDaoRedisImpl, driverLossDaoMysqlImpl, idSet);
    }

    @Override
    public Page<DriverLoss> page(int start, int count) {

        return driverLossDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<DriverLoss> page(DriverLossQuery query, int start, int count) {

        return driverLossDaoMysqlImpl.page(query, start, count);
    }

    public List<DriverLoss> listAll() {

        return driverLossDaoMysqlImpl.listAll();
    }

    @Override
    public DriverLoss getByDriverId(Long driverId) {

        return driverLossDaoMysqlImpl.getByDriverId(driverId);
    }
}
