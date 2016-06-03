package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TaskingCustomsUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/taskingCustoms/list.do");
        list.add("/admin/taskingCustoms/toAdd.do");
        list.add("/admin/taskingCustoms/toEdit.do");
        list.add("/admin/taskingCustoms/add.do");
        list.add("/admin/taskingCustoms/edit.do");
        list.add("/taskingCustoms/list.do");
        list.add("/taskingCustoms/listed.do");
        list.add("/taskingCustoms/doTasking.do");
        list.add("/taskingCustoms/get.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/taskingCustoms/list.do");
        return list;
    }
    
    @Override
    public List<String> whiteNameUris() {
        List<String> list = new ArrayList<String>();
        list.add("/taskingCustoms/exportFile.do");
        return list;
    }
}
