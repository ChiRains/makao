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
import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.service.UsergroupService;
import com.qcloud.component.organization.web.handler.UsergroupHandler;
import com.qcloud.component.organization.model.query.UsergroupQuery;
import com.qcloud.component.organization.web.vo.admin.AdminUsergroupVO;
		
@Controller
@RequestMapping(value = "/" + AdminUsergroupController.DIR)
public class AdminUsergroupController {
	
	public static final String DIR = "admin/usergroup";
	
	@Autowired
	private UsergroupService usergroupService;
	@Autowired
	private UsergroupHandler usergroupHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, UsergroupQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<Usergroup> page = usergroupService.page(query, start, PAGE_SIZE);
		List<AdminUsergroupVO> list = usergroupHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/organization-Usergroup-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/organization-Usergroup-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Usergroup usergroup) {
		usergroupService.add(usergroup);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Usergroup usergroup=usergroupService.get(id);
		AdminUsergroupVO adminUsergroupVO=usergroupHandler.toVO4Admin(usergroup);
		ModelAndView model = new ModelAndView("/admin/organization-Usergroup-edit");
		model.addObject("usergroup", adminUsergroupVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Usergroup usergroup) {
		usergroupService.update(usergroup);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		usergroupService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
	
	
	
}
