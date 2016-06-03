package com.qcloud.component.form.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.form.web.handler.FormDefHandler;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.web.vo.FormDefVO;
import com.qcloud.component.form.web.vo.admin.AdminFormDefVO;

@Component
public class FormDefHandlerImpl implements FormDefHandler {

	@Override
	public List<FormDefVO> toVOList(List<FormDef> list){
		List<FormDefVO> voList = new ArrayList<FormDefVO>();
		for (FormDef formDef : list) {
			voList.add(toVO(formDef));
		}
		return voList;
	}

	@Override
	public FormDefVO toVO(FormDef formDef){
		String json = Json.toJson(formDef);
		return Json.toObject(json, FormDefVO.class, true);

	}

	@Override
	public List<AdminFormDefVO> toVOList4Admin(List<FormDef> list){
		List<AdminFormDefVO> voList = new ArrayList<AdminFormDefVO>();
		for (FormDef adminFormDef : list) {
			voList.add(toVO4Admin(adminFormDef));
		}
		return voList;
	}

	@Override
	public AdminFormDefVO toVO4Admin(FormDef formDef){
		String json = Json.toJson(formDef);
		return Json.toObject(json, AdminFormDefVO.class, true);
	}
}
