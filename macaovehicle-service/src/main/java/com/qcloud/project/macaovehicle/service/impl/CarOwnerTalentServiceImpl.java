package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerTalentDao;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.service.CarOwnerTalentService;
import com.qcloud.project.macaovehicle.model.query.CarOwnerTalentQuery;

@Service
public class CarOwnerTalentServiceImpl implements CarOwnerTalentService {

    @Autowired
    private CarOwnerTalentDao   carOwnerTalentDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    @Autowired
    private FileSDKClient       fileSDKClient;

    private static final String ID_KEY = "macaovehicle_car_owner_talent";

    @Override
    public boolean add(CarOwnerTalent carOwnerTalent) {

        long id = autoIdGenerator.get(ID_KEY);
        carOwnerTalent.setId(id);
        if (StringUtils.isNotEmpty(carOwnerTalent.getWorkCertificate())) {
            carOwnerTalent.setWorkCertificate(fileSDKClient.uidToUrl(carOwnerTalent.getWorkCertificate()));
        }
        if (StringUtils.isNotEmpty(carOwnerTalent.getDeptCertificateUrl())) {
            carOwnerTalent.setDeptCertificateUrl(fileSDKClient.uidToUrl(carOwnerTalent.getDeptCertificateUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerTalent.getInsuranceFeeUrl())) {
            carOwnerTalent.setInsuranceFeeUrl(fileSDKClient.uidToUrl(carOwnerTalent.getInsuranceFeeUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerTalent.getContractUrl())) {
            carOwnerTalent.setContractUrl(fileSDKClient.uidToUrl(carOwnerTalent.getContractUrl()));
        }
        return carOwnerTalentDao.add(carOwnerTalent);
    }

    @Override
    public CarOwnerTalent get(Long id) {

        return carOwnerTalentDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerTalentDao.delete(id);
    }

    @Override
    public boolean update(CarOwnerTalent carOwnerTalent) {

        if (StringUtils.isNotEmpty(carOwnerTalent.getWorkCertificate())) {
            carOwnerTalent.setWorkCertificate(fileSDKClient.uidToUrl(carOwnerTalent.getWorkCertificate()));
        }
        if (StringUtils.isNotEmpty(carOwnerTalent.getDeptCertificateUrl())) {
            carOwnerTalent.setDeptCertificateUrl(fileSDKClient.uidToUrl(carOwnerTalent.getDeptCertificateUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerTalent.getInsuranceFeeUrl())) {
            carOwnerTalent.setInsuranceFeeUrl(fileSDKClient.uidToUrl(carOwnerTalent.getInsuranceFeeUrl()));
        }
        if (StringUtils.isNotEmpty(carOwnerTalent.getContractUrl())) {
            carOwnerTalent.setContractUrl(fileSDKClient.uidToUrl(carOwnerTalent.getContractUrl()));
        }
        return carOwnerTalentDao.update(carOwnerTalent);
    }

    @Override
    public Page<CarOwnerTalent> page(CarOwnerTalentQuery query, int start, int count) {

        return carOwnerTalentDao.page(query, start, count);
    }

    public List<CarOwnerTalent> listAll() {

        return carOwnerTalentDao.listAll();
    }

    @Override
    public CarOwnerTalent getByCarOwner(Long carOwnerId) {

        return carOwnerTalentDao.getByCarOwner(carOwnerId);
    }
}
