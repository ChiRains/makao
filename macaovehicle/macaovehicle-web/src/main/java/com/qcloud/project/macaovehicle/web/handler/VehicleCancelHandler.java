package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.web.vo.VehicleCancelVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminVehicleCancelVO;

public interface VehicleCancelHandler {

	List<VehicleCancelVO> toVOList(List<VehicleCancel> list);

	VehicleCancelVO toVO(VehicleCancel vehicleCancel);

	List<AdminVehicleCancelVO> toVOList4Admin(List<VehicleCancel> list);

	AdminVehicleCancelVO toVO4Admin(VehicleCancel vehicleCancel);
}
