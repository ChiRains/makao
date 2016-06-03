package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class Classify4TypeUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/classify4Type/list.do");
        list.add("/admin/classify4Type/toAdd.do");
        list.add("/admin/classify4Type/toEdit.do");
        list.add("/admin/classify4Type/add.do");
        list.add("/admin/classify4Type/edit.do");
        list.add("/admin/classify4Type/upward.do");
        list.add("/admin/classify4Type/down.do");
        list.add("/admin/classify4Type/top.do");
        list.add("/admin/classify4Type/enable.do");
        list.add("/admin/classify4Type/disable.do");
        list.add("/admin/classify4Type/withoutDelete.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/classify4Type/list.do");
        list.add("/admin/classify4Type/toAdd.do");
        list.add("/admin/classify4Type/add.do");
        list.add("/admin/classify4Type/toEdit.do");
        list.add("/admin/classify4Type/edit.do");
        //
        list.add("/admin/classify4Type/upward.do");
        list.add("/admin/classify4Type/top.do");
        list.add("/admin/classify4Type/down.do");
        //
        list.add("/admin/classify4Type/enable.do");
        list.add("/admin/classify4Type/disable.do");
        list.add("/admin/classify4Type/withoutDelete.do");
        return list;
    }
}
