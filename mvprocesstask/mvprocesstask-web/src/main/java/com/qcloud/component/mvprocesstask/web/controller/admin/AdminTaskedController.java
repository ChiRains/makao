package com.qcloud.component.mvprocesstask.web.controller.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.query.TaskedQuery;
import com.qcloud.component.mvprocesstask.service.TaskedService;
import com.qcloud.component.mvprocesstask.web.handler.TaskedHandler;
import com.qcloud.component.mvprocesstask.web.vo.admin.AdminTaskedVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
		
@Controller
@RequestMapping(value = "/" + AdminTaskedController.DIR)
public class AdminTaskedController {
	
	public static final String DIR = "admin/tasked";
	
	@Autowired
	private TaskedService taskedService;
	@Autowired
	private TaskedHandler taskedHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, TaskedQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<Tasked> page = taskedService.page(query, start, PAGE_SIZE);
		List<AdminTaskedVO> list = taskedHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/processtask-Tasked-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/processtask-Tasked-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Tasked tasked) {
		taskedService.add(tasked);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Tasked tasked=taskedService.get(id);
		AdminTaskedVO adminTaskedVO=taskedHandler.toVO4Admin(tasked);
		ModelAndView model = new ModelAndView("/admin/processtask-Tasked-edit");
		model.addObject("tasked", adminTaskedVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Tasked tasked) {
		taskedService.update(tasked);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		taskedService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
