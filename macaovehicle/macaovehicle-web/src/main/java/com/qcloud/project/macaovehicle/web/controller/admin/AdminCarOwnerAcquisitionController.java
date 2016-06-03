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
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.service.CarOwnerAcquisitionService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerAcquisitionHandler;
import com.qcloud.project.macaovehicle.model.query.CarOwnerAcquisitionQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerAcquisitionVO;
		
@Controller
@RequestMapping(value = "/" + AdminCarOwnerAcquisitionController.DIR)
public class AdminCarOwnerAcquisitionController {
	
	public static final String DIR = "admin/carOwnerAcquisition";
	
	@Autowired
	private CarOwnerAcquisitionService carOwnerAcquisitionService;
	@Autowired
	private CarOwnerAcquisitionHandler carOwnerAcquisitionHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, CarOwnerAcquisitionQuery query) {
	    
		Page<CarOwnerAcquisition> page = carOwnerAcquisitionService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminCarOwnerAcquisitionVO> list = carOwnerAcquisitionHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-CarOwnerAcquisition-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerAcquisition-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(CarOwnerAcquisition carOwnerAcquisition) {
		carOwnerAcquisitionService.add(carOwnerAcquisition);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		CarOwnerAcquisition carOwnerAcquisition=carOwnerAcquisitionService.get(id);
		AdminCarOwnerAcquisitionVO adminCarOwnerAcquisitionVO=carOwnerAcquisitionHandler.toVO4Admin(carOwnerAcquisition);
		ModelAndView model = new ModelAndView("/admin/macaovehicle-CarOwnerAcquisition-edit");
		model.addObject("carOwnerAcquisition", adminCarOwnerAcquisitionVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(CarOwnerAcquisition carOwnerAcquisition, String queryStr) {
		carOwnerAcquisitionService.update(carOwnerAcquisition);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		carOwnerAcquisitionService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
