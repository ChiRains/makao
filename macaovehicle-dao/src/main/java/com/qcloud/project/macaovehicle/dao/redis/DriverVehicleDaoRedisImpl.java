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
import com.qcloud.project.macaovehicle.dao.DriverVehicleDao;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;

@Repository
public class DriverVehicleDaoRedisImpl implements DriverVehicleDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(DriverVehicle driverVehicle) {

        throw new NotImplementedException();
    }

    @Override
    public DriverVehicle get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(DriverVehicle driverVehicle) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverVehicle> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DriverVehicle> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverVehicle> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverVehicle> page(DriverVehicleQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverVehicle> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverVehicle> getListByFormInstCode(String formInstCode) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverVehicle> listByQuery(DriverVehicleQuery query) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverVehicle> getListByDriverId(Long driverId, ProgressType progressType) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverVehicle> getListByFormInstanceId(Long formInstanceId) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverVehicle> getListByVehicleId(Long vehicleId, ProgressType progressType) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverVehicle> getListByDriverIc(String driverIc, ProgressType progressType) {

        throw new NotImplementedException();
    }

    @Override
    public int countAllVehicle(Long carOwnerId) {

        throw new NotImplementedException();
    }
}
