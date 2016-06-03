package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class MessageTypeUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
//		list.add("/admin/messageType/list.do");
//		list.add("/admin/messageType/toAdd.do");
//		list.add("/admin/messageType/toEdit.do");
//		list.add("/admin/messageType/add.do");
//		list.add("/admin/messageType/edit.do");		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
//		list.add("/admin/messageType/list.do");
		return list;
	}
}
