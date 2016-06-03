package com.qcloud.project.macaovehicle.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.macaovehicle.service.ResultRecordsService;
import com.qcloud.project.macaovehicle.web.handler.ResultRecordsHandler;
		
@Controller
@RequestMapping(value = ResultRecordsController.DIR)
public class ResultRecordsController {
	
	public static final String DIR = "/resultRecords";
	
	@Autowired
	private ResultRecordsService resultRecordsService;
	@Autowired
	private ResultRecordsHandler resultRecordsHandler;

}
