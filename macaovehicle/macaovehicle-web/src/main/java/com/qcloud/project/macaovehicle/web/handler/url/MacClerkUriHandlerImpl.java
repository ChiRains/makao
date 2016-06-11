package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class MacClerkUriHandlerImpl extends AbstractUriHandler {

    public List<String> adminUris() {

        List<String> list = new ArrayList<String>();
        list.add("/macClerk/addClerk.do");
        list.add("/macClerk/list.do");
        list.add("/macClerk/getClerk.do");
        list.add("/macClerk/updateClerk.do");
        list.add("/macClerk/changeClerk.do");
        list.add("/macClerk/menuList.do");
        return list;
    }

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/macClerk/addClerk.do");
        return list;
    }
}
