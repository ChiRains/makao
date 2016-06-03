package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicdata.web.handler.QuestionnaireHandler;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.web.vo.QuestionnaireVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminQuestionnaireVO;

@Component
public class QuestionnaireHandlerImpl implements QuestionnaireHandler {

	@Override
	public List<QuestionnaireVO> toVOList(List<Questionnaire> list){
		List<QuestionnaireVO> voList = new ArrayList<QuestionnaireVO>();
		for (Questionnaire questionnaire : list) {
			voList.add(toVO(questionnaire));
		}
		return voList;
	}

	@Override
	public QuestionnaireVO toVO(Questionnaire questionnaire){
		String json = Json.toJson(questionnaire);
		return Json.toObject(json, QuestionnaireVO.class, true);

	}

	@Override
	public List<AdminQuestionnaireVO> toVOList4Admin(List<Questionnaire> list){
		List<AdminQuestionnaireVO> voList = new ArrayList<AdminQuestionnaireVO>();
		for (Questionnaire adminQuestionnaire : list) {
			voList.add(toVO4Admin(adminQuestionnaire));
		}
		return voList;
	}

	@Override
	public AdminQuestionnaireVO toVO4Admin(Questionnaire questionnaire){
		String json = Json.toJson(questionnaire);
		return Json.toObject(json, AdminQuestionnaireVO.class, true);
	}
}
