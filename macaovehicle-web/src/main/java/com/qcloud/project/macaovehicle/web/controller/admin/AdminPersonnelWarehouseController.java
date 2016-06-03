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
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.service.PersonnelWarehouseService;
import com.qcloud.project.macaovehicle.web.handler.PersonnelWarehouseHandler;
import com.qcloud.project.macaovehicle.model.query.PersonnelWarehouseQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminPersonnelWarehouseVO;
		
@Controller
@RequestMapping(value = "/" + AdminPersonnelWarehouseController.DIR)
public class AdminPersonnelWarehouseController {
	
	public static final String DIR = "admin/personnelWarehouse";
	
	@Autowired
	private PersonnelWarehouseService personnelWarehouseService;
	@Autowired
	private PersonnelWarehouseHandler personnelWarehouseHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, PersonnelWarehouseQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<PersonnelWarehouse> page = personnelWarehouseService.page(query, start, PAGE_SIZE);
		List<AdminPersonnelWarehouseVO> list = personnelWarehouseHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-PersonnelWarehouse-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-PersonnelWarehouse-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(PersonnelWarehouse personnelWarehouse) {
		personnelWarehouseService.add(personnelWarehouse);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		PersonnelWarehouse personnelWarehouse=personnelWarehouseService.get(id);
		AdminPersonnelWarehouseVO adminPersonnelWarehouseVO=personnelWarehouseHandler.toVO4Admin(personnelWarehouse);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-PersonnelWarehouse-edit");
		model.addObject("personnelWarehouse", adminPersonnelWarehouseVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(PersonnelWarehouse personnelWarehouse) {
		personnelWarehouseService.update(personnelWarehouse);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		personnelWarehouseService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
