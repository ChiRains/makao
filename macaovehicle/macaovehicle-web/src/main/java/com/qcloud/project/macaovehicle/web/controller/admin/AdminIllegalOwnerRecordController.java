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
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.service.IllegalOwnerRecordService;
import com.qcloud.project.macaovehicle.web.handler.IllegalOwnerRecordHandler;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalOwnerRecordVO;
		
@Controller
@RequestMapping(value = "/" + AdminIllegalOwnerRecordController.DIR)
public class AdminIllegalOwnerRecordController {
	
	public static final String DIR = "admin/illegalOwnerRecord";
	
	@Autowired
	private IllegalOwnerRecordService illegalOwnerRecordService;
	@Autowired
	private IllegalOwnerRecordHandler illegalOwnerRecordHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, IllegalOwnerRecordQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<IllegalOwnerRecord> page = illegalOwnerRecordService.page(query, start, PAGE_SIZE);
		List<AdminIllegalOwnerRecordVO> list = illegalOwnerRecordHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-IllegalOwnerRecord-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-IllegalOwnerRecord-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(IllegalOwnerRecord illegalOwnerRecord) {
		illegalOwnerRecordService.add(illegalOwnerRecord);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		IllegalOwnerRecord illegalOwnerRecord=illegalOwnerRecordService.get(id);
		AdminIllegalOwnerRecordVO adminIllegalOwnerRecordVO=illegalOwnerRecordHandler.toVO4Admin(illegalOwnerRecord);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-IllegalOwnerRecord-edit");
		model.addObject("illegalOwnerRecord", adminIllegalOwnerRecordVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(IllegalOwnerRecord illegalOwnerRecord) {
		illegalOwnerRecordService.update(illegalOwnerRecord);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		illegalOwnerRecordService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
