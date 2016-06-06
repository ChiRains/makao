package com.qcloud.component.form.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.form.web.handler.ElementFieldMappingHandler;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.web.vo.ElementFieldMappingVO;
import com.qcloud.component.form.web.vo.admin.AdminElementFieldMappingVO;

@Component
public class ElementFieldMappingHandlerImpl implements ElementFieldMappingHandler {

	@Override
	public List<ElementFieldMappingVO> toVOList(List<ElementFieldMapping> list){
		List<ElementFieldMappingVO> voList = new ArrayList<ElementFieldMappingVO>();
		for (ElementFieldMapping elementFieldMapping : list) {
			voList.add(toVO(elementFieldMapping));
		}
		return voList;
	}

	@Override
	public ElementFieldMappingVO toVO(ElementFieldMapping elementFieldMapping){
		String json = Json.toJson(elementFieldMapping);
		return Json.toObject(json, ElementFieldMappingVO.class, true);

	}

	@Override
	public List<AdminElementFieldMappingVO> toVOList4Admin(List<ElementFieldMapping> list){
		List<AdminElementFieldMappingVO> voList = new ArrayList<AdminElementFieldMappingVO>();
		for (ElementFieldMapping adminElementFieldMapping : list) {
			voList.add(toVO4Admin(adminElementFieldMapping));
		}
		return voList;
	}

	@Override
	public AdminElementFieldMappingVO toVO4Admin(ElementFieldMapping elementFieldMapping){
		String json = Json.toJson(elementFieldMapping);
		return Json.toObject(json, AdminElementFieldMappingVO.class, true);
	}
}
