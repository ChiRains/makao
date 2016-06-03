package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProcessProgressUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/processProgress/list.do");
        // list.add("/admin/processProgress/toAdd.do");
        // list.add("/admin/processProgress/toEdit.do");
        // list.add("/admin/processProgress/add.do");
        // list.add("/admin/processProgress/edit.do");
        list.add("/processProgress/list.do");
        list.add("/processProgress/get.do");
        list.add("/processProgress/listType.do");
        list.add("/processProgress/rollBack.do");
        list.add("/processProgress/getAvailVehicle.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/admin/processProgress/list.do");
        return list;
    }
}
