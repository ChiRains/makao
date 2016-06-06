package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicdata.web.handler.PopularSearchesHandler;
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.web.vo.PopularSearchesVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminPopularSearchesVO;

@Component
public class PopularSearchesHandlerImpl implements PopularSearchesHandler {

	@Override
	public List<PopularSearchesVO> toVOList(List<PopularSearches> list){
		List<PopularSearchesVO> voList = new ArrayList<PopularSearchesVO>();
		for (PopularSearches popularSearches : list) {
			voList.add(toVO(popularSearches));
		}
		return voList;
	}

	@Override
	public PopularSearchesVO toVO(PopularSearches popularSearches){
		String json = Json.toJson(popularSearches);
		return Json.toObject(json, PopularSearchesVO.class, true);

	}

	@Override
	public List<AdminPopularSearchesVO> toVOList4Admin(List<PopularSearches> list){
		List<AdminPopularSearchesVO> voList = new ArrayList<AdminPopularSearchesVO>();
		for (PopularSearches adminPopularSearches : list) {
			voList.add(toVO4Admin(adminPopularSearches));
		}
		return voList;
	}

	@Override
	public AdminPopularSearchesVO toVO4Admin(PopularSearches popularSearches){
		String json = Json.toJson(popularSearches);
		return Json.toObject(json, AdminPopularSearchesVO.class, true);
	}
}
