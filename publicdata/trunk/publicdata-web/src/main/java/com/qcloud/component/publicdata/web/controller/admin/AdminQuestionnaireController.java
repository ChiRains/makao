package com.qcloud.component.publicdata.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.service.QuestionnaireService;
import com.qcloud.component.publicdata.web.handler.QuestionnaireHandler;
import com.qcloud.component.publicdata.model.query.QuestionnaireQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminQuestionnaireVO;

@Controller
@RequestMapping(value = "/" + AdminQuestionnaireController.DIR)
public class AdminQuestionnaireController {

    public static final String   DIR = "admin/questionnaire";

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionnaireHandler questionnaireHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(HttpServletRequest request, Integer pageNum, PPage pPage, QuestionnaireQuery query) {

        Page<Questionnaire> page = questionnaireService.page(query, pPage.getPageStart(), pPage.getPageSize());
        List<AdminQuestionnaireVO> list = questionnaireHandler.toVOList4Admin(page.getData());
        String pageQueryStr = StringUtil.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
        AcePagingView pagingView = new AcePagingView("/admin/publicdata-Questionnaire-list", DIR + "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {
        
        ModelAndView model = new ModelAndView("/admin/publicdata-Questionnaire-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Questionnaire questionnaire) {
        
        questionnaireService.add(questionnaire);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id, String queryStr) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Questionnaire questionnaire = questionnaireService.get(id);
        AdminQuestionnaireVO adminQuestionnaireVO = questionnaireHandler.toVO4Admin(questionnaire);
        ModelAndView model = new ModelAndView("/admin/publicdata-Questionnaire-edit");
        model.addObject("questionnaire", adminQuestionnaireVO);
        model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Questionnaire questionnaire, String queryStr) {

        questionnaireService.update(questionnaire);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        questionnaireService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
