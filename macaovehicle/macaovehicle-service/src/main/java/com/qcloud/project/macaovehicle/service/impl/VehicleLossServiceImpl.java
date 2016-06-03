package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.VehicleLossDao;
import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.service.VehicleLossService;
import com.qcloud.project.macaovehicle.model.query.VehicleLossQuery;

@Service
public class VehicleLossServiceImpl implements VehicleLossService {

    @Autowired
    private VehicleLossDao      vehicleLossDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_vehicle_loss";

    @Override
    public boolean add(VehicleLoss vehicleLoss) {

        long id = autoIdGenerator.get(ID_KEY);
        vehicleLoss.setId(id);
        return vehicleLossDao.add(vehicleLoss);
    }

    @Override
    public VehicleLoss get(Long id) {

        return vehicleLossDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return vehicleLossDao.delete(id);
    }

    @Override
    public boolean update(VehicleLoss vehicleLoss) {

        return vehicleLossDao.update(vehicleLoss);
    }

    @Override
    public Page<VehicleLoss> page(VehicleLossQuery query, int start, int count) {

        return vehicleLossDao.page(query, start, count);
    }

    public List<VehicleLoss> listAll() {

        return vehicleLossDao.listAll();
    }

    @Override
    public VehicleLoss getByVehicleId(Long vehicleId) {

        return vehicleLossDao.getByVehicleId(vehicleId);
    }
}
