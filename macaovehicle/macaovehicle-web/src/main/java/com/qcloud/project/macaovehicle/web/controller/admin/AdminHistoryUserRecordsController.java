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
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.service.HistoryUserRecordsService;
import com.qcloud.project.macaovehicle.web.handler.HistoryUserRecordsHandler;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminHistoryUserRecordsVO;
		
@Controller
@RequestMapping(value = "/" + AdminHistoryUserRecordsController.DIR)
public class AdminHistoryUserRecordsController {
	
	public static final String DIR = "admin/historyUserRecords";
	
	@Autowired
	private HistoryUserRecordsService historyUserRecordsService;
	@Autowired
	private HistoryUserRecordsHandler historyUserRecordsHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, HistoryUserRecordsQuery query) {
	    
		Page<HistoryUserRecords> page = historyUserRecordsService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminHistoryUserRecordsVO> list = historyUserRecordsHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-HistoryUserRecords-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-HistoryUserRecords-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(HistoryUserRecords historyUserRecords) {
		historyUserRecordsService.add(historyUserRecords);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		HistoryUserRecords historyUserRecords=historyUserRecordsService.get(id);
		AdminHistoryUserRecordsVO adminHistoryUserRecordsVO=historyUserRecordsHandler.toVO4Admin(historyUserRecords);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-HistoryUserRecords-edit");
		model.addObject("historyUserRecords", adminHistoryUserRecordsVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(HistoryUserRecords historyUserRecords, String queryStr) {
		historyUserRecordsService.update(historyUserRecords);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		historyUserRecordsService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
