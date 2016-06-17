package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DvrAreaUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/dvrArea/list.do");
		list.add("/admin/dvrArea/toAdd.do");
		list.add("/admin/dvrArea/toEdit.do");
		list.add("/admin/dvrArea/add.do");
		list.add("/admin/dvrArea/edit.do");
		list.add("/dvrArea/listArea.do");
		list.add("/dvrArea/get.do");
		list.add("/dvrArea/update.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/dvrArea/list.do");
		return list;
	}
	
	@Override
	public List<String> whiteNameUris(){
		List<String> list = new ArrayList<String>();
		list.add("/dvrArea/add.do");
		list.add("/dvrArea/edit.do");
		return list;
	}
}
