package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.VehicleHandler;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.web.vo.VehicleVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminVehicleVO;

@Component
public class VehicleHandlerImpl implements VehicleHandler {

	@Override
	public List<VehicleVO> toVOList(List<Vehicle> list){
		List<VehicleVO> voList = new ArrayList<VehicleVO>();
		for (Vehicle vehicle : list) {
			voList.add(toVO(vehicle));
		}
		return voList;
	}

	@Override
	public VehicleVO toVO(Vehicle vehicle){
		String json = Json.toJson(vehicle);
		return Json.toObject(json, VehicleVO.class, true);

	}

	@Override
	public List<AdminVehicleVO> toVOList4Admin(List<Vehicle> list){
		List<AdminVehicleVO> voList = new ArrayList<AdminVehicleVO>();
		for (Vehicle adminVehicle : list) {
			voList.add(toVO4Admin(adminVehicle));
		}
		return voList;
	}

	@Override
	public AdminVehicleVO toVO4Admin(Vehicle vehicle){
		String json = Json.toJson(vehicle);
		return Json.toObject(json, AdminVehicleVO.class, true);
	}
}
