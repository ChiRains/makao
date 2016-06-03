package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CardUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {
        List<String> list = new ArrayList<String>();
        list.add("/card/sendDriverCard/");
        list.add("/card/sendCarCard/");
        return list;
    }

    @Override
    public List<String> restfulUris() {

        List<String> list = new ArrayList<String>();
        list.add("/card/sendDriverCard/");
        list.add("/card/sendCarCard/");
        return list;
    }
    
    
}
