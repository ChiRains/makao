package com.qcloud.component.organization.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.component.organization.service.PostRoleService;
import com.qcloud.component.organization.web.handler.PostRoleHandler;
		
@Controller
@RequestMapping(value = PostRoleController.DIR)
public class PostRoleController {
	
	public static final String DIR = "/postRole";
	
	@Autowired
	private PostRoleService postRoleService;
	@Autowired
	private PostRoleHandler postRoleHandler;

}
