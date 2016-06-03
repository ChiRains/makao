package com.qcloud.project.macaovehicle.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHandler;
		
@Controller
@RequestMapping(value = CarOwnerController.DIR)
public class CarOwnerController {
	
	public static final String DIR = "/carOwner";
	
	@Autowired
	private CarOwnerService carOwnerService;
	@Autowired
	private CarOwnerHandler carOwnerHandler;

}
