package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.PeccancyCarHandler;
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.web.vo.PeccancyCarVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminPeccancyCarVO;

@Component
public class PeccancyCarHandlerImpl implements PeccancyCarHandler {

	@Override
	public List<PeccancyCarVO> toVOList(List<PeccancyCar> list){
		List<PeccancyCarVO> voList = new ArrayList<PeccancyCarVO>();
		for (PeccancyCar peccancyCar : list) {
			voList.add(toVO(peccancyCar));
		}
		return voList;
	}

	@Override
	public PeccancyCarVO toVO(PeccancyCar peccancyCar){
		String json = Json.toJson(peccancyCar);
		PeccancyCarVO peccancyCarVO=Json.toObject(json, PeccancyCarVO.class, true);
		peccancyCarVO.setTimeFormat(DateUtil.date2String(peccancyCar.getTime(), "yyyy-MM-dd HH:mm:ss"));
		return peccancyCarVO;

	}

	@Override
	public List<AdminPeccancyCarVO> toVOList4Admin(List<PeccancyCar> list){
		List<AdminPeccancyCarVO> voList = new ArrayList<AdminPeccancyCarVO>();
		for (PeccancyCar adminPeccancyCar : list) {
			voList.add(toVO4Admin(adminPeccancyCar));
		}
		return voList;
	}

	@Override
	public AdminPeccancyCarVO toVO4Admin(PeccancyCar peccancyCar){
		String json = Json.toJson(peccancyCar);
		return Json.toObject(json, AdminPeccancyCarVO.class, true);
	}
}
