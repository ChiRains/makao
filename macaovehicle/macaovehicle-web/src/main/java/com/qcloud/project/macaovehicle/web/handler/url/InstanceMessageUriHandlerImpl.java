package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class InstanceMessageUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/instanceMessage/list.do");
		list.add("/admin/instanceMessage/toAdd.do");
		list.add("/admin/instanceMessage/toEdit.do");
		list.add("/admin/instanceMessage/add.do");
		list.add("/admin/instanceMessage/edit.do");
		list.add("/instanceMessage/list.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/instanceMessage/list.do");
		return list;
	}
}
