package com.qcloud.component.organization.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.component.organization.service.SuperiorService;
import com.qcloud.component.organization.web.handler.SuperiorHandler;
		
@Controller
@RequestMapping(value = SuperiorController.DIR)
public class SuperiorController {
	
	public static final String DIR = "/superior";
	
	@Autowired
	private SuperiorService superiorService;
	@Autowired
	private SuperiorHandler superiorHandler;

}
