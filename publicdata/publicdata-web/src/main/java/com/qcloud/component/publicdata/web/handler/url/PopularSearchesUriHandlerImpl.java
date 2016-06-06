package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class PopularSearchesUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/admin/popularSearches/list.do");
//        list.add("/admin/popularSearches/toAdd.do");
//        list.add("/admin/popularSearches/toEdit.do");
//        list.add("/admin/popularSearches/add.do");
//        list.add("/admin/popularSearches/edit.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
//        list.add("/admin/popularSearches/list.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/popularSearches/list.do");
        return list;
    }
}
