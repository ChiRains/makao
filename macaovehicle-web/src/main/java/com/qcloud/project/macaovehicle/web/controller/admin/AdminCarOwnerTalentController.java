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
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.service.CarOwnerTalentService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerTalentHandler;
import com.qcloud.project.macaovehicle.model.query.CarOwnerTalentQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerTalentVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarOwnerTalentController.DIR)
public class AdminCarOwnerTalentController {
	
	public static final String DIR = "admin/carOwnerTalent";
	
	@Autowired
	private CarOwnerTalentService carOwnerTalentService;
	@Autowired
	private CarOwnerTalentHandler carOwnerTalentHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, CarOwnerTalentQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<CarOwnerTalent> page = carOwnerTalentService.page(query, start, PAGE_SIZE);
		List<AdminCarOwnerTalentVO> list = carOwnerTalentHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarOwnerTalent-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerTalent-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarOwnerTalent carOwnerTalent) {
		carOwnerTalentService.add(carOwnerTalent);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarOwnerTalent carOwnerTalent=carOwnerTalentService.get(id);
		AdminCarOwnerTalentVO adminCarOwnerTalentVO=carOwnerTalentHandler.toVO4Admin(carOwnerTalent);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerTalent-edit");
		model.addObject("carOwnerTalent", adminCarOwnerTalentVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarOwnerTalent carOwnerTalent) {
		carOwnerTalentService.update(carOwnerTalent);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carOwnerTalentService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
