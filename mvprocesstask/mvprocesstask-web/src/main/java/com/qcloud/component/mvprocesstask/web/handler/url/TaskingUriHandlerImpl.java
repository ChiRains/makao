package com.qcloud.component.mvprocesstask.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TaskingUriHandlerImpl extends AbstractUriHandler {

    // @Override
    // public List<String> adminUris() {
    //
    // List<String> list = new ArrayList<String>();
    // list.add("/admin/tasking/list.do");
    // list.add("/admin/tasking/toAdd.do");
    // list.add("/admin/tasking/toEdit.do");
    // list.add("/admin/tasking/add.do");
    // list.add("/admin/tasking/edit.do");
    // return list;
    // }
    //
    // @Override
    // public List<String> permissionUris() {
    //
    // List<String> list = new ArrayList<String>();
    // list.add("/admin/tasking/list.do");
    // return list;
    // }
    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/tasking/list.do");
        list.add("/tasking/listDriverIncrease.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/tasking/list.do");
        list.add("/tasking/listDriverIncrease.do");
        return list;
    }
}
