package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.query.CarOwnerAcquisitionQuery;

public interface CarOwnerAcquisitionService {

    public boolean add(CarOwnerAcquisition carOwnerAcquisition);

    public CarOwnerAcquisition get(Long id);

    public boolean delete(Long id);

    public boolean update(CarOwnerAcquisition carOwnerAcquisition);

    public Page<CarOwnerAcquisition> page(CarOwnerAcquisitionQuery query, int start, int count);

    public List<CarOwnerAcquisition> listAll();

    public CarOwnerAcquisition getByCarOwner(Long carOwnerId);
}
