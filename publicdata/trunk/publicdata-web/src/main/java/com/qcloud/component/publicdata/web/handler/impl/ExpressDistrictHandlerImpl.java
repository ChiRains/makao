package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicdata.web.handler.ExpressDistrictHandler;
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.web.vo.ExpressDistrictVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminExpressDistrictVO;

@Component
public class ExpressDistrictHandlerImpl implements ExpressDistrictHandler {

	@Override
	public List<ExpressDistrictVO> toVOList(List<ExpressDistrict> list){
		List<ExpressDistrictVO> voList = new ArrayList<ExpressDistrictVO>();
		for (ExpressDistrict expressDistrict : list) {
			voList.add(toVO(expressDistrict));
		}
		return voList;
	}

	@Override
	public ExpressDistrictVO toVO(ExpressDistrict expressDistrict){
		String json = Json.toJson(expressDistrict);
		return Json.toObject(json, ExpressDistrictVO.class, true);

	}

	@Override
	public List<AdminExpressDistrictVO> toVOList4Admin(List<ExpressDistrict> list){
		List<AdminExpressDistrictVO> voList = new ArrayList<AdminExpressDistrictVO>();
		for (ExpressDistrict adminExpressDistrict : list) {
			voList.add(toVO4Admin(adminExpressDistrict));
		}
		return voList;
	}

	@Override
	public AdminExpressDistrictVO toVO4Admin(ExpressDistrict expressDistrict){
		String json = Json.toJson(expressDistrict);
		return Json.toObject(json, AdminExpressDistrictVO.class, true);
	}
}
