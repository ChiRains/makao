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
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.service.CarOwnerPurchaseService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerPurchaseHandler;
import com.qcloud.project.macaovehicle.model.query.CarOwnerPurchaseQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerPurchaseVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarOwnerPurchaseController.DIR)
public class AdminCarOwnerPurchaseController {
	
	public static final String DIR = "admin/carOwnerPurchase";
	
	@Autowired
	private CarOwnerPurchaseService carOwnerPurchaseService;
	@Autowired
	private CarOwnerPurchaseHandler carOwnerPurchaseHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, CarOwnerPurchaseQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<CarOwnerPurchase> page = carOwnerPurchaseService.page(query, start, PAGE_SIZE);
		List<AdminCarOwnerPurchaseVO> list = carOwnerPurchaseHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarOwnerPurchase-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerPurchase-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarOwnerPurchase carOwnerPurchase) {
		carOwnerPurchaseService.add(carOwnerPurchase);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarOwnerPurchase carOwnerPurchase=carOwnerPurchaseService.get(id);
		AdminCarOwnerPurchaseVO adminCarOwnerPurchaseVO=carOwnerPurchaseHandler.toVO4Admin(carOwnerPurchase);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerPurchase-edit");
		model.addObject("carOwnerPurchase", adminCarOwnerPurchaseVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarOwnerPurchase carOwnerPurchase) {
		carOwnerPurchaseService.update(carOwnerPurchase);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carOwnerPurchaseService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
