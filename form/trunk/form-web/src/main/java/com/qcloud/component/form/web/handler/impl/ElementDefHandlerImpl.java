package com.qcloud.component.form.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.form.web.handler.ElementDefHandler;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.web.vo.ElementDefVO;
import com.qcloud.component.form.web.vo.admin.AdminElementDefVO;

@Component
public class ElementDefHandlerImpl implements ElementDefHandler {

	@Override
	public List<ElementDefVO> toVOList(List<ElementDef> list){
		List<ElementDefVO> voList = new ArrayList<ElementDefVO>();
		for (ElementDef elementDef : list) {
			voList.add(toVO(elementDef));
		}
		return voList;
	}

	@Override
	public ElementDefVO toVO(ElementDef elementDef){
		String json = Json.toJson(elementDef);
		return Json.toObject(json, ElementDefVO.class, true);

	}

	@Override
	public List<AdminElementDefVO> toVOList4Admin(List<ElementDef> list){
		List<AdminElementDefVO> voList = new ArrayList<AdminElementDefVO>();
		for (ElementDef adminElementDef : list) {
			voList.add(toVO4Admin(adminElementDef));
		}
		return voList;
	}

	@Override
	public AdminElementDefVO toVO4Admin(ElementDef elementDef){
		String json = Json.toJson(elementDef);
		return Json.toObject(json, AdminElementDefVO.class, true);
	}
}
