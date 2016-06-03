package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.web.vo.VehicleListVO;
import com.qcloud.project.macaovehicle.web.vo.VehicleVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminVehicleVO;

public interface VehicleHandler {

	List<VehicleVO> toVOList(List<Vehicle> list);

	VehicleVO toVO(Vehicle vehicle);

	List<AdminVehicleVO> toVOList4Admin(List<Vehicle> list);

	AdminVehicleVO toVO4Admin(Vehicle vehicle);
	
	List<VehicleListVO> listToVOList(List<Vehicle> list);
}
