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
import com.qcloud.project.macaovehicle.dao.VehicleLossDao;
import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.model.query.VehicleLossQuery;

@Repository
public class VehicleLossDaoRedisImpl implements VehicleLossDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(VehicleLoss vehicleLoss) {

        throw new NotImplementedException();
    }

    @Override
    public VehicleLoss get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(VehicleLoss vehicleLoss) {

        throw new NotImplementedException();
    }

    @Override
    public List<VehicleLoss> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, VehicleLoss> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<VehicleLoss> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<VehicleLoss> page(VehicleLossQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<VehicleLoss> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public VehicleLoss getByVehicleId(Long vehicleId) {

        throw new NotImplementedException();
    }
}
