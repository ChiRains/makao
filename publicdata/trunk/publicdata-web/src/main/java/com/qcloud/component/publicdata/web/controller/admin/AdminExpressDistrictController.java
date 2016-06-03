package com.qcloud.component.publicdata.web.controller.admin;

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
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.service.ExpressDistrictService;
import com.qcloud.component.publicdata.web.handler.ExpressDistrictHandler;
import com.qcloud.component.publicdata.model.query.ExpressDistrictQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminExpressDistrictVO;
		
@Controller
@RequestMapping(value = "/" + AdminExpressDistrictController.DIR)
public class AdminExpressDistrictController {
	
	public static final String DIR = "admin/expressDistrict";
	
	@Autowired
	private ExpressDistrictService expressDistrictService;
	@Autowired
	private ExpressDistrictHandler expressDistrictHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, ExpressDistrictQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<ExpressDistrict> page = expressDistrictService.page(query, start, PAGE_SIZE);
		List<AdminExpressDistrictVO> list = expressDistrictHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/publicdata-ExpressDistrict-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/publicdata-ExpressDistrict-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(ExpressDistrict expressDistrict) {
		expressDistrictService.add(expressDistrict);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		ExpressDistrict expressDistrict=expressDistrictService.get(id);
		AdminExpressDistrictVO adminExpressDistrictVO=expressDistrictHandler.toVO4Admin(expressDistrict);
		ModelAndView model = new ModelAndView("/admin/publicdata-ExpressDistrict-edit");
		model.addObject("expressDistrict", adminExpressDistrictVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(ExpressDistrict expressDistrict) {
		expressDistrictService.update(expressDistrict);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		expressDistrictService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
