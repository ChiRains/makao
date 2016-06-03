package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.CarCardHandler;
import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.web.vo.CarCardVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarCardVO;

@Component
public class CarCardHandlerImpl implements CarCardHandler {

	@Override
	public List<CarCardVO> toVOList(List<CarCard> list){
		List<CarCardVO> voList = new ArrayList<CarCardVO>();
		for (CarCard carCard : list) {
			voList.add(toVO(carCard));
		}
		return voList;
	}

	@Override
	public CarCardVO toVO(CarCard carCard){
		String json = Json.toJson(carCard);
		return Json.toObject(json, CarCardVO.class, true);

	}

	@Override
	public List<AdminCarCardVO> toVOList4Admin(List<CarCard> list){
		List<AdminCarCardVO> voList = new ArrayList<AdminCarCardVO>();
		for (CarCard adminCarCard : list) {
			voList.add(toVO4Admin(adminCarCard));
		}
		return voList;
	}

	@Override
	public AdminCarCardVO toVO4Admin(CarCard carCard){
		String json = Json.toJson(carCard);
		return Json.toObject(json, AdminCarCardVO.class, true);
	}
}
