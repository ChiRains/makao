package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerEnterprisersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.model.query.CarOwnerEnterprisersQuery;

@Service
public class CarOwnerEnterprisersServiceImpl implements CarOwnerEnterprisersService {

    @Autowired
    private CarOwnerEnterprisersDao carOwnerEnterprisersDao;

    @Autowired
    private AutoIdGenerator         autoIdGenerator;

    @Autowired
    private FileSDKClient           fileSDKClient;

    private static final String     ID_KEY = "macaovehicle_car_owner_enterprisers";

    @Override
    public boolean add(CarOwnerEnterprisers carOwnerEnterprisers) {

        long id = autoIdGenerator.get(ID_KEY);
        carOwnerEnterprisers.setId(id);
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getLicense())) {
            carOwnerEnterprisers.setLicense(fileSDKClient.uidToUrl(carOwnerEnterprisers.getLicense()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getPaymentUrl())) {
            carOwnerEnterprisers.setPaymentUrl(fileSDKClient.uidToUrl(carOwnerEnterprisers.getPaymentUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getCommitmentUrl())) {
            carOwnerEnterprisers.setCommitmentUrl(fileSDKClient.uidToUrl(carOwnerEnterprisers.getCommitmentUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getOppositeUrl())) {
            carOwnerEnterprisers.setOppositeUrl(fileSDKClient.uidToUrl(carOwnerEnterprisers.getOppositeUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getPositiveUrl())) {
            carOwnerEnterprisers.setPositiveUrl(fileSDKClient.uidToUrl(carOwnerEnterprisers.getPositiveUrl()));
        }
        return carOwnerEnterprisersDao.add(carOwnerEnterprisers);
    }

    @Override
    public CarOwnerEnterprisers get(Long id) {

        return carOwnerEnterprisersDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerEnterprisersDao.delete(id);
    }

    @Override
    public boolean update(CarOwnerEnterprisers carOwnerEnterprisers) {

        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getLicense())) {
            carOwnerEnterprisers.setLicense(fileSDKClient.uidToUrl(carOwnerEnterprisers.getLicense()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getTax())) {
            carOwnerEnterprisers.setTax(fileSDKClient.uidToUrl(carOwnerEnterprisers.getTax()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getLetter())) {
            carOwnerEnterprisers.setLetter(fileSDKClient.uidToUrl(carOwnerEnterprisers.getLetter()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getOppositeUrl())) {
            carOwnerEnterprisers.setOppositeUrl(fileSDKClient.uidToUrl(carOwnerEnterprisers.getOppositeUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getPositiveUrl())) {
            carOwnerEnterprisers.setPositiveUrl(fileSDKClient.uidToUrl(carOwnerEnterprisers.getPositiveUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getPaymentUrl())) {
            carOwnerEnterprisers.setPaymentUrl(fileSDKClient.uidToUrl(carOwnerEnterprisers.getPaymentUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerEnterprisers.getCommitmentUrl())) {
            carOwnerEnterprisers.setCommitmentUrl(fileSDKClient.uidToUrl(carOwnerEnterprisers.getCommitmentUrl()));
        }
        return carOwnerEnterprisersDao.update(carOwnerEnterprisers);
    }

    @Override
    public Page<CarOwnerEnterprisers> page(CarOwnerEnterprisersQuery query, int start, int count) {

        return carOwnerEnterprisersDao.page(query, start, count);
    }

    public List<CarOwnerEnterprisers> listAll() {

        return carOwnerEnterprisersDao.listAll();
    }

    @Override
    public CarOwnerEnterprisers getByCarOwner(Long carOwnerId) {

        return carOwnerEnterprisersDao.getByCarOwner(carOwnerId);
    }
}
