package com.qcloud.project.macaovehicle.web.extimpl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.mvprocesstask.web.handler.VehicleGetter;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.common.Constant;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.service.VehicleService;

@Component
public class VehicleGetterImpl implements VehicleGetter {

    @Autowired
    private VehicleService vehicleService;

    @Override
    public Date getValidDate(String plateNumber) {

        Vehicle vehicle = vehicleService.getByPlateNumber(plateNumber);
        AssertUtil.assertNotNull(vehicle, "车牌号不存在." + plateNumber);
        return vehicle.getApproveTime() != null ? DateUtil.addDate(vehicle.getApproveTime(), Constant.VEHICLE_VALID_TIME) : null;
    }
}
