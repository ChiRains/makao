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
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.service.TaskingCiqService;
import com.qcloud.project.macaovehicle.web.handler.TaskingCiqHandler;
import com.qcloud.project.macaovehicle.model.query.TaskingCiqQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingCiqVO;
		
@Controller
@RequestMapping(value = "/" + AdminTaskingCiqController.DIR)
public class AdminTaskingCiqController {
	
	public static final String DIR = "admin/taskingCiq";
	
	@Autowired
	private TaskingCiqService taskingCiqService;
	@Autowired
	private TaskingCiqHandler taskingCiqHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, TaskingCiqQuery query) {
	    
		Page<TaskingCiq> page = taskingCiqService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminTaskingCiqVO> list = taskingCiqHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-TaskingCiq-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-TaskingCiq-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(TaskingCiq taskingCiq) {
		taskingCiqService.add(taskingCiq);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		TaskingCiq taskingCiq=taskingCiqService.get(id);
		AdminTaskingCiqVO adminTaskingCiqVO=taskingCiqHandler.toVO4Admin(taskingCiq);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-TaskingCiq-edit");
		model.addObject("taskingCiq", adminTaskingCiqVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(TaskingCiq taskingCiq, String queryStr) {
		taskingCiqService.update(taskingCiq);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		taskingCiqService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
