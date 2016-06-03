package com.qcloud.project.macaovehicle.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.service.ApprovalOutsideService;
import com.qcloud.project.macaovehicle.web.handler.ApprovalOutsideHandler;
import com.qcloud.project.macaovehicle.model.query.ApprovalOutsideQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminApprovalOutsideVO;
		
@Controller
@RequestMapping(value = "/" + AdminApprovalOutsideController.DIR)
public class AdminApprovalOutsideController {
	
	public static final String DIR = "admin/approvalOutside";
	
	@Autowired
	private ApprovalOutsideService approvalOutsideService;
	@Autowired
	private ApprovalOutsideHandler approvalOutsideHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, ApprovalOutsideQuery query) {
	    
		Page<ApprovalOutside> page = approvalOutsideService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminApprovalOutsideVO> list = approvalOutsideHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-ApprovalOutside-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-ApprovalOutside-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(ApprovalOutside approvalOutside) {
		approvalOutsideService.add(approvalOutside);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		ApprovalOutside approvalOutside=approvalOutsideService.get(id);
		AdminApprovalOutsideVO adminApprovalOutsideVO=approvalOutsideHandler.toVO4Admin(approvalOutside);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-ApprovalOutside-edit");
		model.addObject("approvalOutside", adminApprovalOutsideVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(ApprovalOutside approvalOutside, String queryStr) {
		approvalOutsideService.update(approvalOutside);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		approvalOutsideService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
