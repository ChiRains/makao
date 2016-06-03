package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class VehicleProcessUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> userUris() {

        List<String> list = new ArrayList<String>();
        // list.add("/vehicleProcess/listVehicleProcesses.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/vehicleProcess/listVehicleProcesses.do");
        list.add("/vehicleProcess/getVehicleProcesses.do");
        return list;
    }
}
