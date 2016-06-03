package com.qcloud.project.macaovehicle.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.web.handler.DriverHandler;
		
@Controller
@RequestMapping(value = DriverController.DIR)
public class DriverController {
	
	public static final String DIR = "/driver";
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private DriverHandler driverHandler;

}
