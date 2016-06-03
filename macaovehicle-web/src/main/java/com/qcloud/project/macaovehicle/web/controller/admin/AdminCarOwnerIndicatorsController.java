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
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.service.CarOwnerIndicatorsService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerIndicatorsHandler;
import com.qcloud.project.macaovehicle.model.query.CarOwnerIndicatorsQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerIndicatorsVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarOwnerIndicatorsController.DIR)
public class AdminCarOwnerIndicatorsController {
	
	public static final String DIR = "admin/carOwnerIndicators";
	
	@Autowired
	private CarOwnerIndicatorsService carOwnerIndicatorsService;
	@Autowired
	private CarOwnerIndicatorsHandler carOwnerIndicatorsHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, CarOwnerIndicatorsQuery query) {
	    
		Page<CarOwnerIndicators> page = carOwnerIndicatorsService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminCarOwnerIndicatorsVO> list = carOwnerIndicatorsHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarOwnerIndicators-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerIndicators-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarOwnerIndicators carOwnerIndicators) {
		carOwnerIndicatorsService.add(carOwnerIndicators);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarOwnerIndicators carOwnerIndicators=carOwnerIndicatorsService.get(id);
		AdminCarOwnerIndicatorsVO adminCarOwnerIndicatorsVO=carOwnerIndicatorsHandler.toVO4Admin(carOwnerIndicators);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerIndicators-edit");
		model.addObject("carOwnerIndicators", adminCarOwnerIndicatorsVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarOwnerIndicators carOwnerIndicators, String queryStr) {
		carOwnerIndicatorsService.update(carOwnerIndicators);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carOwnerIndicatorsService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
