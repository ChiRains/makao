package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicdata.web.handler.NeighbourhoodHandler;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.web.vo.NeighbourhoodVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminNeighbourhoodVO;

@Component
public class NeighbourhoodHandlerImpl implements NeighbourhoodHandler {

	@Override
	public List<NeighbourhoodVO> toVOList(List<Neighbourhood> list){
		List<NeighbourhoodVO> voList = new ArrayList<NeighbourhoodVO>();
		for (Neighbourhood neighbourhood : list) {
			voList.add(toVO(neighbourhood));
		}
		return voList;
	}

	@Override
	public NeighbourhoodVO toVO(Neighbourhood neighbourhood){
		String json = Json.toJson(neighbourhood);
		return Json.toObject(json, NeighbourhoodVO.class, true);

	}

	@Override
	public List<AdminNeighbourhoodVO> toVOList4Admin(List<Neighbourhood> list){
		List<AdminNeighbourhoodVO> voList = new ArrayList<AdminNeighbourhoodVO>();
		for (Neighbourhood adminNeighbourhood : list) {
			voList.add(toVO4Admin(adminNeighbourhood));
		}
		return voList;
	}

	@Override
	public AdminNeighbourhoodVO toVO4Admin(Neighbourhood neighbourhood){
		String json = Json.toJson(neighbourhood);
		return Json.toObject(json, AdminNeighbourhoodVO.class, true);
	}
}
