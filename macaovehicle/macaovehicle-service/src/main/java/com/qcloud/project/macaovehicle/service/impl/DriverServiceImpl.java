package com.qcloud.project.macaovehicle.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverDao;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.DriverState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;
import com.qcloud.project.macaovehicle.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverDao           driverDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    @Autowired
    private FileSDKClient       fileSDKClient;

    private static final String ID_KEY = "macaovehicle_driver";

    @Override
    public boolean add(Driver driver) {

        long id = autoIdGenerator.get(ID_KEY);
        driver.setId(id);
        driver.setInchImage(fileSDKClient.uidToUrl(driver.getInchImage()));
        driver.setIdcardBack(fileSDKClient.uidToUrl(driver.getIdcardBack()));
        driver.setIdcardFace(fileSDKClient.uidToUrl(driver.getIdcardFace()));
        driver.setLicenseImage(fileSDKClient.uidToUrl(driver.getLicenseImage()));
        driver.setCertificateUrl(fileSDKClient.uidToUrl(driver.getCertificateUrl()));
        driver.setHealthCardImg(fileSDKClient.uidToUrl(driver.getHealthCardImg()));
        driver.setUpdateTime(new Date());
        driver.setState(DriverState.NONAPPLY.getKey());
        return driverDao.add(driver);
    }

    @Override
    public Driver get(Long id) {

        return driverDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return driverDao.delete(id);
    }

    @Override
    public boolean update(Driver driver) {

        driver.setIdcardBack(fileSDKClient.uidToUrl(driver.getIdcardBack()));
        driver.setIdcardFace(fileSDKClient.uidToUrl(driver.getIdcardFace()));
        driver.setLicenseImage(fileSDKClient.uidToUrl(driver.getLicenseImage()));
        driver.setInchImage(fileSDKClient.uidToUrl(driver.getInchImage()));
        driver.setCertificateUrl(fileSDKClient.uidToUrl(driver.getCertificateUrl()));
        driver.setHealthCardImg(fileSDKClient.uidToUrl(driver.getHealthCardImg()));
        return driverDao.update(driver);
    }

    @Override
    public Page<Driver> page(DriverQuery query, int start, int count) {

        return driverDao.page(query, start, count);
    }

    public List<Driver> listAll() {

        return driverDao.listAll();
    }

    @Override
    public List<Driver> listByCarOwner(Long carOwnerId) {

        return driverDao.listByCarOwner(carOwnerId);
    }

    @Override
    public Driver getByName(String name, long carOwnerId) {

        return driverDao.getByName(name, carOwnerId);
    }

    @Override
    public List<Driver> listByCarOwner(Long carOwnerId, EnableType driverIcState) {

        return driverDao.listByCarOwner(carOwnerId, driverIcState);
    }
}
