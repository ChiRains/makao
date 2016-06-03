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
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.service.TaskingCustomsService;
import com.qcloud.project.macaovehicle.web.handler.TaskingCustomsHandler;
import com.qcloud.project.macaovehicle.model.query.TaskingCustomsQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingCustomsVO;
		
@Controller
@RequestMapping(value = "/" + AdminTaskingCustomsController.DIR)
public class AdminTaskingCustomsController {
	
	public static final String DIR = "admin/taskingCustoms";
	
	@Autowired
	private TaskingCustomsService taskingCustomsService;
	@Autowired
	private TaskingCustomsHandler taskingCustomsHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, TaskingCustomsQuery query) {
	    
		Page<TaskingCustoms> page = taskingCustomsService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminTaskingCustomsVO> list = taskingCustomsHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-TaskingCustoms-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-TaskingCustoms-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(TaskingCustoms taskingCustoms) {
		taskingCustomsService.add(taskingCustoms);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		TaskingCustoms taskingCustoms=taskingCustomsService.get(id);
		AdminTaskingCustomsVO adminTaskingCustomsVO=taskingCustomsHandler.toVO4Admin(taskingCustoms);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-TaskingCustoms-edit");
		model.addObject("taskingCustoms", adminTaskingCustomsVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(TaskingCustoms taskingCustoms, String queryStr) {
		taskingCustomsService.update(taskingCustoms);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		taskingCustomsService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
