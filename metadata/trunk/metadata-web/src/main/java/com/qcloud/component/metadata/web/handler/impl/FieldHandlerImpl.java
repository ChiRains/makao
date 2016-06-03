package com.qcloud.component.metadata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.metadata.web.handler.FieldHandler;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.web.vo.FieldVO;
import com.qcloud.component.metadata.web.vo.admin.AdminFieldVO;

@Component
public class FieldHandlerImpl implements FieldHandler {

	@Override
	public List<FieldVO> toVOList(List<Field> list){
		List<FieldVO> voList = new ArrayList<FieldVO>();
		for (Field field : list) {
			voList.add(toVO(field));
		}
		return voList;
	}

	@Override
	public FieldVO toVO(Field field){
		String json = Json.toJson(field);
		return Json.toObject(json, FieldVO.class, true);

	}

	@Override
	public List<AdminFieldVO> toVOList4Admin(List<Field> list){
		List<AdminFieldVO> voList = new ArrayList<AdminFieldVO>();
		for (Field adminField : list) {
			voList.add(toVO4Admin(adminField));
		}
		return voList;
	}

	@Override
	public AdminFieldVO toVO4Admin(Field field){
		String json = Json.toJson(field);
		return Json.toObject(json, AdminFieldVO.class, true);
	}
}
