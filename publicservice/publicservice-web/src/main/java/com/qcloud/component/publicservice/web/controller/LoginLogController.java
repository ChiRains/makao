package com.qcloud.component.publicservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.component.publicservice.service.LoginLogService;
import com.qcloud.component.publicservice.web.handler.LoginLogHandler;
		
@Controller
@RequestMapping(value = LoginLogController.DIR)
public class LoginLogController {
	
	public static final String DIR = "/loginLog";
	
	@Autowired
	private LoginLogService loginLogService;
	@Autowired
	private LoginLogHandler loginLogHandler;

}
