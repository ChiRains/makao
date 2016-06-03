package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;

public interface VehicleService {

    public boolean add(Vehicle vehicle);

    public Vehicle get(Long id);

    public boolean delete(Long id);

    public boolean update(Vehicle vehicle);

    public Page<Vehicle> page(VehicleQuery query, int start, int count);

    public List<Vehicle> listAll();

    public Vehicle getByPlateNumber(String plateNumber);

    public List<Vehicle> listByCarOwner(Long carOwnerId);

    public Vehicle getByRic(String ric);
}
