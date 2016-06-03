package com.qcloud.project.macaovehicle.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.VehicleHandler;
		
@Controller
@RequestMapping(value = VehicleController.DIR)
public class VehicleController {
	
	public static final String DIR = "/vehicle";
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleHandler vehicleHandler;

}
