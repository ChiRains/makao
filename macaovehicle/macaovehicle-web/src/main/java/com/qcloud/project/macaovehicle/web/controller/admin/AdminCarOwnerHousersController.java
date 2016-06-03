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
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.service.CarOwnerHousersService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHousersHandler;
import com.qcloud.project.macaovehicle.model.query.CarOwnerHousersQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerHousersVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarOwnerHousersController.DIR)
public class AdminCarOwnerHousersController {
	
	public static final String DIR = "admin/carOwnerHousers";
	
	@Autowired
	private CarOwnerHousersService carOwnerHousersService;
	@Autowired
	private CarOwnerHousersHandler carOwnerHousersHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, CarOwnerHousersQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<CarOwnerHousers> page = carOwnerHousersService.page(query, start, PAGE_SIZE);
		List<AdminCarOwnerHousersVO> list = carOwnerHousersHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarOwnerHousers-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerHousers-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarOwnerHousers carOwnerHousers) {
		carOwnerHousersService.add(carOwnerHousers);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarOwnerHousers carOwnerHousers=carOwnerHousersService.get(id);
		AdminCarOwnerHousersVO adminCarOwnerHousersVO=carOwnerHousersHandler.toVO4Admin(carOwnerHousers);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerHousers-edit");
		model.addObject("carOwnerHousers", adminCarOwnerHousersVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarOwnerHousers carOwnerHousers) {
		carOwnerHousersService.update(carOwnerHousers);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carOwnerHousersService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
