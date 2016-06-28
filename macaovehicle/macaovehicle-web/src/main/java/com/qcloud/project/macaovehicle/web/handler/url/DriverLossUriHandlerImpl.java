package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DriverLossUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/driverLoss/list.do");
        list.add("/admin/driverLoss/toAdd.do");
        list.add("/admin/driverLoss/toEdit.do");
        list.add("/admin/driverLoss/add.do");
        list.add("/admin/driverLoss/edit.do");
        //
        list.add("/driverLoss/fillDriver.do");
        list.add("/driverLoss/sign.do");
        list.add("/driverLoss/list.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/driverLoss/list.do");
        return list;
    }
}
