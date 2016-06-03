package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DemoUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/demo/carId.do");
        list.add("/demo/ciqBeian.do");
        list.add("/demo/customsBeian.do");
        list.add("/demo/notityCarReservation.do");
        list.add("/demo/notityCarInstallation.do");
        list.add("/demo/postOnekDataEnter.do");
        list.add("/demo/postOnekDataOut.do");
        return list;
    }
}
