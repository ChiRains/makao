package com.qcloud.component.piratesship.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CallMeUriHandlerImpl extends AbstractUriHandler {

    @Override
    public List<String> whiteNameUris() {

        List<String> list = new ArrayList<String>();
        list.add("/callMe/list.do");
        list.add("/callMe/toAdd.do");
        list.add("/callMe/add.do");
        list.add("/callMe/take.do");
        list.add("/callMe/finish.do");
        list.add("/callMe/closed.do");
        return list;
    }
}
