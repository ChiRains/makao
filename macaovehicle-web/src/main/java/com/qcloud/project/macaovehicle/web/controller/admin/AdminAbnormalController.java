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
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.service.AbnormalService;
import com.qcloud.project.macaovehicle.web.handler.AbnormalHandler;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminAbnormalVO;
		
@Controller
@RequestMapping(value = "/" + AdminAbnormalController.DIR)
public class AdminAbnormalController {
	
	public static final String DIR = "admin/abnormal";
	
	@Autowired
	private AbnormalService abnormalService;
	@Autowired
	private AbnormalHandler abnormalHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, AbnormalQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<Abnormal> page = abnormalService.page(query, start, PAGE_SIZE);
		List<AdminAbnormalVO> list = abnormalHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-Abnormal-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-Abnormal-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Abnormal abnormal) {
		abnormalService.add(abnormal);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Integer macaovehicleAbnormalId) {
		AssertUtil.assertNotNull(macaovehicleAbnormalId, "ID不能为空");
		Abnormal abnormal=abnormalService.get(macaovehicleAbnormalId);
		AdminAbnormalVO adminAbnormalVO=abnormalHandler.toVO4Admin(abnormal);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-Abnormal-edit");
		model.addObject("abnormal", adminAbnormalVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Abnormal abnormal) {
		abnormalService.update(abnormal);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Integer macaovehicleAbnormalId) {
		AssertUtil.assertNotNull(macaovehicleAbnormalId, "ID不能为空");
		abnormalService.delete(macaovehicleAbnormalId);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
