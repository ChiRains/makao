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
import com.qcloud.project.macaovehicle.dao.CarOwnerTalentDao;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.query.CarOwnerTalentQuery;

@Repository
public class CarOwnerTalentDaoRedisImpl implements CarOwnerTalentDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(CarOwnerTalent carOwnerTalent) {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerTalent get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(CarOwnerTalent carOwnerTalent) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerTalent> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerTalent> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerTalent> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerTalent> page(CarOwnerTalentQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<CarOwnerTalent> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public CarOwnerTalent getByCarOwner(Long carOwnerId) {

        throw new NotImplementedException();
    }
}
