package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.PeccancyCarService;
import com.qcloud.project.macaovehicle.web.handler.PeccancyCarHandler;
import com.qcloud.project.macaovehicle.web.vo.PeccancyCarVO;
		
@Controller
@RequestMapping(value = PeccancyCarController.DIR)
public class PeccancyCarController {
	
	public static final String DIR = "/peccancyCar";
	
	@Autowired
	private PeccancyCarService peccancyCarService;
	@Autowired
	private PeccancyCarHandler peccancyCarHandler;
	@Autowired
	private CarOwnerService carOwnerService;
	
	@Autowired
	private ClerkHelper clerkHelper;

	@RequestMapping
	public ModelAndView list(PPage pPage,PeccancyCarQuery peccancyCarQuery)
	{
		Page<PeccancyCar> page=peccancyCarService.page(peccancyCarQuery, pPage.getPageStart(), pPage.getPageSize());
		List<PeccancyCarVO> voList=peccancyCarHandler.toVOList(page.getData());
		FrontPagingView frontPagingView=new FrontPagingView(pPage.getPageNum(),
				pPage.getPageSize(), page.getCount());
		frontPagingView.addObject("result", voList);
		frontPagingView.addObject("query", peccancyCarQuery);
		return frontPagingView;
	}
	
	@RequestMapping
	public AceAjaxView add(HttpServletRequest request,PeccancyCar peccancyCar)
	{	
		Clerk clerk=clerkHelper.getClerk(request);
		AceAjaxView aceAjaxView=new AceAjaxView();
		if(clerk!=null)
		{
			peccancyCar.setCreateTime(new Date());
			peccancyCar.setCreatorId(clerk.getId());
			peccancyCarService.add(peccancyCar);
			aceAjaxView.setMessage("添加成功");
		}
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView get(Long peccancyCarId)
	{
		PeccancyCar peccancyCar=peccancyCarService.get(peccancyCarId);
		PeccancyCarVO peccancyCarVO=peccancyCarHandler.toVO(peccancyCar);
		AceAjaxView aceAjaxView=new AceAjaxView();
		aceAjaxView.addObject("result", peccancyCarVO);
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView edit(HttpServletRequest request,PeccancyCar peccancyCar)
	{
		Clerk clerk=clerkHelper.getClerk(request);
		AceAjaxView aceAjaxView=new AceAjaxView();
		if(clerk!=null)
		{
			peccancyCarService.update(peccancyCar);
			aceAjaxView.setMessage("修改成功");
		}
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(HttpServletRequest request,Long peccancyCarId)
	{
		Clerk clerk=clerkHelper.getClerk(request);
		AceAjaxView aceAjaxView=new AceAjaxView();
		if(clerk!=null)
		{
			peccancyCarService.delete(peccancyCarId);
			aceAjaxView.setMessage("删除成功");
		}
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView myList(PPage pPage,HttpServletRequest request)
	{
        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
		PeccancyCarQuery peccancyCarQuery=new PeccancyCarQuery();
		peccancyCarQuery.setCarOwnerId(carOwner.getId());
		Page<PeccancyCar> page=peccancyCarService.page(peccancyCarQuery, pPage.getPageStart(), pPage.getPageSize());
		List<PeccancyCarVO> voList=peccancyCarHandler.toVOList(page.getData());
		FrontPagingView frontPagingView=new FrontPagingView(pPage.getPageNum(),
				pPage.getPageSize(), page.getCount());
		frontPagingView.addObject("result", voList);
		frontPagingView.addObject("query", peccancyCarQuery);
		return frontPagingView;
	} 
}
