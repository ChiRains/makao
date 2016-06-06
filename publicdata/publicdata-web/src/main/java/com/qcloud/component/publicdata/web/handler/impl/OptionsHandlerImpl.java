package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicdata.web.handler.OptionsHandler;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.web.vo.OptionsVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminOptionsVO;

@Component
public class OptionsHandlerImpl implements OptionsHandler {

	@Override
	public List<OptionsVO> toVOList(List<Options> list){
		List<OptionsVO> voList = new ArrayList<OptionsVO>();
		for (Options options : list) {
			voList.add(toVO(options));
		}
		return voList;
	}

	@Override
	public OptionsVO toVO(Options options){
		String json = Json.toJson(options);
		return Json.toObject(json, OptionsVO.class, true);

	}

	@Override
	public List<AdminOptionsVO> toVOList4Admin(List<Options> list){
		List<AdminOptionsVO> voList = new ArrayList<AdminOptionsVO>();
		for (Options adminOptions : list) {
			voList.add(toVO4Admin(adminOptions));
		}
		return voList;
	}

	@Override
	public AdminOptionsVO toVO4Admin(Options options){
		String json = Json.toJson(options);
		return Json.toObject(json, AdminOptionsVO.class, true);
	}
}
