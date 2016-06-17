package com.qcloud.project.macaovehicle.web.controller.admin;

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
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.service.DvrAreaService;
import com.qcloud.project.macaovehicle.web.handler.DvrAreaHandler;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDvrAreaVO;
		
@Controller
@RequestMapping(value = "/" + AdminDvrAreaController.DIR)
public class AdminDvrAreaController {
	
	public static final String DIR = "admin/dvrArea";
	
	@Autowired
	private DvrAreaService dvrAreaService;
	@Autowired
	private DvrAreaHandler dvrAreaHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, DvrAreaQuery query) {
	    
		Page<DvrArea> page = dvrAreaService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminDvrAreaVO> list = dvrAreaHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-DvrArea-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-DvrArea-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(DvrArea dvrArea) {
		dvrAreaService.add(dvrArea);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		DvrArea dvrArea=dvrAreaService.get(id);
		AdminDvrAreaVO adminDvrAreaVO=dvrAreaHandler.toVO4Admin(dvrArea);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-DvrArea-edit");
		model.addObject("dvrArea", adminDvrAreaVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(DvrArea dvrArea, String queryStr) {
		dvrAreaService.update(dvrArea);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		dvrAreaService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
