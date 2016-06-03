package com.qcloud.component.organization.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.component.organization.service.UsergroupUserService;
import com.qcloud.component.organization.web.handler.UsergroupUserHandler;
		
@Controller
@RequestMapping(value = UsergroupUserController.DIR)
public class UsergroupUserController {
	
	public static final String DIR = "/usergroupUser";
	
	@Autowired
	private UsergroupUserService usergroupUserService;
	@Autowired
	private UsergroupUserHandler usergroupUserHandler;

}
