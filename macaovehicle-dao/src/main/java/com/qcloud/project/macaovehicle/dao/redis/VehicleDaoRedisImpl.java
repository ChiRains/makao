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
import com.qcloud.project.macaovehicle.dao.VehicleDao;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;

@Repository
public class VehicleDaoRedisImpl implements VehicleDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(Vehicle vehicle) {

        throw new NotImplementedException();
    }

    @Override
    public Vehicle get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(Vehicle vehicle) {

        throw new NotImplementedException();
    }

    @Override
    public List<Vehicle> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Vehicle> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Vehicle> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Vehicle> page(VehicleQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<Vehicle> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public Vehicle getByPlateNumber(String plateNumber) {

        throw new NotImplementedException();
    }

    @Override
    public List<Vehicle> listByCarOwner(Long carOwnerId) {

        throw new NotImplementedException();
    }

    @Override
    public Vehicle getByRic(String ric) {

        throw new NotImplementedException();
    }
}
