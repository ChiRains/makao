package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.web.vo.VehicleLossVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminVehicleLossVO;

public interface VehicleLossHandler {

	List<VehicleLossVO> toVOList(List<VehicleLoss> list);

	VehicleLossVO toVO(VehicleLoss vehicleLoss);

	List<AdminVehicleLossVO> toVOList4Admin(List<VehicleLoss> list);

	AdminVehicleLossVO toVO4Admin(VehicleLoss vehicleLoss);
}
