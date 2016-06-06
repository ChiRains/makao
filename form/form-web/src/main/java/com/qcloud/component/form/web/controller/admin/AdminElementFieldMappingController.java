package com.qcloud.component.form.web.controller.admin;

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
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.service.ElementFieldMappingService;
import com.qcloud.component.form.web.handler.ElementFieldMappingHandler;
import com.qcloud.component.form.model.query.ElementFieldMappingQuery;
import com.qcloud.component.form.web.vo.admin.AdminElementFieldMappingVO;
		
@Controller
@RequestMapping(value = "/" + AdminElementFieldMappingController.DIR)
public class AdminElementFieldMappingController {
	
	public static final String DIR = "admin/elementFieldMapping";
	
	@Autowired
	private ElementFieldMappingService elementFieldMappingService;
	@Autowired
	private ElementFieldMappingHandler elementFieldMappingHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, ElementFieldMappingQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<ElementFieldMapping> page = elementFieldMappingService.page(query, start, PAGE_SIZE);
		List<AdminElementFieldMappingVO> list = elementFieldMappingHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/form-ElementFieldMapping-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/form-ElementFieldMapping-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(ElementFieldMapping elementFieldMapping) {
		elementFieldMappingService.add(elementFieldMapping);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		ElementFieldMapping elementFieldMapping=elementFieldMappingService.get(id);
		AdminElementFieldMappingVO adminElementFieldMappingVO=elementFieldMappingHandler.toVO4Admin(elementFieldMapping);
		ModelAndView model = new ModelAndView("/admin/form-ElementFieldMapping-edit");
		model.addObject("elementFieldMapping", adminElementFieldMappingVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(ElementFieldMapping elementFieldMapping) {
		elementFieldMappingService.update(elementFieldMapping);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		elementFieldMappingService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
