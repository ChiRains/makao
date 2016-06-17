package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.DvrDetailHandler;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.web.vo.DvrDetailVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDvrDetailVO;

@Component
public class DvrDetailHandlerImpl implements DvrDetailHandler {

	@Override
	public List<DvrDetailVO> toVOList(List<DvrDetail> list){
		List<DvrDetailVO> voList = new ArrayList<DvrDetailVO>();
		for (DvrDetail dvrDetail : list) {
			voList.add(toVO(dvrDetail));
		}
		return voList;
	}

	@Override
	public DvrDetailVO toVO(DvrDetail dvrDetail){
		String json = Json.toJson(dvrDetail);
		return Json.toObject(json, DvrDetailVO.class, true);

	}

	@Override
	public List<AdminDvrDetailVO> toVOList4Admin(List<DvrDetail> list){
		List<AdminDvrDetailVO> voList = new ArrayList<AdminDvrDetailVO>();
		for (DvrDetail adminDvrDetail : list) {
			voList.add(toVO4Admin(adminDvrDetail));
		}
		return voList;
	}

	@Override
	public AdminDvrDetailVO toVO4Admin(DvrDetail dvrDetail){
		String json = Json.toJson(dvrDetail);
		return Json.toObject(json, AdminDvrDetailVO.class, true);
	}
}
