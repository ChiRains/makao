package com.qcloud.component.publicdata.web.controller.admin;

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
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.service.ImageInformationService;
import com.qcloud.component.publicdata.web.handler.ImageInformationHandler;
import com.qcloud.component.publicdata.model.query.ImageInformationQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminImageInformationVO;
		
@Controller
@RequestMapping(value = "/" + AdminImageInformationController.DIR)
public class AdminImageInformationController {
	
	public static final String DIR = "admin/imageInformation";
	
	@Autowired
	private ImageInformationService imageInformationService;
	@Autowired
	private ImageInformationHandler imageInformationHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, ImageInformationQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<ImageInformation> page = imageInformationService.page(query, start, PAGE_SIZE);
		List<AdminImageInformationVO> list = imageInformationHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/publicdata-ImageInformation-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/publicdata-ImageInformation-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(ImageInformation imageInformation) {
		imageInformationService.add(imageInformation);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		ImageInformation imageInformation=imageInformationService.get(id);
		AdminImageInformationVO adminImageInformationVO=imageInformationHandler.toVO4Admin(imageInformation);
		ModelAndView model = new ModelAndView("/admin/publicdata-ImageInformation-edit");
		model.addObject("imageInformation", adminImageInformationVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(ImageInformation imageInformation) {
		imageInformationService.update(imageInformation);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		imageInformationService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
