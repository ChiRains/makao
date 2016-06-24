package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.dao.VehicleDao;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.VehicleState;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao          vehicleDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    @Autowired
    private CarOwnerService     carOwnerService;

    @Autowired
    private FileSDKClient       fileSDKClient;

    private static final String ID_KEY = "macaovehicle_vehicle";

    @Override
    public boolean add(Vehicle vehicle) {

        long id = autoIdGenerator.get(ID_KEY);
        vehicle.setLeftbackImage(fileSDKClient.uidToUrl(vehicle.getLeftbackImage()));
        vehicle.setLeftfaceImage(fileSDKClient.uidToUrl(vehicle.getLeftfaceImage()));
        vehicle.setRightbackImage(fileSDKClient.uidToUrl(vehicle.getRightbackImage()));
        vehicle.setRightfaceImage(fileSDKClient.uidToUrl(vehicle.getRightfaceImage()));
        vehicle.setLicenseImage(fileSDKClient.uidToUrl(vehicle.getLicenseImage()));
        vehicle.setFaceImage(fileSDKClient.uidToUrl(vehicle.getFaceImage()));
        vehicle.setInsuranceUrl(fileSDKClient.uidToUrl(vehicle.getInsuranceUrl()));
        vehicle.setId(id);
        vehicle.setState(VehicleState.NONAPPLY.getKey());
        return vehicleDao.add(vehicle);
    }

    @Override
    public Vehicle get(Long id) {

        return vehicleDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return vehicleDao.delete(id);
    }

    @Override
    public boolean update(Vehicle vehicle) {

        vehicle.setLeftbackImage(fileSDKClient.uidToUrl(vehicle.getLeftbackImage()));
        vehicle.setLeftfaceImage(fileSDKClient.uidToUrl(vehicle.getLeftfaceImage()));
        vehicle.setRightbackImage(fileSDKClient.uidToUrl(vehicle.getRightbackImage()));
        vehicle.setRightfaceImage(fileSDKClient.uidToUrl(vehicle.getRightfaceImage()));
        vehicle.setLicenseImage(fileSDKClient.uidToUrl(vehicle.getLicenseImage()));
        vehicle.setFaceImage(fileSDKClient.uidToUrl(vehicle.getFaceImage()));
        vehicle.setInsuranceUrl(fileSDKClient.uidToUrl(vehicle.getInsuranceUrl()));
        return vehicleDao.update(vehicle);
    }

    @Override
    public Page<Vehicle> page(VehicleQuery query, int start, int count) {

        if (!StringUtil.isEmpty(query.getIdcardNumber())) {
            CarOwner owner = carOwnerService.getByIdcardNumber(query.getIdcardNumber());
            AssertUtil.assertNotNull(owner, "该人员不存在");
            query.setIdcardNumber(owner.getIdcardNumber());
        }
        return vehicleDao.page(query, start, count);
    }

    public List<Vehicle> listAll() {

        return vehicleDao.listAll();
    }

    @Override
    public Vehicle getByPlateNumber(String plateNumber) {

        return vehicleDao.getByPlateNumber(plateNumber);
    }

    @Override
    public List<Vehicle> listByCarOwner(Long carOwnerId) {

        return vehicleDao.listByCarOwner(carOwnerId);
    }

    @Override
    public Vehicle getByRic(String ric) {

        return vehicleDao.getByRic(ric);
    }
}
