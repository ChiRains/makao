package com.qcloud.component.organization.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.service.SuperiorService;
import com.qcloud.component.organization.web.handler.SuperiorHandler;
import com.qcloud.component.organization.model.query.SuperiorQuery;
import com.qcloud.component.organization.web.vo.admin.AdminSuperiorVO;
		
@Controller
@RequestMapping(value = "/" + AdminSuperiorController.DIR)
public class AdminSuperiorController {
	
	public static final String DIR = "admin/superior";
	
	@Autowired
	private SuperiorService superiorService;
	@Autowired
	private SuperiorHandler superiorHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, SuperiorQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<Superior> page = superiorService.page(query, start, PAGE_SIZE);
		List<AdminSuperiorVO> list = superiorHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/organization-Superior-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/organization-Superior-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Superior superior) {
		superiorService.add(superior);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Superior superior=superiorService.get(id);
		AdminSuperiorVO adminSuperiorVO=superiorHandler.toVO4Admin(superior);
		ModelAndView model = new ModelAndView("/admin/organization-Superior-edit");
		model.addObject("superior", adminSuperiorVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Superior superior) {
		superiorService.update(superior);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		superiorService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
