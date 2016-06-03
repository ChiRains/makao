package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.organization.web.handler.SuperiorHandler;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.web.vo.SuperiorVO;
import com.qcloud.component.organization.web.vo.admin.AdminSuperiorVO;

@Component
public class SuperiorHandlerImpl implements SuperiorHandler {

	@Override
	public List<SuperiorVO> toVOList(List<Superior> list){
		List<SuperiorVO> voList = new ArrayList<SuperiorVO>();
		for (Superior superior : list) {
			voList.add(toVO(superior));
		}
		return voList;
	}

	@Override
	public SuperiorVO toVO(Superior superior){
		String json = Json.toJson(superior);
		return Json.toObject(json, SuperiorVO.class, true);

	}

	@Override
	public List<AdminSuperiorVO> toVOList4Admin(List<Superior> list){
		List<AdminSuperiorVO> voList = new ArrayList<AdminSuperiorVO>();
		for (Superior adminSuperior : list) {
			voList.add(toVO4Admin(adminSuperior));
		}
		return voList;
	}

	@Override
	public AdminSuperiorVO toVO4Admin(Superior superior){
		String json = Json.toJson(superior);
		return Json.toObject(json, AdminSuperiorVO.class, true);
	}
}
