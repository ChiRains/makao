package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;

public interface VehicleDao extends ISimpleDao<Vehicle, Long> {

    public boolean add(Vehicle vehicle);

    public Vehicle get(Long id);

    public boolean delete(Long id);

    public boolean update(Vehicle vehicle);

    public List<Vehicle> list(List<Long> idList);

    public Map<Long, Vehicle> map(Set<Long> idSet);

    public Page<Vehicle> page(VehicleQuery query, int start, int size);

    public List<Vehicle> listAll();

    public Vehicle getByPlateNumber(String plateNumber);

    public List<Vehicle> listByCarOwner(Long carOwnerId);

    public Vehicle getByRic(String ric);
}
