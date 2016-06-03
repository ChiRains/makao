package com.qcloud.component.snakerext.web.controller.admin;

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
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.service.ProcessGroupService;
import com.qcloud.component.snakerext.web.handler.ProcessGroupHandler;
import com.qcloud.component.snakerext.model.query.ProcessGroupQuery;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessGroupVO;
		
@Controller
@RequestMapping(value = "/" + AdminProcessGroupController.DIR)
public class AdminProcessGroupController {
	
	public static final String DIR = "admin/processGroup";
	
	@Autowired
	private ProcessGroupService processGroupService;
	@Autowired
	private ProcessGroupHandler processGroupHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, ProcessGroupQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<ProcessGroup> page = processGroupService.page(query, start, PAGE_SIZE);
		List<AdminProcessGroupVO> list = processGroupHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/snakerext-ProcessGroup-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/snakerext-ProcessGroup-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(ProcessGroup processGroup) {
		processGroupService.add(processGroup);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		ProcessGroup processGroup=processGroupService.get(id);
		AdminProcessGroupVO adminProcessGroupVO=processGroupHandler.toVO4Admin(processGroup);
		ModelAndView model = new ModelAndView("/admin/snakerext-ProcessGroup-edit");
		model.addObject("processGroup", adminProcessGroupVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(ProcessGroup processGroup) {
		processGroupService.update(processGroup);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		processGroupService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
