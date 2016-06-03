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
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHandler;
import com.qcloud.project.macaovehicle.model.query.CarOwnerQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarOwnerController.DIR)
public class AdminCarOwnerController {
	
	public static final String DIR = "admin/carOwner";
	
	@Autowired
	private CarOwnerService carOwnerService;
	@Autowired
	private CarOwnerHandler carOwnerHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, CarOwnerQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<CarOwner> page = carOwnerService.page(query, start, PAGE_SIZE);
		List<AdminCarOwnerVO> list = carOwnerHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarOwner-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwner-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarOwner carOwner) {
		carOwnerService.add(carOwner);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarOwner carOwner=carOwnerService.get(id);
		AdminCarOwnerVO adminCarOwnerVO=carOwnerHandler.toVO4Admin(carOwner);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwner-edit");
		model.addObject("carOwner", adminCarOwnerVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarOwner carOwner) {
		carOwnerService.update(carOwner);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carOwnerService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
