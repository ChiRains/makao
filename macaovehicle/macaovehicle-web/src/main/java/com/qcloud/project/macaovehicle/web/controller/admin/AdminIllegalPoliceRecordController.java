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
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.service.IllegalPoliceRecordService;
import com.qcloud.project.macaovehicle.web.handler.IllegalPoliceRecordHandler;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalPoliceRecordVO;
		
@Controller
@RequestMapping(value = "/" + AdminIllegalPoliceRecordController.DIR)
public class AdminIllegalPoliceRecordController {
	
	public static final String DIR = "admin/illegalPoliceRecord";
	
	@Autowired
	private IllegalPoliceRecordService illegalPoliceRecordService;
	@Autowired
	private IllegalPoliceRecordHandler illegalPoliceRecordHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, IllegalPoliceRecordQuery query) {
	    
		Page<IllegalPoliceRecord> page = illegalPoliceRecordService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminIllegalPoliceRecordVO> list = illegalPoliceRecordHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-IllegalPoliceRecord-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-IllegalPoliceRecord-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(IllegalPoliceRecord illegalPoliceRecord) {
		illegalPoliceRecordService.add(illegalPoliceRecord);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		IllegalPoliceRecord illegalPoliceRecord=illegalPoliceRecordService.get(id);
		AdminIllegalPoliceRecordVO adminIllegalPoliceRecordVO=illegalPoliceRecordHandler.toVO4Admin(illegalPoliceRecord);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-IllegalPoliceRecord-edit");
		model.addObject("illegalPoliceRecord", adminIllegalPoliceRecordVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(IllegalPoliceRecord illegalPoliceRecord, String queryStr) {
		illegalPoliceRecordService.update(illegalPoliceRecord);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		illegalPoliceRecordService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
