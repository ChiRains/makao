package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.DvrAreaHandler;
import com.qcloud.project.macaovehicle.web.handler.DvrDetailHandler;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.service.DvrAreaService;
import com.qcloud.project.macaovehicle.service.DvrDetailService;
import com.qcloud.project.macaovehicle.web.vo.DvrAreaVO;
import com.qcloud.project.macaovehicle.web.vo.DvrDetailVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDvrAreaVO;

@Component
public class DvrAreaHandlerImpl implements DvrAreaHandler {

	@Autowired
	private DvrDetailService dvrDetailService;
	@Autowired
	private DvrDetailHandler dvrDetailHandler;

	@Override
	public List<DvrAreaVO> toVOList(List<DvrArea> list) {
		List<DvrAreaVO> voList = new ArrayList<DvrAreaVO>();
		for (DvrArea dvrArea : list) {
			voList.add(toVO(dvrArea));
		}
		return voList;
	}

	@Override
	public DvrAreaVO toVO(DvrArea dvrArea) {
		String json = Json.toJson(dvrArea);
		DvrAreaVO vo = Json.toObject(json, DvrAreaVO.class, true);
		List<DvrDetail> dvrDetails = dvrDetailService.getByArea(dvrArea.getId());
		vo.setList(dvrDetailHandler.toVOList(dvrDetails));
		return vo;
	}

	@Override
	public List<AdminDvrAreaVO> toVOList4Admin(List<DvrArea> list) {
		List<AdminDvrAreaVO> voList = new ArrayList<AdminDvrAreaVO>();
		for (DvrArea adminDvrArea : list) {
			voList.add(toVO4Admin(adminDvrArea));
		}
		return voList;
	}

	@Override
	public AdminDvrAreaVO toVO4Admin(DvrArea dvrArea) {
		String json = Json.toJson(dvrArea);
		return Json.toObject(json, AdminDvrAreaVO.class, true);
	}
}
