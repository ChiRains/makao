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
import com.qcloud.project.macaovehicle.dao.PersonnelWarehouseDao;
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.model.query.PersonnelWarehouseQuery;

@Repository
public class PersonnelWarehouseDaoRedisImpl implements PersonnelWarehouseDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(PersonnelWarehouse personnelWarehouse) {

        throw new NotImplementedException();
    }

    @Override
    public PersonnelWarehouse get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(PersonnelWarehouse personnelWarehouse) {

        throw new NotImplementedException();
    }

    @Override
    public List<PersonnelWarehouse> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, PersonnelWarehouse> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<PersonnelWarehouse> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<PersonnelWarehouse> page(PersonnelWarehouseQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<PersonnelWarehouse> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public PersonnelWarehouse getByRegister(String name, String mobile, String idcardNumber) {

        throw new NotImplementedException();
    }
}
