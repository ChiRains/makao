package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.query.CarOwnerPurchaseQuery;

public interface CarOwnerPurchaseDao extends ISimpleDao<CarOwnerPurchase, Long> {

    public boolean add(CarOwnerPurchase carOwnerPurchase);

    public CarOwnerPurchase get(Long id);

    public boolean delete(Long id);

    public boolean update(CarOwnerPurchase carOwnerPurchase);

    public List<CarOwnerPurchase> list(List<Long> idList);

    public Map<Long, CarOwnerPurchase> map(Set<Long> idSet);

    public Page<CarOwnerPurchase> page(CarOwnerPurchaseQuery query, int start, int size);

    public List<CarOwnerPurchase> listAll();

    public CarOwnerPurchase getByCarOwner(Long carOwnerId);
}
