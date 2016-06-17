package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;
import com.qcloud.project.macaovehicle.service.DvrAreaService;
import com.qcloud.project.macaovehicle.web.handler.DvrAreaHandler;
import com.qcloud.project.macaovehicle.web.vo.DvrAreaVO;
		
@Controller
@RequestMapping(value = DvrAreaController.DIR)
public class DvrAreaController {
	
	public static final String DIR = "/dvrArea";
	
	@Autowired
	private DvrAreaService dvrAreaService;
	@Autowired
	private DvrAreaHandler dvrAreaHandler;
	
	/**
	 * 查看地区(分组)列表
	 * @param query
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping
	public FrontPagingView listArea(DvrAreaQuery query, Integer pageNum, Integer pageSize) {
		final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<DvrArea> page = dvrAreaService.page(query, start, PAGE_SIZE);
        List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
        for(DvrArea dvrArea : page.getData()) {
        	Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
        	returnMap.put("id", dvrArea.getId());
        	returnMap.put("name",dvrArea.getName());//地区(分组)名字
        	returnMap.put("status", dvrArea.getStatus());//是否启用(1启用, 0不启用)
        	list.add(returnMap);
        }
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setList(list);
        return view;
	}
	/**
	 * 查看某一地区(分组)
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping
	public FrontAjaxView get(HttpServletRequest request, Long id) {
		DvrArea area = dvrAreaService.get(id);
		FrontAjaxView view = new FrontAjaxView();
		view.addObject("area", area);
		return view;
	}
	/**
	 * 添加地区(分组)
	 * @param request
	 * @param dvrArea
	 * @return
	 */
	@RequestMapping
	public FrontAjaxView add(HttpServletRequest request, DvrArea dvrArea) {
		dvrAreaService.add(dvrArea);
		FrontAjaxView view = new FrontAjaxView();
		view.setMessage("添加成功");
		return view;
	}
	/**
	 * 编辑地区(分组)，删除也属于编辑(把状态变为不可用)
	 * @param request
	 * @param dvrArea
	 * @return
	 */
	@RequestMapping
	public FrontAjaxView update(HttpServletRequest request, DvrArea dvrArea) {
		dvrAreaService.update(dvrArea);
		FrontAjaxView view = new FrontAjaxView();
		view.setMessage("修改成功");
		return view;
	}
}
