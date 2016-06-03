package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerPurchaseDao;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.query.CarOwnerPurchaseQuery;

@Repository
public class CarOwnerPurchaseDaoCacheImpl implements CarOwnerPurchaseDao {

    @Autowired
    private CarOwnerPurchaseDao carOwnerPurchaseDaoMysqlImpl;

    @Autowired
    private CarOwnerPurchaseDao carOwnerPurchaseDaoRedisImpl;

    @Override
    public boolean add(CarOwnerPurchase carOwnerPurchase) {

        return carOwnerPurchaseDaoMysqlImpl.add(carOwnerPurchase);
    }

    @Override
    public CarOwnerPurchase get(Long id) {

        return carOwnerPurchaseDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerPurchaseDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(CarOwnerPurchase carOwnerPurchase) {

        return carOwnerPurchaseDaoMysqlImpl.update(carOwnerPurchase);
    }

    @Override
    public List<CarOwnerPurchase> list(List<Long> idList) {

        return CacheLoader.list(carOwnerPurchaseDaoRedisImpl, carOwnerPurchaseDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, CarOwnerPurchase> map(Set<Long> idSet) {

        return CacheLoader.map(carOwnerPurchaseDaoRedisImpl, carOwnerPurchaseDaoMysqlImpl, idSet);
    }

    @Override
    public Page<CarOwnerPurchase> page(int start, int count) {

        return carOwnerPurchaseDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<CarOwnerPurchase> page(CarOwnerPurchaseQuery query, int start, int count) {

        return carOwnerPurchaseDaoMysqlImpl.page(query, start, count);
    }

    public List<CarOwnerPurchase> listAll() {

        return carOwnerPurchaseDaoMysqlImpl.listAll();
    }

    @Override
    public CarOwnerPurchase getByCarOwner(Long carOwnerId) {

        return carOwnerPurchaseDaoMysqlImpl.getByCarOwner(carOwnerId);
    }
}
