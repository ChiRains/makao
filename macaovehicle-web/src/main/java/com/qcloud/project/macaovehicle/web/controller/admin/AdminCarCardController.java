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
import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.service.CarCardService;
import com.qcloud.project.macaovehicle.web.handler.CarCardHandler;
import com.qcloud.project.macaovehicle.model.query.CarCardQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarCardVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarCardController.DIR)
public class AdminCarCardController {
	
	public static final String DIR = "admin/carCard";
	
	@Autowired
	private CarCardService carCardService;
	@Autowired
	private CarCardHandler carCardHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, CarCardQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<CarCard> page = carCardService.page(query, start, PAGE_SIZE);
		List<AdminCarCardVO> list = carCardHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarCard-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarCard-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarCard carCard) {
		carCardService.add(carCard);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarCard carCard=carCardService.get(id);
		AdminCarCardVO adminCarCardVO=carCardHandler.toVO4Admin(carCard);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarCard-edit");
		model.addObject("carCard", adminCarCardVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarCard carCard) {
		carCardService.update(carCard);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carCardService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
