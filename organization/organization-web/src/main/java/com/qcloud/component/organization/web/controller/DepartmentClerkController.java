package com.qcloud.component.organization.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.component.organization.service.DepartmentClerkService;
import com.qcloud.component.organization.web.handler.DepartmentClerkHandler;
		
@Controller
@RequestMapping(value = DepartmentClerkController.DIR)
public class DepartmentClerkController {
	
	public static final String DIR = "/departmentClerk";
	
	@Autowired
	private DepartmentClerkService departmentClerkService;
	@Autowired
	private DepartmentClerkHandler departmentClerkHandler;

}
