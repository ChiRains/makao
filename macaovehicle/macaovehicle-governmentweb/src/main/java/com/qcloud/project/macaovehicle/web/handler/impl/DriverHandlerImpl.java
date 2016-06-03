package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.DriverHandler;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.web.vo.DriverVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverVO;

@Component
public class DriverHandlerImpl implements DriverHandler {

	@Override
	public List<DriverVO> toVOList(List<Driver> list){
		List<DriverVO> voList = new ArrayList<DriverVO>();
		for (Driver driver : list) {
			voList.add(toVO(driver));
		}
		return voList;
	}

	@Override
	public DriverVO toVO(Driver driver){
		String json = Json.toJson(driver);
		return Json.toObject(json, DriverVO.class, true);

	}

	@Override
	public List<AdminDriverVO> toVOList4Admin(List<Driver> list){
		List<AdminDriverVO> voList = new ArrayList<AdminDriverVO>();
		for (Driver adminDriver : list) {
			voList.add(toVO4Admin(adminDriver));
		}
		return voList;
	}

	@Override
	public AdminDriverVO toVO4Admin(Driver driver){
		String json = Json.toJson(driver);
		return Json.toObject(json, AdminDriverVO.class, true);
	}
}
