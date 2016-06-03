package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerHousersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.service.CarOwnerHousersService;
import com.qcloud.project.macaovehicle.model.query.CarOwnerHousersQuery;

@Service
public class CarOwnerHousersServiceImpl implements CarOwnerHousersService {

    @Autowired
    private CarOwnerHousersDao  carOwnerHousersDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;
    
    @Autowired
    private FileSDKClient fileSDKClient;

    private static final String ID_KEY = "macaovehicle_car_owner_housers";

    @Override
    public boolean add(CarOwnerHousers carOwnerHousers) {

        long id = autoIdGenerator.get(ID_KEY);
        carOwnerHousers.setId(id);
        if (StringUtils.isNotEmpty(carOwnerHousers.getLicenseUrl())) {
        	carOwnerHousers.setLicenseUrl(fileSDKClient.uidToUrl(carOwnerHousers.getLicenseUrl()));
        }
        return carOwnerHousersDao.add(carOwnerHousers);
    }

    @Override
    public CarOwnerHousers get(Long id) {

        return carOwnerHousersDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerHousersDao.delete(id);
    }

    @Override
    public boolean update(CarOwnerHousers carOwnerHousers) {

        if (StringUtils.isNotEmpty(carOwnerHousers.getLicenseUrl())) {
        	carOwnerHousers.setLicenseUrl(fileSDKClient.uidToUrl(carOwnerHousers.getLicenseUrl()));
        }
        return carOwnerHousersDao.update(carOwnerHousers);
    }

    @Override
    public Page<CarOwnerHousers> page(CarOwnerHousersQuery query, int start, int count) {

        return carOwnerHousersDao.page(query, start, count);
    }

    public List<CarOwnerHousers> listAll() {

        return carOwnerHousersDao.listAll();
    }

    @Override
    public CarOwnerHousers getByCarOwner(Long userId) {

        return carOwnerHousersDao.getByCarOwner(userId);
    }
}
