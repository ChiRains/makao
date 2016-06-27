package com.qcloud.project.macaovehicle.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.dao.VehicleCancelDao;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.VehicleCancelService;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.VehicleCancelQuery;

@Service
public class VehicleCancelServiceImpl implements VehicleCancelService {

    @Autowired
    private VehicleCancelDao       vehicleCancelDao;

    @Autowired
    private AutoIdGenerator        autoIdGenerator;

    @Autowired
    private ProcessProgressService processProgressService;

    private static final String    ID_KEY = "macaovehicle_vehicle_cancel";

    @Override
    public boolean add(VehicleCancel vehicleCancel) {

        long id = autoIdGenerator.get(ID_KEY);
        vehicleCancel.setId(id);
        ProcessProgress processProgress = new ProcessProgress();
        processProgress.setFormInstanceId(-1);
        processProgress.setFormInstCode(vehicleCancel.getFormInstCode());
        processProgress.setCarOwnerId(vehicleCancel.getCarOwnerId());
        processProgress.setActivity("注销车辆");
        processProgress.setState(ApplyType.PASS.getKey());
        processProgress.setDateStr(DateUtil.date2String(new Date()));
        processProgress.setProgressState(ProgressState.SHENGQIN.getKey());
        processProgress.setType(ProgressType.ZXCL.getKey());
        processProgressService.add(processProgress);
        return vehicleCancelDao.add(vehicleCancel);
    }

    @Override
    public VehicleCancel get(Long id) {

        return vehicleCancelDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return vehicleCancelDao.delete(id);
    }

    @Override
    public boolean update(VehicleCancel vehicleCancel) {

        return vehicleCancelDao.update(vehicleCancel);
    }

    @Override
    public Page<VehicleCancel> page(VehicleCancelQuery query, int start, int count) {

        return vehicleCancelDao.page(query, start, count);
    }

    public List<VehicleCancel> listAll() {

        return vehicleCancelDao.listAll();
    }
}
