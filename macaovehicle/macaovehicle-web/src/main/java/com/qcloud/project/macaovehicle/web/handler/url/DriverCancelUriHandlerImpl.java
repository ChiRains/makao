package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DriverCancelUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/driverCancel/list.do");
        list.add("/admin/driverCancel/toAdd.do");
        list.add("/admin/driverCancel/toEdit.do");
        list.add("/admin/driverCancel/add.do");
        list.add("/admin/driverCancel/edit.do");
        list.add("/driverCancel/list.do");
        list.add("/driverCancel/changeState.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/driverCancel/list.do");
        return list;
    }
}
