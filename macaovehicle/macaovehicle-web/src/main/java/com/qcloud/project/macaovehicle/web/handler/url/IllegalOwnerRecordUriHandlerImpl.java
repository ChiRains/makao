package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class IllegalOwnerRecordUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/illegalOwnerRecord/list.do");
        list.add("/illegalOwnerRecord/add.do");
        list.add("/illegalOwnerRecord/get.do");
        list.add("/illegalOwnerRecord/edit.do");
        list.add("/illegalOwnerRecord/del.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/illegalOwnerRecord/list.do");
        return list;
    }
}
