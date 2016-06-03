package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.model.query.CarOwnerIndicatorsQuery;

public interface CarOwnerIndicatorsService {

    public boolean add(CarOwnerIndicators carOwnerIndicators);

    public CarOwnerIndicators get(Long id);

    public boolean delete(Long id);

    public boolean update(CarOwnerIndicators carOwnerIndicators);

    public Page<CarOwnerIndicators> page(CarOwnerIndicatorsQuery query, int start, int count);

    public List<CarOwnerIndicators> listAll();

    public CarOwnerIndicators getByVehicleId(Long vehicleId);
}
