package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.web.vo.QuestionnaireVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminQuestionnaireVO;

public interface QuestionnaireHandler {

	List<QuestionnaireVO> toVOList(List<Questionnaire> list);

	QuestionnaireVO toVO(Questionnaire questionnaire);

	List<AdminQuestionnaireVO> toVOList4Admin(List<Questionnaire> list);

	AdminQuestionnaireVO toVO4Admin(Questionnaire questionnaire);
}
