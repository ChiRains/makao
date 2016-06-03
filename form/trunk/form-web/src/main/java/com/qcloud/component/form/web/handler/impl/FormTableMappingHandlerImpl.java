package com.qcloud.component.form.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.form.web.handler.FormTableMappingHandler;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.web.vo.FormTableMappingVO;
import com.qcloud.component.form.web.vo.admin.AdminFormTableMappingVO;

@Component
public class FormTableMappingHandlerImpl implements FormTableMappingHandler {

	@Override
	public List<FormTableMappingVO> toVOList(List<FormTableMapping> list){
		List<FormTableMappingVO> voList = new ArrayList<FormTableMappingVO>();
		for (FormTableMapping formTableMapping : list) {
			voList.add(toVO(formTableMapping));
		}
		return voList;
	}

	@Override
	public FormTableMappingVO toVO(FormTableMapping formTableMapping){
		String json = Json.toJson(formTableMapping);
		return Json.toObject(json, FormTableMappingVO.class, true);

	}

	@Override
	public List<AdminFormTableMappingVO> toVOList4Admin(List<FormTableMapping> list){
		List<AdminFormTableMappingVO> voList = new ArrayList<AdminFormTableMappingVO>();
		for (FormTableMapping adminFormTableMapping : list) {
			voList.add(toVO4Admin(adminFormTableMapping));
		}
		return voList;
	}

	@Override
	public AdminFormTableMappingVO toVO4Admin(FormTableMapping formTableMapping){
		String json = Json.toJson(formTableMapping);
		return Json.toObject(json, AdminFormTableMappingVO.class, true);
	}
}
