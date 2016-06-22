package com.qcloud.project.macaovehicle.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;
import com.qcloud.project.macaovehicle.service.DvrAreaService;
import com.qcloud.project.macaovehicle.service.DvrDetailService;
import com.qcloud.project.macaovehicle.web.handler.DvrAreaHandler;
import com.qcloud.project.macaovehicle.web.handler.DvrDetailHandler;
import com.qcloud.project.macaovehicle.web.vo.DvrAreaVO;

@Controller
@RequestMapping(value = DvrDetailController.DIR)
public class DvrDetailController {

	public static final String DIR = "/dvrDetail";

	@Autowired
	private DvrDetailService dvrDetailService;
	@Autowired
	private DvrDetailHandler dvrDetailHandler;
	@Autowired
	private DvrAreaService dvrAreaService;
	@Autowired
	private ClerkHelper clerkHelper;
	@Autowired
	private DvrAreaHandler dvrAreaHandler;

	/**
	 * 位置：岛内监控-设备信息 查看DVR列表 根据左侧分组列表可以进行筛选显示
	 * 
	 * @param query
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping
	public FrontPagingView listDvr(DvrDetailQuery query, Integer pageNum, Integer pageSize) {
		final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		Page<DvrDetail> page = dvrDetailService.page(query, start, PAGE_SIZE);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (DvrDetail dvrDetail : page.getData()) {
			DvrArea dvrArea = dvrAreaService.get(dvrDetail.getAreaId());
			Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
			if (dvrArea.getStatus() == 1) {
				returnMap.put("id", dvrDetail.getId());
				returnMap.put("area", dvrArea.getName());// DVR所在地区(分组)
				returnMap.put("username", dvrDetail.getUsername());// DVR用户名
				// returnMap.put("password", dvrDetail.getPassword());// DVR密码
				returnMap.put("name", dvrDetail.getName());// DVR设备名称
				returnMap.put("ip", dvrDetail.getIp());// DVR设备IP地址
				returnMap.put("port", dvrDetail.getPort());// DVR设备端口
				returnMap.put("vendor", dvrDetail.getVendor());// DVR设备生产厂家
				returnMap.put("direction", dvrDetail.getDirection());// 拍摄方向
				returnMap.put("operator", dvrDetail.getOperator());// 操作人
				returnMap.put("lastModifiedTime", sdf.format(dvrDetail.getLastModifiedTime()));// 最后修改时间
				returnMap.put("status", dvrDetail.getStatus());// 是否启用(1启用, 0不启用)
			}else{
				returnMap.put("message", "暂无数据，该分组未启用");
			}
			list.add(returnMap);
		}
		FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
		view.setList(list);
		return view;
	}

	/**
	 * 列出DVR列表（附带分组信息）
	 * 
	 * @return
	 * 
	 */
	@RequestMapping
	public FrontAjaxView listAllDvr() {
		List<DvrArea> areaList = dvrAreaService.listAll();
		List<DvrAreaVO> voList = dvrAreaHandler.toVOList(areaList);
		FrontAjaxView view = new FrontAjaxView();
		view.addObject("totalList", voList);
		return view;
	}

	/**
	 * 添加DVR设备
	 * 
	 * @param request
	 * @param dvrArea
	 * @return
	 */
	@RequestMapping
	public FrontAjaxView add(HttpServletRequest request, DvrDetail dvrDetail) {
		// 获取当前登录用户
		Clerk curClerk = clerkHelper.getClerk(request);
		List<String> frontList = new ArrayList<String>();
		List<DvrArea> areaList = dvrAreaService.listAll();
		for (DvrArea dvrArea : areaList) {
			// 将已启用的分组返回给前端
			if (dvrArea.getStatus() != 0) {
				frontList.add(dvrArea.getName());
			}
		}
		dvrDetail.setOperator(curClerk.getName());
		dvrDetail.setLastModifiedTime(new Date());
		dvrDetailService.add(dvrDetail);
		FrontAjaxView view = new FrontAjaxView();
		view.addObject("frontList", frontList);
		view.setMessage("添加成功");
		return view;
	}

	/**
	 * 修改DVR设备，删除也属于编辑(把状态变为不可用)
	 * 
	 * @param request
	 * @param dvrArea
	 * @return
	 */
	@RequestMapping
	public FrontAjaxView update(HttpServletRequest request, DvrDetail dvrDetail) {
		List<String> frontList = new ArrayList<String>();
		Clerk curClerk = clerkHelper.getClerk(request);//
		List<DvrArea> areaList = dvrAreaService.listAll();
		for (DvrArea dvrArea : areaList) {
			// 将已启用的分组返回给前端
			if (dvrArea.getStatus() != 0) {
				frontList.add(dvrArea.getName());
			}
		}
		dvrDetail.setOperator(curClerk.getName());
		dvrDetail.setLastModifiedTime(new Date());
		dvrDetailService.update(dvrDetail);
		FrontAjaxView view = new FrontAjaxView();
		view.addObject("frontList", frontList);
		view.setMessage("修改成功");
		return view;
	}

	/**
	 * 查看DVR设备
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping
	public FrontAjaxView get(HttpServletRequest request, Long id) {
		DvrDetail dvrDetail = dvrDetailService.get(id);
		FrontAjaxView view = new FrontAjaxView();
		view.addObject("dvrDetail", dvrDetail);
		return view;
	}

	@RequestMapping
	public FrontAjaxView register(HttpServletRequest request, Long id) {
		DvrDetail dvrDetail = dvrDetailService.get(id);
		FrontAjaxView view = new FrontAjaxView();
		view.addObject("username", dvrDetail.getUsername());
		view.addObject("password", dvrDetail.getPassword());
		view.addObject("ip", dvrDetail.getIp());
		view.addObject("port", dvrDetail.getPort());
		view.setMessage("登录成功");
		return view;
	}
}
