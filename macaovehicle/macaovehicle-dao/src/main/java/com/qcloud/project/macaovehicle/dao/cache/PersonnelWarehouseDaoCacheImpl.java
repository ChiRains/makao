package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.PersonnelWarehouseDao;
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.model.query.PersonnelWarehouseQuery;

@Repository
public class PersonnelWarehouseDaoCacheImpl implements PersonnelWarehouseDao {

    @Autowired
    private PersonnelWarehouseDao personnelWarehouseDaoMysqlImpl;

    @Autowired
    private PersonnelWarehouseDao personnelWarehouseDaoRedisImpl;

    @Override
    public boolean add(PersonnelWarehouse personnelWarehouse) {

        return personnelWarehouseDaoMysqlImpl.add(personnelWarehouse);
    }

    @Override
    public PersonnelWarehouse get(Long id) {

        return personnelWarehouseDaoMysqlImpl.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return personnelWarehouseDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(PersonnelWarehouse personnelWarehouse) {

        return personnelWarehouseDaoMysqlImpl.update(personnelWarehouse);
    }

    @Override
    public List<PersonnelWarehouse> list(List<Long> idList) {

        return CacheLoader.list(personnelWarehouseDaoRedisImpl, personnelWarehouseDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, PersonnelWarehouse> map(Set<Long> idSet) {

        return CacheLoader.map(personnelWarehouseDaoRedisImpl, personnelWarehouseDaoMysqlImpl, idSet);
    }

    @Override
    public Page<PersonnelWarehouse> page(int start, int count) {

        return personnelWarehouseDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<PersonnelWarehouse> page(PersonnelWarehouseQuery query, int start, int count) {

        return personnelWarehouseDaoMysqlImpl.page(query, start, count);
    }

    public List<PersonnelWarehouse> listAll() {

        return personnelWarehouseDaoMysqlImpl.listAll();
    }

    @Override
    public PersonnelWarehouse getByRegister(String name, String mobile, String idcardNumber) {

        return personnelWarehouseDaoMysqlImpl.getByRegister(name, mobile, idcardNumber);
    }
}
