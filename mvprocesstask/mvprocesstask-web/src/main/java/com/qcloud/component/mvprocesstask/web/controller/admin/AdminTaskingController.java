package com.qcloud.component.mvprocesstask.web.controller.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.model.query.TaskingQuery;
import com.qcloud.component.mvprocesstask.service.TaskingService;
import com.qcloud.component.mvprocesstask.web.handler.TaskingHandler;
import com.qcloud.component.mvprocesstask.web.vo.admin.AdminTaskingVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.security.annotation.NoReferer;
		
@Controller
@RequestMapping(value = "/" + AdminTaskingController.DIR)
public class AdminTaskingController {
	
	public static final String DIR = "admin/tasking";
	
	@Autowired
	private TaskingService taskingService;
	@Autowired
	private TaskingHandler taskingHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(PPage pPage, TaskingQuery query) {
		
		Page<Tasking> page = taskingService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminTaskingVO> list = taskingHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/processtask-Tasking-list", DIR
				+ "/list", pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/processtask-Tasking-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Tasking tasking) {
		taskingService.add(tasking);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Tasking tasking=taskingService.get(id);
		AdminTaskingVO adminTaskingVO=taskingHandler.toVO4Admin(tasking);
		ModelAndView model = new ModelAndView("/admin/processtask-Tasking-edit");
		model.addObject("tasking", adminTaskingVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Tasking tasking) {
		taskingService.update(tasking);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		taskingService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
