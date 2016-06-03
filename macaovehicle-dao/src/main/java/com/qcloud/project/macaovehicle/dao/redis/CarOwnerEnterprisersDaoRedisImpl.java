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
import com.qcloud.project.macaovehicle.dao.CarOwnerEnterprisersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerEnterprisersQuery;

@Repository
public class CarOwnerEnterprisersDaoRedisImpl implements CarOwnerEnterprisersDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(CarOwnerEnterprisers carOwnerEnterprisers) {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerEnterprisers get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(CarOwnerEnterprisers carOwnerEnterprisers) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerEnterprisers> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerEnterprisers> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerEnterprisers> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerEnterprisers> page(CarOwnerEnterprisersQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerEnterprisers> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerEnterprisers getByCarOwner(Long carOwnerId) {

        throw new NotImplementedException();
    }
}
