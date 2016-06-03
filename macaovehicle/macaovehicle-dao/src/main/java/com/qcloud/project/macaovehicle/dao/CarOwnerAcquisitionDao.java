package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.query.CarOwnerAcquisitionQuery;

public interface CarOwnerAcquisitionDao extends ISimpleDao<CarOwnerAcquisition, Long> {

    public boolean add(CarOwnerAcquisition carOwnerAcquisition);

    public CarOwnerAcquisition get(Long id);

    public boolean delete(Long id);

    public boolean update(CarOwnerAcquisition carOwnerAcquisition);

    public List<CarOwnerAcquisition> list(List<Long> idList);

    public Map<Long, CarOwnerAcquisition> map(Set<Long> idSet);

    public Page<CarOwnerAcquisition> page(CarOwnerAcquisitionQuery query, int start, int size);

    public List<CarOwnerAcquisition> listAll();

    public CarOwnerAcquisition getByCarOwner(Long carOwnerId);
}
