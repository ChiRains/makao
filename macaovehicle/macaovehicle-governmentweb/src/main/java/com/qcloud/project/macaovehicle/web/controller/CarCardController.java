package com.qcloud.project.macaovehicle.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.macaovehicle.service.CarCardService;
import com.qcloud.project.macaovehicle.web.handler.CarCardHandler;
		
@Controller
@RequestMapping(value = CarCardController.DIR)
public class CarCardController {
	
	public static final String DIR = "/carCard";
	
	@Autowired
	private CarCardService carCardService;
	@Autowired
	private CarCardHandler carCardHandler;

}
