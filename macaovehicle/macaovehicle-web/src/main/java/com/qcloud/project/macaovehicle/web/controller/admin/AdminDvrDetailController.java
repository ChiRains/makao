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
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.service.DvrDetailService;
import com.qcloud.project.macaovehicle.web.handler.DvrDetailHandler;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDvrDetailVO;
		
@Controller
@RequestMapping(value = "/" + AdminDvrDetailController.DIR)
public class AdminDvrDetailController {
	
	public static final String DIR = "admin/dvrDetail";
	
	@Autowired
	private DvrDetailService dvrDetailService;
	@Autowired
	private DvrDetailHandler dvrDetailHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, DvrDetailQuery query) {
	    
		Page<DvrDetail> page = dvrDetailService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminDvrDetailVO> list = dvrDetailHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-DvrDetail-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-DvrDetail-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(DvrDetail dvrDetail) {
		dvrDetailService.add(dvrDetail);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		DvrDetail dvrDetail=dvrDetailService.get(id);
		AdminDvrDetailVO adminDvrDetailVO=dvrDetailHandler.toVO4Admin(dvrDetail);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-DvrDetail-edit");
		model.addObject("dvrDetail", adminDvrDetailVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(DvrDetail dvrDetail, String queryStr) {
		dvrDetailService.update(dvrDetail);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		dvrDetailService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
