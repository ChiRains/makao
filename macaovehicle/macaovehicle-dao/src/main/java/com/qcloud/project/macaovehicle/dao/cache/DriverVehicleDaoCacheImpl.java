package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverVehicleDao;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;

@Repository
public class DriverVehicleDaoCacheImpl implements DriverVehicleDao {

    @Autowired
    private DriverVehicleDao driverVehicleDaoMysqlImpl;

    @Autowired
    private DriverVehicleDao driverVehicleDaoRedisImpl;

    @Override
    public boolean add(DriverVehicle driverVehicle) {

        return driverVehicleDaoMysqlImpl.add(driverVehicle);
    }

    @Override
    public DriverVehicle get(Long id) {

        return driverVehicleDaoMysqlImpl.get(id);
        // return CacheLoader.get(driverVehicleDaoRedisImpl, driverVehicleDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return driverVehicleDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(DriverVehicle driverVehicle) {

        return driverVehicleDaoMysqlImpl.update(driverVehicle);
    }

    @Override
    public List<DriverVehicle> list(List<Long> idList) {

        return CacheLoader.list(driverVehicleDaoRedisImpl, driverVehicleDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, DriverVehicle> map(Set<Long> idSet) {

        return CacheLoader.map(driverVehicleDaoRedisImpl, driverVehicleDaoMysqlImpl, idSet);
    }

    @Override
    public Page<DriverVehicle> page(int start, int count) {

        return driverVehicleDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<DriverVehicle> page(DriverVehicleQuery query, int start, int count) {

        return driverVehicleDaoMysqlImpl.page(query, start, count);
    }

    public List<DriverVehicle> listAll() {

        return driverVehicleDaoMysqlImpl.listAll();
    }

    @Override
    public List<DriverVehicle> getListByFormInstCode(String formInstCode) {

        return driverVehicleDaoMysqlImpl.getListByFormInstCode(formInstCode);
    }

    @Override
    public List<DriverVehicle> listByQuery(DriverVehicleQuery query) {

        return driverVehicleDaoMysqlImpl.listByQuery(query);
    }

    @Override
    public List<DriverVehicle> getListByDriverId(Long driverId, ProgressType progressType) {

        return driverVehicleDaoMysqlImpl.getListByDriverId(driverId, progressType);
    }

    @Override
    public List<DriverVehicle> getListByFormInstanceId(Long formInstanceId) {

        return driverVehicleDaoMysqlImpl.getListByFormInstanceId(formInstanceId);
    }

    @Override
    public List<DriverVehicle> getListByVehicleId(Long vehicleId, ProgressType progressType) {

        return driverVehicleDaoMysqlImpl.getListByVehicleId(vehicleId, progressType);
    }

    @Override
    public List<DriverVehicle> getListByDriverIc(String driverIc, ProgressType progressType) {

        return driverVehicleDaoMysqlImpl.getListByDriverIc(driverIc, progressType);
    }

    @Override
    public int countAllVehicle(Long carOwnerId) {

        return driverVehicleDaoMysqlImpl.countAllVehicle(carOwnerId);
    }
}
