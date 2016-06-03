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
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.service.DriverTemplateService;
import com.qcloud.project.macaovehicle.web.handler.DriverTemplateHandler;
import com.qcloud.project.macaovehicle.model.query.DriverTemplateQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverTemplateVO;
		
@Controller
@RequestMapping(value = "/" + AdminDriverTemplateController.DIR)
public class AdminDriverTemplateController {
	
	public static final String DIR = "admin/driverTemplate";
	
	@Autowired
	private DriverTemplateService driverTemplateService;
	@Autowired
	private DriverTemplateHandler driverTemplateHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, DriverTemplateQuery query) {
	    
		Page<DriverTemplate> page = driverTemplateService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminDriverTemplateVO> list = driverTemplateHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-DriverTemplate-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-DriverTemplate-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(DriverTemplate driverTemplate) {
		driverTemplateService.add(driverTemplate);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		DriverTemplate driverTemplate=driverTemplateService.get(id);
		AdminDriverTemplateVO adminDriverTemplateVO=driverTemplateHandler.toVO4Admin(driverTemplate);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-DriverTemplate-edit");
		model.addObject("driverTemplate", adminDriverTemplateVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(DriverTemplate driverTemplate, String queryStr) {
		driverTemplateService.update(driverTemplate);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		driverTemplateService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
