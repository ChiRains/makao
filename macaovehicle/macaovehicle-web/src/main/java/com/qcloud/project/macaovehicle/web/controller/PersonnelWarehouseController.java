package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
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
	
	
	@RequestMapping
	public FrontAjaxView add(HttpServletRequest request,PersonnelWarehouse personnelWarehouse){
	    personnelWarehouse.setTime(new Date());
	    personnelWarehouseService.add(personnelWarehouse);
	    FrontAjaxView view=new FrontAjaxView();
	    view.setMessage("录入人员库成功");
	    return view;
	}
	

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request,PersonnelWarehouse personnelWarehouse){
        personnelWarehouse.setTime(new Date());
        personnelWarehouseService.add(personnelWarehouse);
        FrontAjaxView view=new FrontAjaxView();
        view.setMessage("编辑人员信息成功");
        return view;
    }

}
