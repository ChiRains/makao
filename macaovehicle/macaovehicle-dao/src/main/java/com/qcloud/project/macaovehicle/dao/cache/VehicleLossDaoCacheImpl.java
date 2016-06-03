package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.VehicleLossDao;
import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.model.query.VehicleLossQuery;

@Repository
public class VehicleLossDaoCacheImpl implements VehicleLossDao {

    @Autowired
    private VehicleLossDao vehicleLossDaoMysqlImpl;

    @Autowired
    private VehicleLossDao vehicleLossDaoRedisImpl;

    @Override
    public boolean add(VehicleLoss vehicleLoss) {

        return vehicleLossDaoMysqlImpl.add(vehicleLoss);
    }

    @Override
    public VehicleLoss get(Long id) {

        return vehicleLossDaoMysqlImpl.get(id);
//        return CacheLoader.get(vehicleLossDaoRedisImpl, vehicleLossDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return vehicleLossDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(VehicleLoss vehicleLoss) {

        return vehicleLossDaoMysqlImpl.update(vehicleLoss);
    }

    @Override
    public List<VehicleLoss> list(List<Long> idList) {

        return CacheLoader.list(vehicleLossDaoRedisImpl, vehicleLossDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, VehicleLoss> map(Set<Long> idSet) {

        return CacheLoader.map(vehicleLossDaoRedisImpl, vehicleLossDaoMysqlImpl, idSet);
    }

    @Override
    public Page<VehicleLoss> page(int start, int count) {

        return vehicleLossDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<VehicleLoss> page(VehicleLossQuery query, int start, int count) {

        return vehicleLossDaoMysqlImpl.page(query, start, count);
    }

    public List<VehicleLoss> listAll() {

        return vehicleLossDaoMysqlImpl.listAll();
    }

    @Override
    public VehicleLoss getByVehicleId(Long vehicleId) {

        return vehicleLossDaoMysqlImpl.getByVehicleId(vehicleId);
    }
}
