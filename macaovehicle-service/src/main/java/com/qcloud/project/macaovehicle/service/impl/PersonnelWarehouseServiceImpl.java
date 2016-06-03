package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.PersonnelWarehouseDao;
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.service.PersonnelWarehouseService;
import com.qcloud.project.macaovehicle.model.query.PersonnelWarehouseQuery;

@Service
public class PersonnelWarehouseServiceImpl implements PersonnelWarehouseService {

    @Autowired
    private PersonnelWarehouseDao personnelWarehouseDao;

    @Autowired
    private AutoIdGenerator       autoIdGenerator;

    private static final String   ID_KEY = "macaovehicle_personnel_warehouse";

    @Override
    public boolean add(PersonnelWarehouse personnelWarehouse) {

        long id = autoIdGenerator.get(ID_KEY);
        personnelWarehouse.setId(id);
        return personnelWarehouseDao.add(personnelWarehouse);
    }

    @Override
    public PersonnelWarehouse get(Long id) {

        return personnelWarehouseDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return personnelWarehouseDao.delete(id);
    }

    @Override
    public boolean update(PersonnelWarehouse personnelWarehouse) {

        return personnelWarehouseDao.update(personnelWarehouse);
    }

    @Override
    public Page<PersonnelWarehouse> page(PersonnelWarehouseQuery query, int start, int count) {

        return personnelWarehouseDao.page(query, start, count);
    }

    public List<PersonnelWarehouse> listAll() {

        return personnelWarehouseDao.listAll();
    }

    @Override
    public PersonnelWarehouse getByRegister(String name, String mobile, String idcardNumber) {

        return personnelWarehouseDao.getByRegister(name, mobile, idcardNumber);
    }
}
