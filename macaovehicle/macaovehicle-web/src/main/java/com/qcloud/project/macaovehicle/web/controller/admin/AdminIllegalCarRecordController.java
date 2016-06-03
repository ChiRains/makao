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
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.service.IllegalCarRecordService;
import com.qcloud.project.macaovehicle.web.handler.IllegalCarRecordHandler;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalCarRecordVO;
		
@Controller
@RequestMapping(value = "/" + AdminIllegalCarRecordController.DIR)
public class AdminIllegalCarRecordController {
	
	public static final String DIR = "admin/illegalCarRecord";
	
	@Autowired
	private IllegalCarRecordService illegalCarRecordService;
	@Autowired
	private IllegalCarRecordHandler illegalCarRecordHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, IllegalCarRecordQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<IllegalCarRecord> page = illegalCarRecordService.page(query, start, PAGE_SIZE);
		List<AdminIllegalCarRecordVO> list = illegalCarRecordHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-IllegalCarRecord-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-IllegalCarRecord-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(IllegalCarRecord illegalCarRecord) {
		illegalCarRecordService.add(illegalCarRecord);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		IllegalCarRecord illegalCarRecord=illegalCarRecordService.get(id);
		AdminIllegalCarRecordVO adminIllegalCarRecordVO=illegalCarRecordHandler.toVO4Admin(illegalCarRecord);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-IllegalCarRecord-edit");
		model.addObject("illegalCarRecord", adminIllegalCarRecordVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(IllegalCarRecord illegalCarRecord) {
		illegalCarRecordService.update(illegalCarRecord);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		illegalCarRecordService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
