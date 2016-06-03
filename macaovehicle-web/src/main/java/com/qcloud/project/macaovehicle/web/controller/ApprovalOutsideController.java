package com.qcloud.project.macaovehicle.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.macaovehicle.service.ApprovalOutsideService;
import com.qcloud.project.macaovehicle.web.handler.ApprovalOutsideHandler;
		
@Controller
@RequestMapping(value = ApprovalOutsideController.DIR)
public class ApprovalOutsideController {
	
	public static final String DIR = "/approvalOutside";
	
	@Autowired
	private ApprovalOutsideService approvalOutsideService;
	@Autowired
	private ApprovalOutsideHandler approvalOutsideHandler;

}
