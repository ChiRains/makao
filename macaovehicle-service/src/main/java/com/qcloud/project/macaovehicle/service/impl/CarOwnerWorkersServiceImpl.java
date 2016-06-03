package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerWorkersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.service.CarOwnerWorkersService;
import com.qcloud.project.macaovehicle.model.query.CarOwnerWorkersQuery;

@Service
public class CarOwnerWorkersServiceImpl implements CarOwnerWorkersService {

    @Autowired
    private CarOwnerWorkersDao  carOwnerWorkersDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    @Autowired
    private FileSDKClient       fileSDKClient;

    private static final String ID_KEY = "macaovehicle_car_owner_workers";

    @Override
    public boolean add(CarOwnerWorkers carOwnerWorkers) {

        long id = autoIdGenerator.get(ID_KEY);
        carOwnerWorkers.setId(id);
        if (StringUtils.isNotEmpty(carOwnerWorkers.getWorkCertificate())) {
            carOwnerWorkers.setWorkCertificate(fileSDKClient.uidToUrl(carOwnerWorkers.getWorkCertificate()));
        }
        if (StringUtils.isNotEmpty(carOwnerWorkers.getContractUrl())) {
            carOwnerWorkers.setContractUrl(fileSDKClient.uidToUrl(carOwnerWorkers.getContractUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerWorkers.getInsuranceFeeUrl())) {
            carOwnerWorkers.setInsuranceFeeUrl(fileSDKClient.uidToUrl(carOwnerWorkers.getInsuranceFeeUrl()));
        }
        return carOwnerWorkersDao.add(carOwnerWorkers);
    }

    @Override
    public CarOwnerWorkers get(Long id) {

        return carOwnerWorkersDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerWorkersDao.delete(id);
    }

    @Override
    public boolean update(CarOwnerWorkers carOwnerWorkers) {

        if (StringUtils.isNotEmpty(carOwnerWorkers.getWorkCertificate())) {
            carOwnerWorkers.setWorkCertificate(fileSDKClient.uidToUrl(carOwnerWorkers.getWorkCertificate()));
        }
        if (StringUtils.isNotEmpty(carOwnerWorkers.getContractUrl())) {
            carOwnerWorkers.setContractUrl(fileSDKClient.uidToUrl(carOwnerWorkers.getContractUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerWorkers.getInsuranceFeeUrl())) {
            carOwnerWorkers.setInsuranceFeeUrl(fileSDKClient.uidToUrl(carOwnerWorkers.getInsuranceFeeUrl()));
        }
        return carOwnerWorkersDao.update(carOwnerWorkers);
    }

    @Override
    public Page<CarOwnerWorkers> page(CarOwnerWorkersQuery query, int start, int count) {

        return carOwnerWorkersDao.page(query, start, count);
    }

    public List<CarOwnerWorkers> listAll() {

        return carOwnerWorkersDao.listAll();
    }

    @Override
    public CarOwnerWorkers getByCarOwner(Long carOwnerId) {

        return carOwnerWorkersDao.getByCarOwner(carOwnerId);
    }
}
