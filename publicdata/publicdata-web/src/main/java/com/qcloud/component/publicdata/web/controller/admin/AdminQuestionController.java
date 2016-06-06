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
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.service.OptionsService;
import com.qcloud.component.publicdata.service.QuestionService;
import com.qcloud.component.publicdata.web.handler.QuestionHandler;
import com.qcloud.component.publicdata.model.key.TypeEnum.QuestionType;
import com.qcloud.component.publicdata.model.query.QuestionQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminQuestionVO;
		
@Controller
@RequestMapping(value = "/" + AdminQuestionController.DIR)
public class AdminQuestionController {
	
	public static final String DIR = "admin/question";
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuestionHandler questionHandler;
	@Autowired
	private OptionsService optionsService;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, Integer pageNum, PPage pPage, QuestionQuery query) {
		
		Page<Question> page = questionService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminQuestionVO> list = questionHandler.toVOList4Admin(page.getData());
				
		String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
	    String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   	    
		AcePagingView pagingView = new AcePagingView("/admin/publicdata-Question-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		pagingView.addObject("questionnaireId",query.getQuestionnaireId());
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd(Long questionnaireId) {
		ModelAndView model = new ModelAndView("/admin/publicdata-Question-add");
		model.addObject("questionnaireId",questionnaireId);
		model.addObject("types",QuestionType.values());
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Question question) {
		questionService.add(question);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list?questionnaireId="+question.getQuestionnaireId());
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr,Long questionnaireId) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Question question=questionService.get(id);
		AdminQuestionVO adminQuestionVO=questionHandler.toVO4Admin(question);
		ModelAndView model = new ModelAndView("/admin/publicdata-Question-edit");
		model.addObject("question", adminQuestionVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		model.addObject("questionnaireId",questionnaireId);
		model.addObject("types",QuestionType.values());
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Question question, String queryStr) {
		questionService.update(question);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		questionService.delete(id);
		List<Options> optionsList=optionsService.listByQuestion(id);
		if(optionsList!=null){
		    for (Options options : optionsList) {
		        optionsService.delete(options.getId());
            }
		}
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
