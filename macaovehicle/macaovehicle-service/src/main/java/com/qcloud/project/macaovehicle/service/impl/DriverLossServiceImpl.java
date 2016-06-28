package com.qcloud.project.macaovehicle.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.dao.DriverLossDao;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.service.DriverLossService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;

@Service
public class DriverLossServiceImpl implements DriverLossService {

    @Autowired
    private DriverLossDao          driverLossDao;

    @Autowired
    private AutoIdGenerator        autoIdGenerator;

    private static final String    ID_KEY = "macaovehicle_driver_loss";

    @Autowired
    private ProcessProgressService processProgressService;

    @Override
    public boolean add(DriverLoss driverLoss) {

        long id = autoIdGenerator.get(ID_KEY);
        driverLoss.setId(id);
        ProcessProgress processProgress = new ProcessProgress();
        processProgress.setFormInstanceId(-1);
        processProgress.setFormInstCode(driverLoss.getFormInstCode());
        processProgress.setCarOwnerId(driverLoss.getCarOwnerId());
        processProgress.setActivity("补办司机车卡");
        processProgress.setState(ApplyType.PASS.getKey());
        processProgress.setDateStr(DateUtil.date2String(new Date()));
        processProgress.setProgressState(ProgressState.SHENGQIN.getKey());
        processProgress.setType(ProgressType.BBSJK.getKey());
        processProgress.setVehicleId(-1);
        processProgressService.add(processProgress);
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
    public List<DriverLoss> listByDriver(Long driverId) {

        return driverLossDao.listByDriver(driverId);
    }

    @Override
    public DriverLoss getByFormInstCode(String formInstCode) {

        return driverLossDao.getByFormInstCode(formInstCode);
    }
}
