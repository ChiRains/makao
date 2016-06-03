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
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerEnterprisersHandler;
import com.qcloud.project.macaovehicle.model.query.CarOwnerEnterprisersQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerEnterprisersVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarOwnerEnterprisersController.DIR)
public class AdminCarOwnerEnterprisersController {
	
	public static final String DIR = "admin/carOwnerEnterprisers";
	
	@Autowired
	private CarOwnerEnterprisersService carOwnerEnterprisersService;
	@Autowired
	private CarOwnerEnterprisersHandler carOwnerEnterprisersHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, CarOwnerEnterprisersQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<CarOwnerEnterprisers> page = carOwnerEnterprisersService.page(query, start, PAGE_SIZE);
		List<AdminCarOwnerEnterprisersVO> list = carOwnerEnterprisersHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarOwnerEnterprisers-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerEnterprisers-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarOwnerEnterprisers carOwnerEnterprisers) {
		carOwnerEnterprisersService.add(carOwnerEnterprisers);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarOwnerEnterprisers carOwnerEnterprisers=carOwnerEnterprisersService.get(id);
		AdminCarOwnerEnterprisersVO adminCarOwnerEnterprisersVO=carOwnerEnterprisersHandler.toVO4Admin(carOwnerEnterprisers);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerEnterprisers-edit");
		model.addObject("carOwnerEnterprisers", adminCarOwnerEnterprisersVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarOwnerEnterprisers carOwnerEnterprisers) {
		carOwnerEnterprisersService.update(carOwnerEnterprisers);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carOwnerEnterprisersService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
