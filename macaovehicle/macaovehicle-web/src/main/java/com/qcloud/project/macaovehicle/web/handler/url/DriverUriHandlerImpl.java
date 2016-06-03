package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DriverUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/driver/list.do");
        // list.add("/driver/add.do");
        // list.add("/driver/edit.do");
        // list.add("/driver/delete.do");
        // list.add("/driver/get.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/driver/list.do");
        list.add("/driver/add.do");
        list.add("/driver/edit.do");
        list.add("/driver/delete.do");
        list.add("/driver/get.do");
        list.add("/driver/cancellation.do");
        list.add("/driver/listAvail.do");
        return list;
    }
}
