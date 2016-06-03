package com.qcloud.component.publicservice.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.component.publicservice.web.handler.CommonQuestionHandler;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.web.vo.CommonQuestionVO;
import com.qcloud.component.publicservice.web.vo.admin.AdminCommonQuestionVO;

@Component
public class CommonQuestionHandlerImpl implements CommonQuestionHandler {

	@Override
	public List<CommonQuestionVO> toVOList(List<CommonQuestion> list){
		List<CommonQuestionVO> voList = new ArrayList<CommonQuestionVO>();
		for (CommonQuestion commonQuestion : list) {
			voList.add(toVO(commonQuestion));
		}
		return voList;
	}

	@Override
	public CommonQuestionVO toVO(CommonQuestion commonQuestion){
		String json = Json.toJson(commonQuestion);
		CommonQuestionVO vo=Json.toObject(json, CommonQuestionVO.class, true);
		vo.setTimeStr(DateUtil.date2String(vo.getTime(),"yyyy-MM-dd"));
		return vo;

	}

	@Override
	public List<AdminCommonQuestionVO> toVOList4Admin(List<CommonQuestion> list){
		List<AdminCommonQuestionVO> voList = new ArrayList<AdminCommonQuestionVO>();
		for (CommonQuestion adminCommonQuestion : list) {
			voList.add(toVO4Admin(adminCommonQuestion));
		}
		return voList;
	}

	@Override
	public AdminCommonQuestionVO toVO4Admin(CommonQuestion commonQuestion){
		String json = Json.toJson(commonQuestion);
		return Json.toObject(json, AdminCommonQuestionVO.class, true);
	}
}
