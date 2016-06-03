package com.qcloud.component.mvprocesstask.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class TaskedUriHandlerImpl extends AbstractUriHandler {

    // @Override
    // public List<String> adminUris() {
    // List<String> list = new ArrayList<String>();
    // list.add("/admin/tasked/list.do");
    // list.add("/admin/tasked/toAdd.do");
    // list.add("/admin/tasked/toEdit.do");
    // list.add("/admin/tasked/add.do");
    // list.add("/admin/tasked/edit.do");
    //
    // return list;
    // }
    //
    // @Override
    // public List<String> permissionUris() {
    // List<String> list = new ArrayList<String>();
    // list.add("/admin/tasked/list.do");
    // return list;
    // }
    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/tasked/list.do");
        list.add("/tasked/listDriverIncrease.do");
        return list;
    }
}
