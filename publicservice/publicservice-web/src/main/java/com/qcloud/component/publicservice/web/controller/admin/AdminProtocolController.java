package com.qcloud.component.publicservice.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qcloud.component.publicservice.model.ProtocolConfig;
import com.qcloud.component.publicservice.service.ProtocolConfigService;
import com.qcloud.pirates.mvc.AceAjaxView;

@Controller
@RequestMapping(value = "/" + AdminProtocolController.DIR)
public class AdminProtocolController {

	public final static String DIR = "admin/protocolConfig";

	@Autowired
	public ProtocolConfigService protocolConfigService;

	@RequestMapping
	public ModelAndView getProtocolConfig() {
		ProtocolConfig config = protocolConfigService.get();
		ModelAndView modelAndView = new ModelAndView(
				"/admin/publicservice-ProtocolConfig-edit");
		modelAndView.addObject("config", config);
		return modelAndView;
	}

	@RequestMapping
	public AceAjaxView setProtocolConfig(ProtocolConfig protocolConfig) {
		protocolConfigService.set(protocolConfig);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("修改成功");
		aceAjaxView.setUrl(DIR + "/getProtocolConfig");
		return aceAjaxView;
	}

}
