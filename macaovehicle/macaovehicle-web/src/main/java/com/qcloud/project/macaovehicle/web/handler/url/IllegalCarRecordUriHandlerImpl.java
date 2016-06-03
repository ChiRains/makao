package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class IllegalCarRecordUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/illegalCarRecord/list.do");
        list.add("/illegalCarRecord/add.do");
        list.add("/illegalCarRecord/get.do");
        list.add("/illegalCarRecord/edit.do");
        list.add("/illegalCarRecord/del.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/illegalCarRecord/list.do");
        return list;
    }
}
