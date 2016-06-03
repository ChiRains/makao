package com.qcloud.component.publicservice.web.controller.admin;

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
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.service.MessageTypeService;
import com.qcloud.component.publicservice.web.handler.MessageTypeHandler;
import com.qcloud.component.publicservice.model.query.MessageTypeQuery;
import com.qcloud.component.publicservice.web.vo.admin.AdminMessageTypeVO;
		
@Controller
@RequestMapping(value = "/" + AdminMessageTypeController.DIR)
public class AdminMessageTypeController {
	
	public static final String DIR = "admin/messageType";
	
	@Autowired
	private MessageTypeService messageTypeService;
	@Autowired
	private MessageTypeHandler messageTypeHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, MessageTypeQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<MessageType> page = messageTypeService.page(query, start, PAGE_SIZE);
		List<AdminMessageTypeVO> list = messageTypeHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/publicservice-MessageType-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/publicservice-MessageType-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(MessageType messageType) {
		messageTypeService.add(messageType);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		MessageType messageType=messageTypeService.get(id);
		AdminMessageTypeVO adminMessageTypeVO=messageTypeHandler.toVO4Admin(messageType);
		ModelAndView model = new ModelAndView("/admin/publicservice-MessageType-edit");
		model.addObject("messageType", adminMessageTypeVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(MessageType messageType) {
		messageTypeService.update(messageType);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		messageTypeService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
