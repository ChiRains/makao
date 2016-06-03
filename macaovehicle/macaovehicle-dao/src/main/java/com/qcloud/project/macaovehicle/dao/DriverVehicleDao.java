package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;

public interface DriverVehicleDao extends ISimpleDao<DriverVehicle, Long> {

    public boolean add(DriverVehicle driverVehicle);

    public DriverVehicle get(Long id);

    public boolean delete(Long id);

    public boolean update(DriverVehicle driverVehicle);

    public List<DriverVehicle> list(List<Long> idList);

    public Map<Long, DriverVehicle> map(Set<Long> idSet);

    public Page<DriverVehicle> page(DriverVehicleQuery query, int start, int size);

    public List<DriverVehicle> listAll();

    public List<DriverVehicle> getListByFormInstCode(String formInstCode);

    public List<DriverVehicle> listByQuery(DriverVehicleQuery query);

    public List<DriverVehicle> getListByDriverId(Long driverId, ProgressType progressType);

    public List<DriverVehicle> getListByFormInstanceId(Long formInstanceId);

    public List<DriverVehicle> getListByVehicleId(Long vehicleId, ProgressType progressType);

    public List<DriverVehicle> getListByDriverIc(String driverIc, ProgressType progressType);

    public int countAllVehicle(Long carOwnerId);
}
