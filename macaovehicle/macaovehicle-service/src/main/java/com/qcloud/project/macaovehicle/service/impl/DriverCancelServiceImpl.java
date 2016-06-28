package com.qcloud.project.macaovehicle.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.dao.DriverCancelDao;
import com.qcloud.project.macaovehicle.dao.ProcessProgressDao;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.service.DriverCancelService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;

@Service
public class DriverCancelServiceImpl implements DriverCancelService {

    @Autowired
    private DriverCancelDao        driverCancelDao;

    @Autowired
    private AutoIdGenerator        autoIdGenerator;

    @Autowired
    private ProcessProgressService processProgressService;

    private static final String    ID_KEY = "macaovehicle_driver_cancel";

    @Override
    public boolean add(DriverCancel driverCancel) {

        long id = autoIdGenerator.get(ID_KEY);
        driverCancel.setId(id);
        ProcessProgress processProgress = new ProcessProgress();
        processProgress.setFormInstanceId(-1);
        processProgress.setFormInstCode(driverCancel.getFormInstCode());
        processProgress.setCarOwnerId(driverCancel.getCarOwnerId());
        processProgress.setActivity("注销驾驶员");
        processProgress.setState(ApplyType.PASS.getKey());
        processProgress.setDateStr(DateUtil.date2String(new Date()));
        processProgress.setProgressState(ProgressState.SHENGQIN.getKey());
        processProgress.setType(ProgressType.ZXJSY.getKey());
        processProgress.setVehicleId(-1);
        processProgressService.add(processProgress);
        return driverCancelDao.add(driverCancel);
    }

    @Override
    public DriverCancel get(Long id) {

        return driverCancelDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return driverCancelDao.delete(id);
    }

    @Override
    public boolean update(DriverCancel driverCancel) {

        return driverCancelDao.update(driverCancel);
    }

    @Override
    public Page<DriverCancel> page(DriverCancelQuery query, int start, int count) {

        return driverCancelDao.page(query, start, count);
    }

    public List<DriverCancel> listAll() {

        return driverCancelDao.listAll();
    }

    @Override
    public List<DriverCancel> listByDriver(Long driverId) {

        return driverCancelDao.listByDriver(driverId);
    }

    @Override
    public DriverCancel getByFormInstCode(String formInstCode) {

        return driverCancelDao.getByFormInstCode(formInstCode);
    }
}
