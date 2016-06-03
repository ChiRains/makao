package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.VehicleDao;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;

@Repository
public class VehicleDaoCacheImpl implements VehicleDao {

    @Autowired
    private VehicleDao vehicleDaoMysqlImpl;

    @Override
    public Vehicle get(Long id) {

        return vehicleDaoMysqlImpl.get(id);
    }

    @Autowired
    private VehicleDao vehicleDaoRedisImpl;

    @Override
    public boolean add(Vehicle vehicle) {

        return vehicleDaoMysqlImpl.add(vehicle);
    }

    @Override
    public boolean delete(Long id) {

        return vehicleDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(Vehicle vehicle) {

        return vehicleDaoMysqlImpl.update(vehicle);
    }

    @Override
    public List<Vehicle> list(List<Long> idList) {

        return CacheLoader.list(vehicleDaoRedisImpl, vehicleDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, Vehicle> map(Set<Long> idSet) {

        return CacheLoader.map(vehicleDaoRedisImpl, vehicleDaoMysqlImpl, idSet);
    }

    @Override
    public Page<Vehicle> page(int start, int count) {

        return vehicleDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<Vehicle> page(VehicleQuery query, int start, int count) {

        return vehicleDaoMysqlImpl.page(query, start, count);
    }

    public List<Vehicle> listAll() {

        return vehicleDaoMysqlImpl.listAll();
    }

    @Override
    public Vehicle getByPlateNumber(String plateNumber) {

        return vehicleDaoMysqlImpl.getByPlateNumber(plateNumber);
    }

    @Override
    public List<Vehicle> listByCarOwner(Long carOwnerId) {

        return vehicleDaoMysqlImpl.listByCarOwner(carOwnerId);
    }

    @Override
    public Vehicle getByRic(String ric) {

        return vehicleDaoMysqlImpl.getByRic(ric);
    }
}
