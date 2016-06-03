package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class OptionsUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/options/list.do");
		list.add("/admin/options/toAdd.do");
		list.add("/admin/options/toEdit.do");
		list.add("/admin/options/add.do");
		list.add("/admin/options/edit.do");
		list.add("/admin/options/delete.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/options/list.do");
		return list;
	}
}
