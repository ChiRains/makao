package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class MVFileUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> whiteNameUris() {

		List<String> list = new ArrayList<String>();
		list.add("/mvFile/addFile4Html.do");
		return list;
	}
}
