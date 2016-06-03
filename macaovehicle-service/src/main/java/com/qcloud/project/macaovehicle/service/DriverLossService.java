package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;

public interface DriverLossService {

    public boolean add(DriverLoss driverLoss);

    public DriverLoss get(Long id);

    public boolean delete(Long id);

    public boolean update(DriverLoss driverLoss);

    public Page<DriverLoss> page(DriverLossQuery query, int start, int count);

    public List<DriverLoss> listAll();

    public DriverLoss getByDriverId(Long driverId);
}
