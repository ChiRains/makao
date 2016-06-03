package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.model.query.CarOwnerIndicatorsQuery;

public interface CarOwnerIndicatorsDao extends ISimpleDao<CarOwnerIndicators, Long> {

    public boolean add(CarOwnerIndicators carOwnerIndicators);

    public CarOwnerIndicators get(Long id);

    public boolean delete(Long id);

    public boolean update(CarOwnerIndicators carOwnerIndicators);

    public List<CarOwnerIndicators> list(List<Long> idList);

    public Map<Long, CarOwnerIndicators> map(Set<Long> idSet);

    public Page<CarOwnerIndicators> page(CarOwnerIndicatorsQuery query, int start, int size);

    public List<CarOwnerIndicators> listAll();

    public CarOwnerIndicators getByVehicleId(Long vehicleId);
}
