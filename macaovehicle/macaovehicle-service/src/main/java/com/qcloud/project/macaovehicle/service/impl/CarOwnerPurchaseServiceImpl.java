package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerPurchaseDao;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.service.CarOwnerPurchaseService;
import com.qcloud.project.macaovehicle.model.query.CarOwnerPurchaseQuery;

@Service
public class CarOwnerPurchaseServiceImpl implements CarOwnerPurchaseService {

    @Autowired
    private CarOwnerPurchaseDao carOwnerPurchaseDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_car_owner_purchase";

    @Autowired
    private FileSDKClient       fileSDKClient;

    @Override
    public boolean add(CarOwnerPurchase carOwnerPurchase) {

        long id = autoIdGenerator.get(ID_KEY);
        carOwnerPurchase.setId(id);
        if (StringUtils.isNotEmpty(carOwnerPurchase.getLicense())) {
            carOwnerPurchase.setLicense(fileSDKClient.uidToUrl(carOwnerPurchase.getLicense()));
        }
        if (StringUtils.isNotEmpty(carOwnerPurchase.getTax())) {
            carOwnerPurchase.setTax(fileSDKClient.uidToUrl(carOwnerPurchase.getTax()));
        }
        if (StringUtils.isNotEmpty(carOwnerPurchase.getLetter())) {
            carOwnerPurchase.setLetter(fileSDKClient.uidToUrl(carOwnerPurchase.getLetter()));
        }
        return carOwnerPurchaseDao.add(carOwnerPurchase);
    }

    @Override
    public CarOwnerPurchase get(Long id) {

        return carOwnerPurchaseDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerPurchaseDao.delete(id);
    }

    @Override
    public boolean update(CarOwnerPurchase carOwnerPurchase) {

        if (StringUtils.isNotEmpty(carOwnerPurchase.getLicense())) {
            carOwnerPurchase.setLicense(fileSDKClient.uidToUrl(carOwnerPurchase.getLicense()));
        }
        if (StringUtils.isNotEmpty(carOwnerPurchase.getTax())) {
            carOwnerPurchase.setTax(fileSDKClient.uidToUrl(carOwnerPurchase.getTax()));
        }
        if (StringUtils.isNotEmpty(carOwnerPurchase.getLetter())) {
            carOwnerPurchase.setLetter(fileSDKClient.uidToUrl(carOwnerPurchase.getLetter()));
        }
        return carOwnerPurchaseDao.update(carOwnerPurchase);
    }

    @Override
    public Page<CarOwnerPurchase> page(CarOwnerPurchaseQuery query, int start, int count) {

        return carOwnerPurchaseDao.page(query, start, count);
    }

    public List<CarOwnerPurchase> listAll() {

        return carOwnerPurchaseDao.listAll();
    }

    @Override
    public CarOwnerPurchase getByCarOwner(Long carOwnerId) {

        return carOwnerPurchaseDao.getByCarOwner(carOwnerId);
    }
}
