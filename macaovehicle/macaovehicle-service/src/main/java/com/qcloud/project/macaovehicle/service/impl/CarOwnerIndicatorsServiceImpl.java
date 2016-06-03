package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerIndicatorsDao;
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.service.CarOwnerIndicatorsService;
import com.qcloud.project.macaovehicle.model.query.CarOwnerIndicatorsQuery;

@Service
public class CarOwnerIndicatorsServiceImpl implements CarOwnerIndicatorsService {

    @Autowired
    private CarOwnerIndicatorsDao carOwnerIndicatorsDao;

    @Autowired
    private AutoIdGenerator       autoIdGenerator;

    private static final String   ID_KEY = "macaovehicle_car_owner_indicators";

    @Override
    public boolean add(CarOwnerIndicators carOwnerIndicators) {

        long id = autoIdGenerator.get(ID_KEY);
        carOwnerIndicators.setId(id);
        return carOwnerIndicatorsDao.add(carOwnerIndicators);
    }

    @Override
    public CarOwnerIndicators get(Long id) {

        return carOwnerIndicatorsDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerIndicatorsDao.delete(id);
    }

    @Override
    public boolean update(CarOwnerIndicators carOwnerIndicators) {

        return carOwnerIndicatorsDao.update(carOwnerIndicators);
    }

    @Override
    public Page<CarOwnerIndicators> page(CarOwnerIndicatorsQuery query, int start, int count) {

        return carOwnerIndicatorsDao.page(query, start, count);
    }

    public List<CarOwnerIndicators> listAll() {

        return carOwnerIndicatorsDao.listAll();
    }

    @Override
    public CarOwnerIndicators getByVehicleId(Long vehicleId) {

        return carOwnerIndicatorsDao.getByVehicleId(vehicleId);
    }
}
