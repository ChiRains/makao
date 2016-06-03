package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.CarOwnerPurchaseDao;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.query.CarOwnerPurchaseQuery;

@Repository
public class CarOwnerPurchaseDaoRedisImpl implements CarOwnerPurchaseDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(CarOwnerPurchase carOwnerPurchase) {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerPurchase get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(CarOwnerPurchase carOwnerPurchase) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerPurchase> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerPurchase> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerPurchase> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerPurchase> page(CarOwnerPurchaseQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerPurchase> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerPurchase getByCarOwner(Long carOwnerId) {

        throw new NotImplementedException();
    }
}
