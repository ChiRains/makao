package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicdata.web.handler.DataDictionaryHandler;
import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.web.vo.DataDictionaryVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminDataDictionaryVO;

@Component
public class DataDictionaryHandlerImpl implements DataDictionaryHandler {

	@Override
	public List<DataDictionaryVO> toVOList(List<DataDictionary> list){
		List<DataDictionaryVO> voList = new ArrayList<DataDictionaryVO>();
		for (DataDictionary dataDictionary : list) {
			voList.add(toVO(dataDictionary));
		}
		return voList;
	}

	@Override
	public DataDictionaryVO toVO(DataDictionary dataDictionary){
		String json = Json.toJson(dataDictionary);
		return Json.toObject(json, DataDictionaryVO.class, true);

	}

	@Override
	public List<AdminDataDictionaryVO> toVOList4Admin(List<DataDictionary> list){
		List<AdminDataDictionaryVO> voList = new ArrayList<AdminDataDictionaryVO>();
		for (DataDictionary adminDataDictionary : list) {
			voList.add(toVO4Admin(adminDataDictionary));
		}
		return voList;
	}

	@Override
	public AdminDataDictionaryVO toVO4Admin(DataDictionary dataDictionary){
		String json = Json.toJson(dataDictionary);
		return Json.toObject(json, AdminDataDictionaryVO.class, true);
	}
}
