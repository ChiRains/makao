package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.PersonnelWarehouseHandler;
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.web.vo.PersonnelWarehouseVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminPersonnelWarehouseVO;

@Component
public class PersonnelWarehouseHandlerImpl implements PersonnelWarehouseHandler {

	@Override
	public List<PersonnelWarehouseVO> toVOList(List<PersonnelWarehouse> list){
		List<PersonnelWarehouseVO> voList = new ArrayList<PersonnelWarehouseVO>();
		for (PersonnelWarehouse personnelWarehouse : list) {
			voList.add(toVO(personnelWarehouse));
		}
		return voList;
	}

	@Override
	public PersonnelWarehouseVO toVO(PersonnelWarehouse personnelWarehouse){
		String json = Json.toJson(personnelWarehouse);
		return Json.toObject(json, PersonnelWarehouseVO.class, true);

	}

	@Override
	public List<AdminPersonnelWarehouseVO> toVOList4Admin(List<PersonnelWarehouse> list){
		List<AdminPersonnelWarehouseVO> voList = new ArrayList<AdminPersonnelWarehouseVO>();
		for (PersonnelWarehouse adminPersonnelWarehouse : list) {
			voList.add(toVO4Admin(adminPersonnelWarehouse));
		}
		return voList;
	}

	@Override
	public AdminPersonnelWarehouseVO toVO4Admin(PersonnelWarehouse personnelWarehouse){
		String json = Json.toJson(personnelWarehouse);
		return Json.toObject(json, AdminPersonnelWarehouseVO.class, true);
	}
}
