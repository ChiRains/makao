package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class VehicleLossUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/vehicleLoss/list.do");
        list.add("/admin/vehicleLoss/toAdd.do");
        list.add("/admin/vehicleLoss/toEdit.do");
        list.add("/admin/vehicleLoss/add.do");
        list.add("/admin/vehicleLoss/edit.do");
        //
        list.add("/vehicleLoss/lossVehicle.do");
        list.add("/vehicleLoss/fillVehicle.do");
        list.add("/vehicleLoss/sign.do");
        list.add("/vehicleLoss/list.do");
        return list;
    }

    @Override
    public List<String> permissionUris() {

        List<String> list = new ArrayList<String>();
        list.add("/admin/vehicleLoss/list.do");
        return list;
    }
}
