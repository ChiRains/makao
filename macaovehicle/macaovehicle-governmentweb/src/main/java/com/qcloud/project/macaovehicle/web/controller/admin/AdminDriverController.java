package com.qcloud.project.macaovehicle.web.controller.admin;

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
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.web.handler.DriverHandler;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverVO;
		
@Controller
@RequestMapping(value = "/" + AdminDriverController.DIR)
public class AdminDriverController {
	
	public static final String DIR = "admin/driver";
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private DriverHandler driverHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, DriverQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<Driver> page = driverService.page(query, start, PAGE_SIZE);
		List<AdminDriverVO> list = driverHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-Driver-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-Driver-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Driver driver) {
		driverService.add(driver);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Driver driver=driverService.get(id);
		AdminDriverVO adminDriverVO=driverHandler.toVO4Admin(driver);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-Driver-edit");
		model.addObject("driver", adminDriverVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Driver driver) {
		driverService.update(driver);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		driverService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
