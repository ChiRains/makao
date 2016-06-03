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
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.service.PeccancyCarService;
import com.qcloud.project.macaovehicle.web.handler.PeccancyCarHandler;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminPeccancyCarVO;
		
@Controller
@RequestMapping(value = "/" + AdminPeccancyCarController.DIR)
public class AdminPeccancyCarController {
	
	public static final String DIR = "admin/peccancyCar";
	
	@Autowired
	private PeccancyCarService peccancyCarService;
	@Autowired
	private PeccancyCarHandler peccancyCarHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, PeccancyCarQuery query) {
	    
		Page<PeccancyCar> page = peccancyCarService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminPeccancyCarVO> list = peccancyCarHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-PeccancyCar-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-PeccancyCar-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(PeccancyCar peccancyCar) {
		peccancyCarService.add(peccancyCar);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		PeccancyCar peccancyCar=peccancyCarService.get(id);
		AdminPeccancyCarVO adminPeccancyCarVO=peccancyCarHandler.toVO4Admin(peccancyCar);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-PeccancyCar-edit");
		model.addObject("peccancyCar", adminPeccancyCarVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(PeccancyCar peccancyCar, String queryStr) {
		peccancyCarService.update(peccancyCar);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		peccancyCarService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
