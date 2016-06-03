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
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.web.handler.DriverVehicleHandler;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverVehicleVO;
		
@Controller
@RequestMapping(value = "/" + AdminDriverVehicleController.DIR)
public class AdminDriverVehicleController {
	
	public static final String DIR = "admin/driverVehicle";
	
	@Autowired
	private DriverVehicleService driverVehicleService;
	@Autowired
	private DriverVehicleHandler driverVehicleHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, DriverVehicleQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<DriverVehicle> page = driverVehicleService.page(query, start, PAGE_SIZE);
		List<AdminDriverVehicleVO> list = driverVehicleHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-DriverVehicle-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-DriverVehicle-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(DriverVehicle driverVehicle) {
		driverVehicleService.add(driverVehicle);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		DriverVehicle driverVehicle=driverVehicleService.get(id);
		AdminDriverVehicleVO adminDriverVehicleVO=driverVehicleHandler.toVO4Admin(driverVehicle);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-DriverVehicle-edit");
		model.addObject("driverVehicle", adminDriverVehicleVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(DriverVehicle driverVehicle) {
		driverVehicleService.update(driverVehicle);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		driverVehicleService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
