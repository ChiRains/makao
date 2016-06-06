package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class NeighbourhoodUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
//		list.add("/admin/neighbourhood/list.do");
//		list.add("/admin/neighbourhood/toAdd.do");
//		list.add("/admin/neighbourhood/toEdit.do");
//		list.add("/admin/neighbourhood/add.do");
//		list.add("/admin/neighbourhood/edit.do");
//		list.add("/admin/neighbourhood/delete.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
//		list.add("/admin/neighbourhood/list.do");
		return list;
	}

    @Override
    public List<String> whiteNameUris() {
        List<String> list = new ArrayList<String>();
//        list.add("/admin/neighbourhood/list.do");
        //////////////////////////////////////////////////////////////////////
        list.add("/app/neighbourhood/centerList.do");
        return list;
    }
    
    @Override
    public List<String> appUris() {
        List<String> list = new ArrayList<String>();
        list.add("/app/neighbourhood/centerList.do");
        return list;
    }
}
