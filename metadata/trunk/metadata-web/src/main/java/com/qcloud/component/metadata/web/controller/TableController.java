package com.qcloud.component.metadata.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.component.metadata.service.TableService;
import com.qcloud.component.metadata.web.handler.TableHandler;
		
@Controller
@RequestMapping(value = TableController.DIR)
public class TableController {
	
	public static final String DIR = "/table";
	
	@Autowired
	private TableService tableService;
	@Autowired
	private TableHandler tableHandler;

}
