package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.query.CarOwnerTalentQuery;

public interface CarOwnerTalentService {

    public boolean add(CarOwnerTalent carOwnerTalent);

    public CarOwnerTalent get(Long id);

    public boolean delete(Long id);

    public boolean update(CarOwnerTalent carOwnerTalent);

    public Page<CarOwnerTalent> page(CarOwnerTalentQuery query, int start, int count);

    public List<CarOwnerTalent> listAll();

    public CarOwnerTalent getByCarOwner(Long carOwnerId);
}
