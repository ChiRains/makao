package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.query.CarOwnerTalentQuery;

public interface CarOwnerTalentDao extends ISimpleDao<CarOwnerTalent, Long> {

    public boolean add(CarOwnerTalent carOwnerTalent);

    public CarOwnerTalent get(Long id);

    public boolean delete(Long id);

    public boolean update(CarOwnerTalent carOwnerTalent);

    public List<CarOwnerTalent> list(List<Long> idList);

    public Map<Long, CarOwnerTalent> map(Set<Long> idSet);

    public Page<CarOwnerTalent> page(CarOwnerTalentQuery query, int start, int size);

    public List<CarOwnerTalent> listAll();

    public CarOwnerTalent getByCarOwner(Long carOwnerId);
}
