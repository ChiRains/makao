package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.model.query.VehicleLossQuery;

public interface VehicleLossService {

    public boolean add(VehicleLoss vehicleLoss);

    public VehicleLoss get(Long id);

    public boolean delete(Long id);

    public boolean update(VehicleLoss vehicleLoss);

    public Page<VehicleLoss> page(VehicleLossQuery query, int start, int count);

    public List<VehicleLoss> listAll();

    public VehicleLoss getByVehicleId(Long vehicleId);
}
