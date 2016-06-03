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
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.service.InstanceMessageService;
import com.qcloud.project.macaovehicle.web.handler.InstanceMessageHandler;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminInstanceMessageVO;
		
@Controller
@RequestMapping(value = "/" + AdminInstanceMessageController.DIR)
public class AdminInstanceMessageController {
	
	public static final String DIR = "admin/instanceMessage";
	
	@Autowired
	private InstanceMessageService instanceMessageService;
	@Autowired
	private InstanceMessageHandler instanceMessageHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, InstanceMessageQuery query) {
	    
		Page<InstanceMessage> page = instanceMessageService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminInstanceMessageVO> list = instanceMessageHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-InstanceMessage-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-InstanceMessage-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(InstanceMessage instanceMessage) {
		instanceMessageService.add(instanceMessage);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		InstanceMessage instanceMessage=instanceMessageService.get(id);
		AdminInstanceMessageVO adminInstanceMessageVO=instanceMessageHandler.toVO4Admin(instanceMessage);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-InstanceMessage-edit");
		model.addObject("instanceMessage", adminInstanceMessageVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(InstanceMessage instanceMessage, String queryStr) {
		instanceMessageService.update(instanceMessage);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		instanceMessageService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
