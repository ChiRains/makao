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
import com.qcloud.component.publicdata.service.OptionsService;
import com.qcloud.component.publicdata.web.handler.OptionsHandler;
import com.qcloud.component.publicdata.model.query.OptionsQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminOptionsVO;
		
@Controller
@RequestMapping(value = "/" + AdminOptionsController.DIR)
public class AdminOptionsController {
	
	public static final String DIR = "admin/options";
	
	@Autowired
	private OptionsService optionsService;
	@Autowired
	private OptionsHandler optionsHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, Integer pageNum, PPage pPage, OptionsQuery query) {
		
		Page<Options> page = optionsService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminOptionsVO> list = optionsHandler.toVOList4Admin(page.getData());
				
		String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
	    String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   	    
		AcePagingView pagingView = new AcePagingView("/admin/publicdata-Options-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		pagingView.addObject("questionnaireId",query.getQuestionnaireId());
		pagingView.addObject("questionId",query.getQuestionId());
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd(Long questionnaireId,Long questionId) {
		ModelAndView model = new ModelAndView("/admin/publicdata-Options-add");
		model.addObject("questionnaireId",questionnaireId);
		model.addObject("questionId",questionId);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Options options) {
		optionsService.add(options);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list?questionnaireId="+options.getQuestionnaireId()+"&questionId="+options.getQuestionId());
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr,Long questionnaireId,Long questionId) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Options options=optionsService.get(id);
		AdminOptionsVO adminOptionsVO=optionsHandler.toVO4Admin(options);
		ModelAndView model = new ModelAndView("/admin/publicdata-Options-edit");
		model.addObject("options", adminOptionsVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		model.addObject("questionnaireId",questionnaireId);
        model.addObject("questionId",questionId);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Options options, String queryStr) {
		optionsService.update(options);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		optionsService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
