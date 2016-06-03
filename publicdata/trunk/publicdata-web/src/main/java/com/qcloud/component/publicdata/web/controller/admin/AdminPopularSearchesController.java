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
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.service.PopularSearchesService;
import com.qcloud.component.publicdata.web.handler.PopularSearchesHandler;
import com.qcloud.component.publicdata.model.query.PopularSearchesQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminPopularSearchesVO;
		
@Controller
@RequestMapping(value = "/" + AdminPopularSearchesController.DIR)
public class AdminPopularSearchesController {
	
	public static final String DIR = "admin/popularSearches";
	
	@Autowired
	private PopularSearchesService popularSearchesService;
	@Autowired
	private PopularSearchesHandler popularSearchesHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, Integer pageNum, PPage pPage, PopularSearchesQuery query) {
		
		Page<PopularSearches> page = popularSearchesService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminPopularSearchesVO> list = popularSearchesHandler.toVOList4Admin(page.getData());
				
		String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
	    String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   	    
		AcePagingView pagingView = new AcePagingView("/admin/publicdata-PopularSearches-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/publicdata-PopularSearches-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(PopularSearches popularSearches) {
		popularSearchesService.add(popularSearches);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		PopularSearches popularSearches=popularSearchesService.get(id);
		AdminPopularSearchesVO adminPopularSearchesVO=popularSearchesHandler.toVO4Admin(popularSearches);
		ModelAndView model = new ModelAndView("/admin/publicdata-PopularSearches-edit");
		model.addObject("popularSearches", adminPopularSearchesVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(PopularSearches popularSearches, String queryStr) {
		popularSearchesService.update(popularSearches);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		popularSearchesService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
