package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class VehicleUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/vehicle/list.do");
        // list.add("/vehicle/edit.do");
        // list.add("/vehicle/add.do");
        // list.add("/vehicle/delete.do");
        // list.add("/vehicle/get.do");
        // 枚举
        list.add("/vehicle/carModels.do");
        list.add("/vehicle/FuelType.do");
        list.add("/vehicle/SteeringWheel.do");
        //
        list.add("/vehicle/listAll.do");
        list.add("/vehicle/cancellation.do");
        return list;
    }

    @Override
    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/vehicle/list.do");
        list.add("/vehicle/edit.do");
        list.add("/vehicle/add.do");
        list.add("/vehicle/delete.do");
        list.add("/vehicle/get.do");
        list.add("/vehicle/listAvail.do");
        // 枚举
        // list.add("/vehicle/carModels.do");
        // list.add("/vehicle/FuelType.do");
        // list.add("/vehicle/SteeringWheel.do");
        //
        // list.add("/vehicle/listAll.do");
        return list;
    }
}
