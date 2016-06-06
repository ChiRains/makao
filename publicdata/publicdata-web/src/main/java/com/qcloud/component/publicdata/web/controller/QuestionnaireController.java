package com.qcloud.component.publicdata.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.service.OptionsService;
import com.qcloud.component.publicdata.service.QuestionService;
import com.qcloud.component.publicdata.service.QuestionnaireService;
import com.qcloud.component.publicdata.web.handler.QuestionHandler;
import com.qcloud.component.publicdata.web.vo.QuestionVO;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;

@Controller
@RequestMapping(value = QuestionnaireController.DIR)
public class QuestionnaireController {

    public static final String   DIR = "/questionnaire";

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionService      questionService;

    @Autowired
    private OptionsService       optionsService;

    @Autowired
    private QuestionHandler      questionHandler;

    @RequestMapping
    public FrontAjaxView get(String code) {

        AssertUtil.assertNotEmpty(code, "问卷编码不能为空.");
        Questionnaire questionnaire = questionnaireService.getByCode(code);
        AssertUtil.assertNotNull(questionnaire, "问卷尚未定义." + code);
        //
        List<Question> questionList = questionService.listByQuestionnaire(questionnaire.getId());
        List<Options> optionsList = optionsService.listByQuestionnaire(questionnaire.getId());
        List<QuestionVO> voList = questionHandler.toVOList(questionList, optionsList);
        //
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("list", voList);
        frontAjaxView.addObject("questionnaireId", questionnaire.getId());
        frontAjaxView.addObject("questionnaireName", questionnaire.getName());
        return frontAjaxView;
    }

    @RequestMapping
    public FrontAjaxView getFeedback() {

        return get("pirates-feedback");
    }
}
