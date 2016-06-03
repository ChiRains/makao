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
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.service.HistoryRecordsService;
import com.qcloud.project.macaovehicle.web.handler.HistoryRecordsHandler;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminHistoryRecordsVO;
		
@Controller
@RequestMapping(value = "/" + AdminHistoryRecordsController.DIR)
public class AdminHistoryRecordsController {
	
	public static final String DIR = "admin/historyRecords";
	
	@Autowired
	private HistoryRecordsService historyRecordsService;
	@Autowired
	private HistoryRecordsHandler historyRecordsHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, HistoryRecordsQuery query) {
	    
		Page<HistoryRecords> page = historyRecordsService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminHistoryRecordsVO> list = historyRecordsHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-HistoryRecords-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-HistoryRecords-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(HistoryRecords historyRecords) {
		historyRecordsService.add(historyRecords);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		HistoryRecords historyRecords=historyRecordsService.get(id);
		AdminHistoryRecordsVO adminHistoryRecordsVO=historyRecordsHandler.toVO4Admin(historyRecords);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-HistoryRecords-edit");
		model.addObject("historyRecords", adminHistoryRecordsVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(HistoryRecords historyRecords, String queryStr) {
		historyRecordsService.update(historyRecords);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		historyRecordsService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
