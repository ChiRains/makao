package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicdata.web.handler.ProvinceHandler;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.web.vo.ProvinceVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminProvinceVO;

@Component
public class ProvinceHandlerImpl implements ProvinceHandler {

	@Override
	public List<ProvinceVO> toVOList(List<Province> list){
		List<ProvinceVO> voList = new ArrayList<ProvinceVO>();
		for (Province province : list) {
			voList.add(toVO(province));
		}
		return voList;
	}

	@Override
	public ProvinceVO toVO(Province province){
		String json = Json.toJson(province);
		return Json.toObject(json, ProvinceVO.class, true);

	}

	@Override
	public List<AdminProvinceVO> toVOList4Admin(List<Province> list){
		List<AdminProvinceVO> voList = new ArrayList<AdminProvinceVO>();
		for (Province adminProvince : list) {
			voList.add(toVO4Admin(adminProvince));
		}
		return voList;
	}

	@Override
	public AdminProvinceVO toVO4Admin(Province province){
		String json = Json.toJson(province);
		return Json.toObject(json, AdminProvinceVO.class, true);
	}
}
