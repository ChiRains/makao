package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TaskingCiqUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/taskingCiq/list.do");
        list.add("/admin/taskingCiq/toAdd.do");
        list.add("/admin/taskingCiq/toEdit.do");
        list.add("/admin/taskingCiq/add.do");
        list.add("/admin/taskingCiq/edit.do");
        list.add("/taskingCiq/list.do");
        list.add("/taskingCiq/listed.do");
        list.add("/taskingCiq/doTasking.do");
        list.add("/taskingCiq/get.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/taskingCiq/list.do");
        return list;
    }
    
    @Override
    public List<String> whiteNameUris() {
        List<String> list = new ArrayList<String>();
        list.add("/taskingCiq/exportFile.do");

        return list;
    }
}
