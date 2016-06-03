package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DriverVehicleUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/driverVehicle/list.do");
        list.add("/admin/driverVehicle/toAdd.do");
        list.add("/admin/driverVehicle/toEdit.do");
        list.add("/admin/driverVehicle/add.do");
        list.add("/admin/driverVehicle/edit.do");
        list.add("/driverVehicle/listEntryVehicle.do");
        list.add("/driverVehicle/getEntryVehicle.do");
        list.add("/driverVehicle/listEntryDriver.do");
        list.add("/driverVehicle/getEntryDriver.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/driverVehicle/list.do");
        return list;
    }
}
