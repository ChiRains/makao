package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.model.query.VehicleLossQuery;

public interface VehicleLossDao extends ISimpleDao<VehicleLoss, Long> {

    public boolean add(VehicleLoss vehicleLoss);

    public VehicleLoss get(Long id);

    public boolean delete(Long id);

    public boolean update(VehicleLoss vehicleLoss);

    public List<VehicleLoss> list(List<Long> idList);

    public Map<Long, VehicleLoss> map(Set<Long> idSet);

    public Page<VehicleLoss> page(VehicleLossQuery query, int start, int size);

    public List<VehicleLoss> listAll();

    public VehicleLoss getByVehicleId(Long vehicleId);
}
