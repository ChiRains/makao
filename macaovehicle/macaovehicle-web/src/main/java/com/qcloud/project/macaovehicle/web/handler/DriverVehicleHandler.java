package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.web.vo.DriverVehicleVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverVehicleVO;

public interface DriverVehicleHandler {

    List<DriverVehicleVO> toVehicleVOList(List<DriverVehicle> list);

    DriverVehicleVO toVehicleVO(DriverVehicle driverVehicle);

    List<AdminDriverVehicleVO> toVOList4Admin(List<DriverVehicle> list);

    AdminDriverVehicleVO toVO4Admin(DriverVehicle driverVehicle);

    List<DriverVehicleVO> toDriverVOList(List<DriverVehicle> data);

    DriverVehicleVO toDriverVO(DriverVehicle driverVehicle);
}
