package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.model.key.TypeEnum.QuestionType;
import com.qcloud.component.publicdata.service.QuestionnaireService;
import com.qcloud.component.publicdata.web.handler.OptionsHandler;
import com.qcloud.component.publicdata.web.handler.QuestionHandler;
import com.qcloud.component.publicdata.web.vo.QuestionVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminQuestionVO;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class QuestionHandlerImpl implements QuestionHandler {

    @Autowired
    private OptionsHandler optionsHandler;
    
    @Autowired
    private QuestionnaireService questionnaireService;

    @Override
    public List<QuestionVO> toVOList(List<Question> list) {

        List<QuestionVO> voList = new ArrayList<QuestionVO>();
        for (Question question : list) {
            voList.add(toVO(question));
        }
        return voList;
    }

    @Override
    public QuestionVO toVO(Question question) {

        String json = Json.toJson(question);
        return Json.toObject(json, QuestionVO.class, true);
    }

    @Override
    public List<AdminQuestionVO> toVOList4Admin(List<Question> list) {

        List<AdminQuestionVO> voList = new ArrayList<AdminQuestionVO>();
        for (Question adminQuestion : list) {
            voList.add(toVO4Admin(adminQuestion));
        }
        return voList;
    }

    @Override
    public AdminQuestionVO toVO4Admin(Question question) {

        String json = Json.toJson(question);
        AdminQuestionVO vo=Json.toObject(json, AdminQuestionVO.class, true);
        Questionnaire questionnaire = questionnaireService.get(vo.getQuestionnaireId());
        AssertUtil.assertNotNull(questionnaire,"问卷不存在.");
        vo.setQuestionnaireName(questionnaire.getName());
        vo.setTypeStr(QuestionType.getName(vo.getType()));
        return vo;
    }

    @Override
    public List<QuestionVO> toVOList(List<Question> list, List<Options> optionsList) {

        List<QuestionVO> voList = new ArrayList<QuestionVO>();
        for (Question question : list) {
            QuestionVO questionVO = toVO(question);
            List<Options> opList = new ArrayList<Options>();
            for (Options options : optionsList) {
                if (options.getQuestionId() == question.getId()) {
                    opList.add(options);
                }
            }
            questionVO.setList(optionsHandler.toVOList(opList));
            voList.add(questionVO);
        }
        return voList;
    }
}
