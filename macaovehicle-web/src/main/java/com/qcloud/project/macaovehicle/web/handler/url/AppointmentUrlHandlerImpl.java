package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class AppointmentUrlHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/appointment/notityCarReservation/");
        list.add("/appointment/notityDriverReservation/");
        list.add("/appointment/notityCarFirstInstallation/");
        list.add("/appointment/notityDriverFirstInstallation/");
        list.add("/appointment/notityCarInstallation/");
        list.add("/appointment/notityDriverInstallation/");
        
        list.add("/appointment/receiveId/");
        list.add("/appointment/receiveTime/");
        list.add("/appointment/notifyWarning/");
        return list;
    }

    @Override
    public List<String> restfulUris() {
        List<String> list = new ArrayList<String>();
        list.add("/appointment/notityCarReservation/");
        list.add("/appointment/notityDriverReservation/");
        list.add("/appointment/notityCarFirstInstallation/");
        list.add("/appointment/notityDriverFirstInstallation/");
        list.add("/appointment/notityCarInstallation/");
        list.add("/appointment/notityDriverInstallation/");
        
        list.add("/appointment/receiveId/");
        list.add("/appointment/receiveTime/");
        list.add("/appointment/notifyWarning/");
        return list;
    }       
}
