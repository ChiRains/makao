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
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.service.NeighbourhoodService;
import com.qcloud.component.publicdata.web.handler.NeighbourhoodHandler;
import com.qcloud.component.publicdata.model.query.NeighbourhoodQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminNeighbourhoodVO;
		
@Controller
@RequestMapping(value = "/" + AdminNeighbourhoodController.DIR)
public class AdminNeighbourhoodController {
	
	public static final String DIR = "admin/neighbourhood";
	
	@Autowired
	private NeighbourhoodService neighbourhoodService;
	@Autowired
	private NeighbourhoodHandler neighbourhoodHandler;
	@Autowired
    private PublicdataClient   publicdataClient;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, NeighbourhoodQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<Neighbourhood> page = neighbourhoodService.page(query, start, PAGE_SIZE);
		List<AdminNeighbourhoodVO> list = neighbourhoodHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/publicdata-Neighbourhood-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
	    List<String> provinceList = publicdataClient.listProvince();
        List<KeyValueVO> voList = publicdataClient.exchageStr(provinceList, null, null);
        ModelAndView model = new ModelAndView("/admin/publicdata-Neighbourhood-add");
        model.addObject("provinceList", voList);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Neighbourhood neighbourhood) {
		neighbourhoodService.add(neighbourhood);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Neighbourhood neighbourhood=neighbourhoodService.get(id);
		AdminNeighbourhoodVO adminNeighbourhoodVO=neighbourhoodHandler.toVO4Admin(neighbourhood);
		ModelAndView model = new ModelAndView("/admin/publicdata-Neighbourhood-edit");
		model.addObject("neighbourhood", adminNeighbourhoodVO);
        List<String> list = publicdataClient.listProvince();
        List<KeyValueVO> voList = publicdataClient.exchageStr(list, neighbourhood.getProvince(), "selected");
        model.addObject("provinceList", voList);
        List<String> cityList = publicdataClient.listCity(neighbourhood.getProvince());
        List<KeyValueVO> cityVOList = publicdataClient.exchageStr(cityList, neighbourhood.getCity(), "selected");
        model.addObject("cityList", cityVOList);
        List<String> districtList = publicdataClient.listDistrict(neighbourhood.getCity());
        List<KeyValueVO> districtVOList = publicdataClient.exchageStr(districtList, neighbourhood.getDistrict(), "selected");
        model.addObject("districtList", districtVOList);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Neighbourhood neighbourhood) {
		neighbourhoodService.update(neighbourhood);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		AceAjaxView aceAjaxView = new AceAjaxView();
		 if(neighbourhoodService.delete(id)){
		     aceAjaxView.setMessage("删除成功");
	     }else{
	         aceAjaxView.setMessage("删除失败");
	         aceAjaxView.setStatus(0);
	     }
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
