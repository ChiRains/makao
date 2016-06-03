package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerTalentDao;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.query.CarOwnerTalentQuery;

@Repository
public class CarOwnerTalentDaoCacheImpl implements CarOwnerTalentDao {

    @Autowired
    private CarOwnerTalentDao carOwnerTalentDaoMysqlImpl;

    @Autowired
    private CarOwnerTalentDao carOwnerTalentDaoRedisImpl;

    @Override
    public boolean add(CarOwnerTalent carOwnerTalent) {

        return carOwnerTalentDaoMysqlImpl.add(carOwnerTalent);
    }

    @Override
    public CarOwnerTalent get(Long id) {

        return carOwnerTalentDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerTalentDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(CarOwnerTalent carOwnerTalent) {

        return carOwnerTalentDaoMysqlImpl.update(carOwnerTalent);
    }

    @Override
    public List<CarOwnerTalent> list(List<Long> idList) {

        return CacheLoader.list(carOwnerTalentDaoRedisImpl, carOwnerTalentDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, CarOwnerTalent> map(Set<Long> idSet) {

        return CacheLoader.map(carOwnerTalentDaoRedisImpl, carOwnerTalentDaoMysqlImpl, idSet);
    }

    @Override
    public Page<CarOwnerTalent> page(int start, int count) {

        return carOwnerTalentDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<CarOwnerTalent> page(CarOwnerTalentQuery query, int start, int count) {

        return carOwnerTalentDaoMysqlImpl.page(query, start, count);
    }

    public List<CarOwnerTalent> listAll() {

        return carOwnerTalentDaoMysqlImpl.listAll();
    }

    @Override
    public CarOwnerTalent getByCarOwner(Long carOwnerId) {

        return carOwnerTalentDaoMysqlImpl.getByCarOwner(carOwnerId);
    }
}
