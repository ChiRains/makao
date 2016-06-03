package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHandler;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerVO;

@Component
public class CarOwnerHandlerImpl implements CarOwnerHandler {

	@Override
	public List<CarOwnerVO> toVOList(List<CarOwner> list){
		List<CarOwnerVO> voList = new ArrayList<CarOwnerVO>();
		for (CarOwner carOwner : list) {
			voList.add(toVO(carOwner));
		}
		return voList;
	}

	@Override
	public CarOwnerVO toVO(CarOwner carOwner){
		String json = Json.toJson(carOwner);
		return Json.toObject(json, CarOwnerVO.class, true);

	}

	@Override
	public List<AdminCarOwnerVO> toVOList4Admin(List<CarOwner> list){
		List<AdminCarOwnerVO> voList = new ArrayList<AdminCarOwnerVO>();
		for (CarOwner adminCarOwner : list) {
			voList.add(toVO4Admin(adminCarOwner));
		}
		return voList;
	}

	@Override
	public AdminCarOwnerVO toVO4Admin(CarOwner carOwner){
		String json = Json.toJson(carOwner);
		return Json.toObject(json, AdminCarOwnerVO.class, true);
	}
}
