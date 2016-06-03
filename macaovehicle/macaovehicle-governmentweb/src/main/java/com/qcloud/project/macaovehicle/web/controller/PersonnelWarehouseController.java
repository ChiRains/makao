package com.qcloud.project.macaovehicle.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.macaovehicle.service.PersonnelWarehouseService;
import com.qcloud.project.macaovehicle.web.handler.PersonnelWarehouseHandler;
		
@Controller
@RequestMapping(value = PersonnelWarehouseController.DIR)
public class PersonnelWarehouseController {
	
	public static final String DIR = "/personnelWarehouse";
	
	@Autowired
	private PersonnelWarehouseService personnelWarehouseService;
	@Autowired
	private PersonnelWarehouseHandler personnelWarehouseHandler;

}
