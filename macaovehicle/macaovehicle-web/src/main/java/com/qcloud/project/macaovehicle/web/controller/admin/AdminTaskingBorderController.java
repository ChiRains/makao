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
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.web.handler.TaskingBorderHandler;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingBorderVO;
		
@Controller
@RequestMapping(value = "/" + AdminTaskingBorderController.DIR)
public class AdminTaskingBorderController {
	
	public static final String DIR = "admin/taskingBorder";
	
	@Autowired
	private TaskingBorderService taskingBorderService;
	@Autowired
	private TaskingBorderHandler taskingBorderHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, TaskingBorderQuery query) {
	    
		Page<TaskingBorder> page = taskingBorderService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminTaskingBorderVO> list = taskingBorderHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-TaskingBorder-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-TaskingBorder-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(TaskingBorder taskingBorder) {
		taskingBorderService.add(taskingBorder);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		TaskingBorder taskingBorder=taskingBorderService.get(id);
		AdminTaskingBorderVO adminTaskingBorderVO=taskingBorderHandler.toVO4Admin(taskingBorder);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-TaskingBorder-edit");
		model.addObject("taskingBorder", adminTaskingBorderVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(TaskingBorder taskingBorder, String queryStr) {
		taskingBorderService.update(taskingBorder);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		taskingBorderService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
