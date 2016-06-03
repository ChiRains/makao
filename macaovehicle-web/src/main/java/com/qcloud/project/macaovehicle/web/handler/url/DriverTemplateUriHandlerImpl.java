package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DriverTemplateUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/driverTemplate/list.do");
        list.add("/admin/driverTemplate/toAdd.do");
        list.add("/admin/driverTemplate/toEdit.do");
        list.add("/admin/driverTemplate/add.do");
        list.add("/admin/driverTemplate/edit.do");
        list.add("/driverTemplate/list.do");
        list.add("/driverTemplate/add.do");
        list.add("/driverTemplate/edit.do");
        list.add("/driverTemplate/deleteAll.do");
        list.add("/driverTemplate/get.do");
        list.add("/driverTemplate/delete.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/driverTemplate/list.do");
        return list;
    }
}
