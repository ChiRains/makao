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
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.VehicleHandler;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminVehicleVO;
		
@Controller
@RequestMapping(value = "/" + AdminVehicleController.DIR)
public class AdminVehicleController {
	
	public static final String DIR = "admin/vehicle";
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleHandler vehicleHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, VehicleQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<Vehicle> page = vehicleService.page(query, start, PAGE_SIZE);
		List<AdminVehicleVO> list = vehicleHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-Vehicle-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-Vehicle-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Vehicle vehicle) {
		vehicleService.add(vehicle);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Vehicle vehicle=vehicleService.get(id);
		AdminVehicleVO adminVehicleVO=vehicleHandler.toVO4Admin(vehicle);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-Vehicle-edit");
		model.addObject("vehicle", adminVehicleVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Vehicle vehicle) {
		vehicleService.update(vehicle);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		vehicleService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
