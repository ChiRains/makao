package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverLossDao;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.service.DriverLossService;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;

@Service
public class DriverLossServiceImpl implements DriverLossService {

    @Autowired
    private DriverLossDao       driverLossDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_driver_loss";

    @Override
    public boolean add(DriverLoss driverLoss) {

        long id = autoIdGenerator.get(ID_KEY);
        driverLoss.setId(id);
        return driverLossDao.add(driverLoss);
    }

    @Override
    public DriverLoss get(Long id) {

        return driverLossDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return driverLossDao.delete(id);
    }

    @Override
    public boolean update(DriverLoss driverLoss) {

        return driverLossDao.update(driverLoss);
    }

    @Override
    public Page<DriverLoss> page(DriverLossQuery query, int start, int count) {

        return driverLossDao.page(query, start, count);
    }

    public List<DriverLoss> listAll() {

        return driverLossDao.listAll();
    }

    @Override
    public DriverLoss getByDriverId(Long driverId) {

        return driverLossDao.getByDriverId(driverId);
    }
}
