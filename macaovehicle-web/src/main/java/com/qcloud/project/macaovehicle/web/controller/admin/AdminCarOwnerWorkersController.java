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
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.service.CarOwnerWorkersService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerWorkersHandler;
import com.qcloud.project.macaovehicle.model.query.CarOwnerWorkersQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerWorkersVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarOwnerWorkersController.DIR)
public class AdminCarOwnerWorkersController {
	
	public static final String DIR = "admin/carOwnerWorkers";
	
	@Autowired
	private CarOwnerWorkersService carOwnerWorkersService;
	@Autowired
	private CarOwnerWorkersHandler carOwnerWorkersHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, CarOwnerWorkersQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<CarOwnerWorkers> page = carOwnerWorkersService.page(query, start, PAGE_SIZE);
		List<AdminCarOwnerWorkersVO> list = carOwnerWorkersHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarOwnerWorkers-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerWorkers-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarOwnerWorkers carOwnerWorkers) {
		carOwnerWorkersService.add(carOwnerWorkers);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarOwnerWorkers carOwnerWorkers=carOwnerWorkersService.get(id);
		AdminCarOwnerWorkersVO adminCarOwnerWorkersVO=carOwnerWorkersHandler.toVO4Admin(carOwnerWorkers);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerWorkers-edit");
		model.addObject("carOwnerWorkers", adminCarOwnerWorkersVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarOwnerWorkers carOwnerWorkers) {
		carOwnerWorkersService.update(carOwnerWorkers);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carOwnerWorkersService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
