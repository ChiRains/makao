package com.qcloud.component.admin.web.handler;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class AdminUriHandlerImpl extends AbstractUriHandler {
	@Override
	public List<String> whiteNameUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/toLogin.do");
		list.add("/admin/login.do");

        list.add("/admin/logout.do");//登出

		// list.add("/admin/module/list.do");
		// list.add("/admin/module/init.do");
		// list.add("/admin/project/init.do");
		//
		// list.add("/admin/module/toAdd.do");
		// list.add("/admin/module/add.do");
		// list.add("/admin/module/toEdit.do");
		// list.add("/admin/module/edit.do");
		// list.add("/admin/module/delete.do");
		//
		// list.add("/admin/project/toAdd.do");
		// list.add("/admin/project/add.do");
		// list.add("/admin/project/toEdit.do");
		// list.add("/admin/project/edit.do");
		// list.add("/admin/project/delete.do");
		//
		// list.add("/admin/index/login.do");
		// list.add("/admin/index/login2.do");

		return list;
	}

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/index.do");

		list.add("/admin/list.do");
		list.add("/admin/toAdd.do");
		list.add("/admin/toEdit.do");
		list.add("/admin/add.do");
		list.add("/admin/edit.do");
		list.add("/admin/delete.do");

		list.add("/admin/resetPsw.do");
		list.add("/admin/enable.do");
		
		list.add("/admin/grantList.do");
		list.add("/admin/toAdminPersonalInfo.do");	
		list.add("/admin/modify.do");	
		
		return list;
	}
}
