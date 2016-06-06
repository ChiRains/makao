package com.qcloud.component.organization.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.service.UsergroupService;
import com.qcloud.component.organization.web.handler.UsergroupHandler;
import com.qcloud.component.publicdata.IntKeyValue;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.web.security.annotation.NoReferer;
		
@Controller
@RequestMapping(value = UsergroupController.DIR)
public class UsergroupController {
	
	public static final String DIR = "/usergroup";
	
	@Autowired
	private UsergroupService usergroupService;
	@Autowired
	private UsergroupHandler usergroupHandler;
	
	@Autowired
	private PublicdataClient publicdataClient;
	
	@RequestMapping
    @NoReferer
    public FrontAjaxView listUsergroup(){
        List<Usergroup> list=usergroupService.listAll();
       /* List<IntKeyValue> kvList=new ArrayList<IntKeyValue>();
        for(Usergroup usergroup:list){
            kvList.add(usergroup);
        }*/
//        List<KeyValueVO> voList=publicdataClient.exchageObj(kvList, -1, "selected");
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("usergroupList",list);
        return view;
    }

}
