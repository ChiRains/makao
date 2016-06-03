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
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.service.OnestopCarRecordService;
import com.qcloud.project.macaovehicle.web.handler.OnestopCarRecordHandler;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminOnestopCarRecordVO;
		
@Controller
@RequestMapping(value = "/" + AdminOnestopCarRecordController.DIR)
public class AdminOnestopCarRecordController {
	
	public static final String DIR = "admin/onestopCarRecord";
	
	@Autowired
	private OnestopCarRecordService onestopCarRecordService;
	@Autowired
	private OnestopCarRecordHandler onestopCarRecordHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, OnestopCarRecordQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<OnestopCarRecord> page = onestopCarRecordService.page(query, start, PAGE_SIZE);
		List<AdminOnestopCarRecordVO> list = onestopCarRecordHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-OnestopCarRecord-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-OnestopCarRecord-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(OnestopCarRecord onestopCarRecord) {
		onestopCarRecordService.add(onestopCarRecord);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		OnestopCarRecord onestopCarRecord=onestopCarRecordService.get(id);
		AdminOnestopCarRecordVO adminOnestopCarRecordVO=onestopCarRecordHandler.toVO4Admin(onestopCarRecord);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-OnestopCarRecord-edit");
		model.addObject("onestopCarRecord", adminOnestopCarRecordVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(OnestopCarRecord onestopCarRecord) {
		onestopCarRecordService.update(onestopCarRecord);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		onestopCarRecordService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
